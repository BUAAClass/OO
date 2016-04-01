package elevator;

import java.util.ArrayList;

public class AimFloor {
	private Request MainRequest;
	private ArrayList<Request> CarryingFloorList;
	private ArrayList<Request> PrintList;
    public AimFloor(Request req)
    {
    	CarryingFloorList=new ArrayList<Request>();
    	PrintList=new ArrayList<Request>();
    	this.MainRequest=req;
    }
    public Request getMainRequest()
    {
    	return this.MainRequest;
    }
    public int getFloor()
    {
    	return this.MainRequest.getFloor();
    }
    public void add(Request carryfloor)
    {
    	this.CarryingFloorList.add(carryfloor);
    }
    public ArrayList<Request> getCarryList()
    {
    	return this.CarryingFloorList;
    }
    public void CarrySort()
    {
    	for(int i=0;i<this.CarryingFloorList.size();i++)
    	{
    		for(int j=i+1;j<this.CarryingFloorList.size();j++)
    		{
    			if(CarryingFloorList.get(i).getFloor()>CarryingFloorList.get(j).getFloor())
    			{
    				Request re=new Request();
    				re.clone(this.CarryingFloorList.get(i));
    				this.CarryingFloorList.set(i, this.CarryingFloorList.get(j));
    				this.CarryingFloorList.set(j, re);
    				
    			}
    		}
    	}
    	
    	
    }
    public void CarryPrint(Elevator e)
    {
    	
    	for(int i=0;i<this.CarryingFloorList.size();i++)
    	{
    		
    		e.setCurTime(e.getCurTime()+Math.abs(e.getCurFloor()-this.CarryingFloorList.get(i).getFloor())*0.5+1);
    		e.setCurFloor(this.CarryingFloorList.get(i).getFloor());
    		this.PrintList.add(new Request(e.getCurFloor(),e.getDirection(),e.getCurTime()));
    		
    	}
    	e.setCurTime(e.getCurTime()+Math.abs(e.getCurFloor()-MainRequest.getFloor())*0.5+1);
    	e.setCurFloor(MainRequest.getFloor());
    	System.out.print(e.getCurFloor()+","+e.getDirection()+","+e.getCurTime());
    	for(int i=0;i<PrintList.size();i++)
    	{
    		System.out.print("("+PrintList.get(i).getFloor()+","+PrintList.get(i).getDirection()+","+PrintList.get(i).getTime()+")");
    	}
    	System.out.println();
    	
    	
    	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
