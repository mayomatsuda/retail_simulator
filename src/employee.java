import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class employee
{
	private String name;
	
	private int customerService;
	private int efficiency;
	private int punctuality;
	private int workEthic;
	private int synergy;
	
	private int AVG = 25;
	
	public employee()
	{
		name = makeName();
		makeStats();
	}
	
	private String makeName()
	{
		Random random = new Random();
		
		File fName = new File("first-names.txt");
		File lName = new File("last-names.txt");
		int fListLength = 4947;
		int lListLength = 21985;
		
		int fChoice = random.nextInt(fListLength);
		int lChoice = random.nextInt(lListLength);
		while (fChoice == 0 || lChoice == 0)
		{
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
		
		return (firstName + " " + lastName);
	}
	
	private void makeStats()
	{
		Random random = new Random();
		
		customerService = random.nextInt(50) + AVG;
		efficiency = random.nextInt(50) + AVG;
		punctuality = random.nextInt(50) + AVG;
		workEthic = random.nextInt(50) + AVG;
		synergy = random.nextInt(50) + AVG;
	}
	
	public int getCustomerService()
	{
		return customerService;
	}
	
	public int getEfficiency()
	{
		return efficiency;
	}
	
	public int getPunctuality()
	{
		return punctuality;
	}
	
	public int getWorkEthic()
	{
		return workEthic;
	}
	
	public int getSynergy()
	{
		return synergy;
	}
	
	public String getName()
	{
		return name;
	}
}
