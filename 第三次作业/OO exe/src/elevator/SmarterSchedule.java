package elevator;

import java.util.ArrayList;
import java.util.Scanner;

public class SmarterSchedule extends Dispatcher {
    private ArrayList<AimFloor> aimfloorlist;
    private AimFloor aim;
    private int index;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入请求队列，以空格分隔，以换行结束");
		String s=scan.nextLine();
		Elevator e=new Elevator();
		RequestQueue rq=new RequestQueue();
		SmarterSchedule sm=new SmarterSchedule();
		if(rq.ParseReq(s))
		{
		sm.ALS_Schedule(e, rq);;
		}
		
		

	}
	public SmarterSchedule()
	{
		
	}
	public void ALS_Schedule(Elevator e,RequestQueue rq)
	{
		while(rq.getRequestList().size()>0)
		{
			aim=new AimFloor(rq.getRequestList().get(0));
			
			e.setCurTime(Math.max(e.getCurTime(), aim.getMainRequest().getTime()));
			e.setDirection(aim.getFloor()>e.getCurFloor()?"UP":"DOWN");
		for(int i=1;i<rq.getRequestList().size();i++)
		{
			
			if(CarryStandardsCheck(rq.getRequestList().get(i),e,aim))
			{
				aim.add(rq.getRequestList().get(i));
				rq.getRequestList().remove(i);
				i--;
			}
			
		}
		HandleQueue(e);
		rq.getRequestList().remove(0);
		}
		
		
	}
	public void HandleQueue(Elevator e)
	{
		if(aim.getCarryList().size()==0)
		{
			
			double stopTime=e.getCurTime()+Math.abs(e.getCurFloor()-aim.getFloor())*0.5+1;
			e.setCurTime(stopTime);
			e.setCurFloor(aim.getFloor());
			System.out.println(""+aim.getFloor()+","+e.getDirection()+","+stopTime+"");
		}
		else
		{
			aim.CarrySort();
			aim.CarryPrint(e);
		}
		
		
	}
	public boolean CarryStandardsCheck(Request req,Elevator e,AimFloor aim)
	{
		if(e.getDirection().equals("UP"))
		{
			if(req.getMark().equals("FR")&&req.getDirection().equals("UP"))
			{
				boolean floorcheck=req.getFloor()>e.getCurFloor()&&req.getFloor()<aim.getFloor();
				boolean timecheck=req.getTime()<=(e.getCurTime()+(req.getFloor()-e.getCurFloor())*0.5);
				return(floorcheck&timecheck?true:false);
			}
			else if(req.getMark().equals("ER"))
			{
				boolean floorcheck=req.getFloor()>e.getCurFloor()&&req.getFloor()<aim.getFloor();
				boolean timecheck=req.getTime()<=(e.getCurTime()+(req.getFloor()-e.getCurFloor())*0.5);
				return(floorcheck&timecheck?true:false);
				
			}
			else return false;
		}
		if(e.getDirection().equals("DOWN"))
		{
			if(req.getMark().equals("FR")&&req.getDirection().equals("DOWN"))
			{
				boolean floorcheck=req.getFloor()<e.getCurFloor()&&req.getFloor()>aim.getFloor();
				boolean timecheck=(req.getTime()<=e.getCurTime()+Math.abs(req.getFloor()-e.getCurFloor()*0.5));
				return(floorcheck&timecheck?true:false);
			}
			else if(req.getMark().equals("ER"))
			{
				boolean floorcheck=req.getFloor()<e.getCurFloor()&&req.getFloor()>aim.getFloor();
				boolean timecheck=(req.getTime()<=(e.getCurTime()+Math.abs(req.getFloor()-e.getCurFloor())*0.5));
				
				return(floorcheck&timecheck?true:false);
			}
			else return false;
		}
		else return false;
	}

}
