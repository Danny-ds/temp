import java.util.logging.Logger;

public class MyLogger
{
	private volatile static MyLogger logger;
	private String className;

	//private static final  MyLogger logger = new MyLogger();  - Optimized

	private MyLogger(String classname)
	{
		this.className = classname;
	}

	public String getClassName()
	{
		return className;
	}

	public static MyLogger getInstance(String className) throws Exception
	{
		//Double check singleton
		if (logger == null)
		{
			synchronized(MyLogger.class)
			{
				if (logger == null)
				{
					logger = new MyLogger(className);
				}
			}
		}
		return logger;
	}

	/* Lazy way

	public static synchronized MyLogger getISyncnstance(String className) throws Exception
	{
		//Double check singleton
		if (logger == null)
		{
			logger = new MyLogger(className);
		}
		return logger;
	}	*/
}
