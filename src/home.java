import java.util.Scanner;

public class home
{
	private static Scanner scanner = new Scanner(System.in);
	
	public static String window = "h";
	public static int balance = 100000;
	public static int date = 1;
	public static int displayDate = 1;
	private static assets _assets = new assets();
	private static banking _banking = new banking();
	private static employees _employees = new employees();
	private static marketing _marketing = new marketing();
	
	public static void main(String[] args)
	{
		System.out.println("It is day " + date + " of the year.");
		System.out.println("***Home***");
		home();
	}
	
	public static void home()
	{
		while (window == "h")
		{
			String input = scanner.next().toLowerCase();
			if (input.equals("q") || input.equals("quit")) break;
			else if (input.equals("a") || input.equals("assets")) _assets.open();
			else if (input.equals("b") || input.equals("banking")) _banking.open();
			else if (input.equals("e") || input.equals("employees")) _employees.open();
			else if (input.equals("m") || input.equals("marketing")) _marketing.open();
			else if (input.equals("n") || input.equals("next")) nextDay();
			else System.out.println("Unknown command");
		}
	}
	
	private static void nextDay()
	{
		int newDate = date + 1;
		int newDisplayDate = displayDate + 1;
		if (newDisplayDate == 361) newDisplayDate = 1;
		date = newDate;
		displayDate = newDisplayDate;
		_assets.collectRent();
		_banking.calculateOwed();
		System.out.println("It is day " + newDisplayDate + " of the year.");
		System.out.println("You have $" + balance);
		System.out.println("You owe $" +  _banking.getOwed());
		System.out.println("***Home***");
	}
}
