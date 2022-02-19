import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class building
{
	private String name;
	private int busyness;
	private String busynessWord;
	private int rent;
	private int size;
	private int datePurchased;
	
	public building()
	{
		Random random = new Random();
		name = makeName();
		busyness = random.nextInt(100);
		busynessWord = makeBusyness();
		while (busyness == 0) busyness = random.nextInt(100);
		size = random.nextInt(299500) + 500;
		rent = makeRent();
		datePurchased = home.date;
	}
	
	private String makeName()
	{
		Random random = new Random();
		
		File fName = new File("first-names.txt");
		File lName = new File("street-suffix.txt");
		int fListLength = 4945;
		int lListLength = 22;
		
		int number = random.nextInt(1000);
		int fChoice = random.nextInt(fListLength);
		int lChoice = random.nextInt(lListLength);
		while (number == 0 || fChoice == 0 || lChoice == 0)
		{
			number = random.nextInt(1000);
			fChoice = random.nextInt(fListLength);
			lChoice = random.nextInt(lListLength);
		}
		
		BufferedReader fReader = null;
		try
		{
			fReader = new BufferedReader(new FileReader(fName));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		BufferedReader lReader = null;
		try
		{
			lReader = new BufferedReader(new FileReader(lName));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		String firstName = "";
		String lastName = "";
		
		for (int i = 0; i < fChoice; i++)
		{
			try
			{
				firstName = fReader.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < lChoice; i++)
		{
			try
			{
				lastName = lReader.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return (number + " " + firstName + " " + lastName);
	}
	
	private int makeRent()
	{
		return Math.round(((busyness/100f) * size));
	}
	
	private String makeBusyness()
	{
		if (1 <= busyness && busyness < 25) return "Poor location";
		else if (25 <= busyness && busyness < 50) return "Okay location";
		else if (50 <= busyness && busyness < 75) return "Good location";
		else if (75 <= busyness) return "Great location";
		else return "Error";
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getBusyness()
	{
		return busynessWord;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getRent()
	{
		return rent;
	}
	
	public int getDate()
	{
		return datePurchased;
	}
}
