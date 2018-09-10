package ofd.simpletype;

public class Box {

	private double x;
	private double y;
	private double width;
	private double height;
	
	public Box(String boxString)
	{
		String[] parts=boxString.split(" ");
		
		this.x=Double.parseDouble(parts[0]);
		this.y=Double.parseDouble(parts[1]);
		this.width=Double.parseDouble(parts[2]);
		this.height=Double.parseDouble(parts[3]);
	}
	
}
