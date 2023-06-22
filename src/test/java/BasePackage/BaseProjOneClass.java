 package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseProjOneClass {
	
	public static Properties prop=new Properties();
    public static WebDriver driver;

   //Step 1 - constructor
public BaseProjOneClass() {
    	
    	try {
    FileInputStream file=new FileInputStream("C:\\Users\\princ\\eclipse-workspace\\LiveProjectOne\\src\\test\\java\\EnvironmentVariables\\Config.properties");	
    	prop.load(file);
    }
    catch(FileNotFoundException e) {
    	e.printStackTrace();
    }
    catch(IOException a) {
    	a.printStackTrace(); 
    }
}
   //Step 2
	/*
	 * public static void initiation() { String
	 * browsername=prop.getProperty("browser");
	 * 
	 * if (browsername.equals("Chrome")){
	 * System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	 * 
	 * driver=new ChromeDriver();} else if(browsername.equals("firefox")) {
	 * System.setProperty("webdriver.gecko.driver","geckodriver.exe"); driver=new
	 * FirefoxDriver(); } driver.manage().window().maximize();
	 * driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.
	 * SECONDS); driver.get(prop.getProperty("url"));
	 * 
	 * }
	 */
public static void initiation() {
    String browsername = prop.getProperty("browser");

    if (browsername.equals("Chrome")) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    } else if (browsername.equals("firefox")) {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    driver.manage().window().maximize();
    driver.get(prop.getProperty("url"));

	/*
	 * WebDriverWait wait = new WebDriverWait(driver, TimeUtils.timepage);
	 * wait.until(ExpectedConditions.urlToBe(prop.getProperty("url")));
	 */
}
 public static void screenshots(String Filename) {
	File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file, new File("C:\\Users\\princ\\eclipse-workspace\\LiveProjectOne\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
 
	 
	 
}}
