package kernel;
public class Item
{
	private String name;
	private double rc;
	private double xr;
	private int value;
	private int weight;
	//TODO AGGIUNGERE NOMI DEI VINCOLI
	
	public Item(String name, int value, int weight) {
		this.name=name;
		this.value=Math.abs(value);
		this.weight=weight;
	}
	
	public Item(String name, double xr, double rc)
	{
		this.name = name;
		this.xr = xr;
		this.rc = rc;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getRc()
	{
		return rc;
	}
	
	public double getXr()
	{
		return xr;
	}
	
	public double getAbsoluteRC()
	{
		return Math.abs(rc);
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}
	
	public double getXrValue() {
		return xr + 0.01 * ((double) value / (double) weight);
	}
	

	public void setRc(double rc) {
		this.rc = rc;
	}
	
	public void setXr(double xr) {
		this.xr = xr;
	}
	
}