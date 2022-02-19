import java.util.Random;

public class manager extends employee
{
	private int control;
	private int respect;
	
	private int AVG = 50;
	
	public manager()
	{
		super();
		makeManagerStats();
	}
	
	private void makeManagerStats()
	{
		Random random = new Random();
		
		control = random.nextInt(50) + AVG;
		respect = random.nextInt(50) + AVG;
	}
	
	public int getControl()
	{
		return control;
	}
	
	public int getRespect()
	{
		return respect;
	}
}
