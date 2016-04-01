package elevator;


public class Request {
	private String mark;  //Çø·ÖER FR
	private int floor;
	private String direction;
	private double time;
	public Request clone(Request r)
	{
		this.mark=r.mark;
		this.floor=r.floor;
		this.direction=r.direction;
		this.time=r.time;
		return this;
	}
    public Request(String mark,int floor,String direction,double time)
    {
    	this.mark=mark;
    	this.floor=floor;
    	this.direction=direction;
    	this.time=time;
    }
    public Request()
    {
    	
    }
    public Request(String mark,int floor,double time)
    {
    	this.mark=mark;
    	this.floor=floor;
    	this.time=time;
    	this.direction="null";
    }
    public Request(int floor,String direction,double time)
    {
    	this.floor=floor;
    	this.direction=direction;
    	this.time=time;
    }
    public double getTime()
    {
    	return this.time;
    }
    public int getFloor()
    {
    	return this.floor;
    }
    public String getDirection()
    {
    	return this.direction;
    }
    public String getMark()
    {
    	return this.mark;
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	public String toString()
	{
		return (this.getMark()+","+this.getDirection()+","+this.getFloor()+","+this.getTime());
	}
	

}
