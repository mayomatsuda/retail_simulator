import java.util.Scanner;

public class employees
{
	private static Scanner scanner = new Scanner(System.in);
	
	public employees()
	{
		
	}
	
	void open()
	{
		home.window = "e";
		System.out.println("***Employees***");
		while (home.window == "e")
		{
			String input = scanner.next().toLowerCase();
			if (input.equals("q") || input.equals("quit"))
			{
				System.out.println("***Home***");
				home.window = "h";
			}
			else System.out.println("Unknown command");
		}
	}
}
