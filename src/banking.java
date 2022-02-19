import java.util.Scanner;

public class banking
{
	private static Scanner scanner = new Scanner(System.in);
	
	private int owed;
	private loan theLoan;
	
	public banking()
	{
		owed = 0;
	}
	
	void open()
	{
		home.window = "b";
		System.out.println("***Banking***");
		while (home.window == "b")
		{
			String input = scanner.next().toLowerCase();
			if (input.equals("q") || input.equals("quit"))
			{
				System.out.println("***Home***");
				home.window = "h";
			}
			else if (input.equals("b") || input.equals("balance")) System.out.println("Your balance is $" + home.balance);
			else if (input.equals("l") || input.equals("loan")) newLoan();
			else if (input.equals("o") || input.equals("owed")) myOwed();
			else if (input.equals("p") || input.equals("pay")) pay();
			else System.out.println("Unknown command");
		}
	}
	
	public int getOwed()
	{
		return owed;
	}
	
	private void newLoan()
	{
		boolean selection = false;
		while (selection == false)
		{
			if (owed > 0)
			{
				System.out.println("Because you are in debt, the bank will not let you take out another loan!");
				System.out.println("***Banking***");
				selection = true;
			}
			else
			{
				System.out.print("Enter loan amount. Every 30 days the amount owed will increase by the interest rate of 1%. Or press 'q' to quit: ");
				String input = scanner.next().toLowerCase();
				if (input == "q" || input == "quit")
				{
					System.out.println("***Banking***");
					selection = true;
				}
				else
				{
					try
					{
						int amount = Integer.parseInt(input);
						if (amount >= 1)
						{
							home.balance = home.balance + amount;
							theLoan = new loan(amount);
							owed = theLoan.getOwed();
							System.out.println("***Banking***");
							selection = true;
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
	}
	
	private void myOwed()
	{
		System.out.println("You currently owe $" + owed);
	}
	
	private void pay()
	{
		boolean selection = false;
		while (selection == false)
		{
			if (owed == 0)
			{
				System.out.println("You are debt-free!");
				System.out.println("***Banking***");
				selection = true;
			}
			else
			{
				System.out.print("You currently owe $" + owed + ". How much will you pay back at this time? Or press 'q' to quit: ");
				String input = scanner.next().toLowerCase();
				if (input == "q" || input == "quit")
				{
					System.out.println("***Banking***");
					selection = true;
				}
				else
				{
					try
					{
						int amount = Integer.parseInt(input);
						if (amount >= 1)
						{
							if (amount <= home.balance && owed >= amount)
							{
								home.balance = home.balance - amount;
								owed = owed - amount;
								theLoan.setOwed(owed);
								if (owed == 0) theLoan = null;
								System.out.println("***Banking***");
								selection = true;
							}
							else if (amount > home.balance) System.out.println("Insufficient balance!");
							else if (owed < amount) System.out.println("You don't owe that much!");
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
	}
	
	public void calculateOwed()
	{
		if (!(theLoan == null))
		{
			if (((home.date - theLoan.getDate()) % 30) == 0)
			{
				theLoan.update();
				owed = theLoan.getOwed();
			}
		}
	}
}
