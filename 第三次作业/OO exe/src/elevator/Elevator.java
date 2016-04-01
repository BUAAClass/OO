package elevator;


public class Elevator implements ElevatorInterface {
	private int curfloor;
	private String curDirection;
	private double curTime;
	public Elevator()
	{
		this.curfloor=1;
		this.curDirection="null";
		this.curTime=0;             //初始楼层为1 初始时间为0
	}
	public int getCurFloor()
	{
		return this.curfloor;
	}
	public void setCurFloor(int floor)
	{
		this.curfloor=floor;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Elevator e=new Elevator();
		System.out.println(e.toString());

	}
	@Override
	public void setDirection(String direction) {
		// TODO Auto-generated method stub
		this.curDirection=direction;
		
	}
	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return this.curDirection;
	}
	public String toString()
	{
		if(this.curDirection.equals("null"))
		{
			return("时间："+this.curTime+" 电梯处于"+this.curfloor+"层，当前无运动方向");
		}
		else if(this.curDirection.equals("UP"))
		{
			return("时间："+this.curTime+" 电梯处于"+this.curfloor+"层，当前运动方向为上");
		}
		else return("时间："+this.curTime+" 电梯处于"+this.curfloor+"层，当前运动方向为下");
	}
	@Override
	public double getCurTime() {
		// TODO Auto-generated method stub
		return this.curTime;
	}
	@Override
	public void setCurTime(double time) {
		// TODO Auto-generated method stub
		this.curTime=time;
		
	}

}
