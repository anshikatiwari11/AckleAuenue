package configuration;

public class Configuration {
	public final static String url="http://www.shino.de/parkcalc";
	public final static String chromePath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	public final static String firefoxPath=System.getProperty("user.dir") +"\\Drivers\\geckodriver.exe";
	public final static String iePath=System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
	public final static int implicitWait=10;
	public final static String testDataPath=System.getProperty("user.dir")+"\\src\\testData\\TestData.xlsx";
}
