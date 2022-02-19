import java.util.Scanner;

public class assets
{
	private static Scanner scanner = new Scanner(System.in);
	
	private building[] buildings;
	private int buildingCount = 0;
	private int monthlyRent = 0;
	
	public assets()
	{
		buildings = new building[5];
	}
	
	void open()
	{
		home.window = "a";
		System.out.println("***Assets***");
		while (home.window == "a")
		{
			String input = scanner.next().toLowerCase();
			if (input.equals("q") || input.equals("quit"))
			{
				System.out.println("***Home***");
				home.window = "h";
			}
			else if (input.equals("p") || input.equals("property")) property();
			else System.out.println("Unknown command");
		}
	}
	
	private void property()
	{
		home.window = "a.p";
		System.out.println("***Assets/Property***");
		while (home.window == "a.p")
		{
			String input = scanner.next().toLowerCase();
			if (input.equals("q") || input.equals("quit"))
			{
				System.out.println("***Assets***");
				home.window = "a";
			}
			else if (input.equals("m") || input.equals("my property")) myProperty();
			else if (input.equals("b") || input.equals("buy property")) buyProperty();
			else System.out.println("Unknown command");
		}
	}
	
	private void myProperty()
	{
		if (buildingCount == 0)
		{
			System.out.println("You own no property!");
		}
		else
		{
			for (int i = 0; i < buildingCount; i++)
			{
				System.out.println(buildings[i].getName());
			}
		}
	}
	
	private void buyProperty()
	{
		System.out.println("Available properties:");
		building[] available = new building[10];
		for (int i = 1; i <= 10; i++)
		{
			available[i - 1] = new building();
			System.out.println(i + ": " + available[i - 1].getName() + " for $" + available[i - 1].getRent() + " per month");
			System.out.println("    " + "- " + available[i - 1].getSize() + " square feet");
			System.out.println("    " + "- " + available[i - 1].getBusyness());
		}
		System.out.print("Make a selection from 1-10, or 'q' to quit: ");
		boolean selection = false;
		int choice;
		while (!selection)
		{
			String input = scanner.next().toLowerCase();
			if (input.equals("q") || input.equals("quit"))
			{
				System.out.println("***Assets/Property***");
				selection = true;
			}
			else
			{
				try
				{
					choice = Integer.parseInt(input);
					if (choice >= 1 && choice <= 10)
					{
						selection = true;
						confirmBuy(available[choice - 1]);
						System.out.println("***Assets/Property***");
					}
					else System.out.println("Invalid selection");
					
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid selection");
				}
			}
		}
	}
	
	private void confirmBuy(building b)
	{
		boolean selection = false;
		while (!selection)
		{
			System.out.println("Buy " + b.getName() + " for $" + b.getRent() + " per month? [y/n]");
			String input = scanner.next().toLowerCase();
			if (input.equals("y") || input.equals("yes"))
			{
				int newBalance = home.balance - b.getRent();
				if (newBalance < 0) System.out.println("Insufficient balance for first installment! Consider taking out a loan.");
				else
				{
					buildings[buildingCount] = b;
					buildingCount++;
					home.balance = newBalance;
					monthlyRent = monthlyRent + b.getRent();
					System.out.println("Transaction complete! Remaining balance: $" + home.balance);
				}
				selection = true;
			}
			else if (input.equals("n") || input.equals("no"))
			{
				selection = true;
			}
			else
			{
				System.out.println("Invalid selection");
			}
		}
	}
	
	public void collectRent()
	{
		if (!(buildingCount == 0))
		{
			for (int i = 0; i < buildingCount; i++)
			{
				if (((home.date - buildings[i].getDate()) % 30) == 0) home.balance = home.balance - buildings[i].getRent();
			}
		}
	}
}
