package elevator;

import java.util.ArrayList;

public class RequestQueue {
    private ArrayList<Request> RequestList;                  //请求队列
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Request> getRequestList()
	{
		return this.RequestList;
	}
	public boolean ParseReq(String s)
	{
		String InnerReq="\\(ER,([1-9]|10),\\d{1,3}([.][1-9])?\\)";
		String FloorReq="\\(FR,([1-9]|10),(UP|DOWN),\\d{1,3}([.][1-9])?\\)";                                             //格式检查
		String StandardCheck="(("+InnerReq+"|"+FloorReq+")(\\s)?)*";
		if(!s.matches(StandardCheck))
		{
			return false;
		}
		String Req[]=s.replaceAll("\\(|\\)","").split(" ");
		RequestList=new ArrayList<Request>();
		for(int i=0;i<Req.length;i++)
		{
		  String Mark[]=Req[i].split(",");
		  if(Mark[0].equals("FR")){
		  RequestList.add(new Request(Mark[0],Integer.parseInt(Mark[1]),Mark[2],Double.valueOf(Mark[3])));
		  }
		  else if(Mark[0].equals("ER"))
		  {
		  RequestList.add(new Request(Mark[0],Integer.parseInt(Mark[1]),Double.valueOf(Mark[2]))); 
		  }		
		}
		if(RequestList.get(0).getTime()!=0)
		{
		   System.out.println("your first time is not zero,invalid input");	                       //首次请求时间为0
		   return false;
		}
		int i;
		for(i=0;i<RequestList.size()-1;i++)
		{
			if(RequestList.get(i).getTime()>RequestList.get(i+1).getTime())
			{
				System.out.println("your time is not in order,invalid input");                         //请求顺序为有序
				return false;
			}
			if(RequestList.get(i).getFloor()==1&&RequestList.get(i).getDirection().equals("DOWN"))           
			{
				System.out.println("floor 1 do not have DOWN button");
				return false;
			}
			if(RequestList.get(i).getFloor()==10&&RequestList.get(i).getDirection().equals("UP"))             //10层无上行按钮 1层无下行
			{
				System.out.println("floor 10 do not have UP button");
				return false;
			}
		}
		if(RequestList.get(i).getFloor()==1&&RequestList.get(i).getDirection().equals("DOWN"))           
		{
			System.out.println("floor 1 do not have DOWN button");
			return false;
		}
		if(RequestList.get(i).getFloor()==10&&RequestList.get(i).getDirection().equals("UP"))             //10层无上行按钮 1层无下行
		{
			System.out.println("floor 10 do not have UP button");
			return false;
		}
		return true;
	}
	
	

}
