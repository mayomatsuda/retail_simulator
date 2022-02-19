
public class loan
{
	private int amount;
	private double RATE;
	private int datePurchased;
	private int owed;
	
	public loan(int initialAmount)
	{
		amount = initialAmount;
		datePurchased = home.date;
		RATE = 0.01;
		owed = (int) Math.round(amount * (1 + RATE));
	}
	
	public void setOwed(int newOwed)
	{
		owed = newOwed;
	}
	
	public int getOwed()
	{
		return owed;
	}
	
	public int getDate()
	{
		return datePurchased;
	}
	
	public void update()
	{
		owed = (int) Math.round(owed * (1 + RATE));
	}
}
