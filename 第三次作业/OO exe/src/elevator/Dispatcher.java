package elevator;

import java.util.ArrayList;
import java.util.Scanner;

public class Dispatcher {
    
     
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入请求队列，以空格分隔，以换行结束");
		String s=scan.nextLine();
		Elevator e=new Elevator();
		RequestQueue rq=new RequestQueue();
		Dispatcher dis=new Dispatcher();
		if(rq.ParseReq(s))
		{
		dis.FoolSchedule(e, rq);
		}
		
		

	}
	public void FoolSchedule(Elevator e,RequestQueue rq)
	{
		ArrayList<Request> Dis=rq.getRequestList();
		
		while(Dis.size()>0)
		{
			if(Dis.get(0).getTime()<e.getCurTime())                //超过时间则忽略请求
			{
				Dis.remove(0);
				continue;
			}
			else
			{
				int curFloor=e.getCurFloor();
				int aimFloor=Dis.get(0).getFloor();
				e.setCurTime(Math.abs((aimFloor-curFloor))*0.5+1+Dis.get(0).getTime());
				e.setCurFloor(aimFloor);
				String direction=(aimFloor>curFloor?"UP":"DOWN");
				if(Dis.get(0).getMark().equals("ER"))
				{
				System.out.println("("+aimFloor+","+direction+","+e.getCurTime()+")");
				}
				else if(Dis.get(0).getMark().equals("FR"))
				{
				System.out.println("("+aimFloor+","+Dis.get(0).getDirection()+","+e.getCurTime()+")");	
				}
				
			}
		}
		
		
		
		
	}

}
