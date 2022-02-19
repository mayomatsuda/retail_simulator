import java.util.Scanner;

public class marketing
{
	private static Scanner scanner = new Scanner(System.in);
	
	public marketing()
	{
		
	}
	
	void open()
	{
		home.window = "m";
		System.out.println("***Marketing***");
		while (home.window == "m")
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
