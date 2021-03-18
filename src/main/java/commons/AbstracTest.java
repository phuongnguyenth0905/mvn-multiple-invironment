package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstracTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please input correct the browser name !");
		}
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
// cach 1: run all
	protected WebDriver getBrowserDriver1(String browserName, String environment) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please input correct the browser name !");
		}
		driver.get(getInviromentUrl(environment));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	protected WebDriver getBrowserDriver2(String browserName, String environmentUrl) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please input correct the browser name !");
		}
		driver.get(environmentUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	private String getInviromentUrl(String environmentName) {
		String urlValue = null;
		if (environmentName.equalsIgnoreCase("dev")) {
			urlValue = "http://demo.guru99.com/v1/";
		} else if (environmentName.equalsIgnoreCase("test")) {
			urlValue = "http://demo.guru99.com/v2/";

		} else if (environmentName.equalsIgnoreCase("staging")) {
			urlValue = "http://demo.guru99.com/v3/";

		} else if (environmentName.equalsIgnoreCase("live")) {
			urlValue = "http://demo.guru99.com/v4/";

		}else {
			throw new RuntimeException("Please input correct the enviroment name !");
		}
		return urlValue;
	}
}
