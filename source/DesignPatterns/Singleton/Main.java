import java.util.stream.IntStream;

public class Main extends Thread
{
	static int i=0;
	public static void main(String[] args)
	{
		IntStream.range(0, 5).forEach(i -> new Main().start());
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println(MyLogger.getInstance("hello"+(i++)).getClassName());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
