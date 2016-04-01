package elevator;


public class Elevator implements ElevatorInterface {
	private int curfloor;
	private String curDirection;
	private double curTime;
	public Elevator()
	{
		this.curfloor=1;
		this.curDirection="null";
		this.curTime=0;             //��ʼ¥��Ϊ1 ��ʼʱ��Ϊ0
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
			return("ʱ�䣺"+this.curTime+" ���ݴ���"+this.curfloor+"�㣬��ǰ���˶�����");
		}
		else if(this.curDirection.equals("UP"))
		{
			return("ʱ�䣺"+this.curTime+" ���ݴ���"+this.curfloor+"�㣬��ǰ�˶�����Ϊ��");
		}
		else return("ʱ�䣺"+this.curTime+" ���ݴ���"+this.curfloor+"�㣬��ǰ�˶�����Ϊ��");
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
