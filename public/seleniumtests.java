package selenium.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Hello world!
 *
 */
public class App {
	
	//basic signup and login test on chrome
	//test should login a user 
	public static void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/roshanvirdi/Downloads/chromedriver");


		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/apparel");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		//click signup button at top
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		//enter username and password
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		
		//login
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		//logout
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
				
		driver.quit();
	}
	
	//basic signup and login test on firefox
	//test should login a user 
	public static void test2() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/roshanvirdi/Downloads/geckodriver 2");
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
	    WebDriver driver =  new FirefoxDriver(options);

	    driver.get("http://localhost:8080/apparel");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		//logout
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.quit();
	}
	
	//signup and login but with incorrect password
	//test should not login any user 
	public static void test3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/roshanvirdi/Downloads/chromedriver");


		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/apparel");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		driver.quit();
	}
	
	//try posting once successfully logged in
	//should post a sample listing 
	//edit the sample listing
	//delete the listing
	//logout
	public static void test4() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/roshanvirdi/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/apparel");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		//adds post 
		driver.findElement(By.xpath("/html/body/div[2]/header/div/p[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("Successful Post Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("data:image/png;base64,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");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input")).sendKeys("This is a test!");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);
		
		//edit listing
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("Change Post");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("data:image/png;base64,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");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input")).sendKeys("Testing the listing edit");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);
		
		//go back to home
		driver.findElement(By.xpath("/html/body/nav/div/div[1]/a")).click();
		Thread.sleep(1000);
		
		
		//delete post
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/form/button")).click();
		Thread.sleep(1000);
		
		//logout
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		
		driver.quit();
	}
	
	//user123 makes post and logs out
	//attempt to make a comment on post not logged in
	//redirecting to login; login with another user
	//comment on post and edit comment then logout
	//login as first user and reply to comment
	//delete post and logout
	public static void test5() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/roshanvirdi/Downloads/chromedriver");


		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/apparel");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		//adds post 
		driver.findElement(By.xpath("/html/body/div[2]/header/div/p[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("Successful Post Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("data:image/png;base64,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");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input")).sendKeys("This is a test!");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[4]/button")).click();
		Thread.sleep(1000);
		
		//logout of user123
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p/a")).click();
		Thread.sleep(1000);
		
		//try adding comment not logged in
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/a")).click();
		Thread.sleep(1000);
		
		//logging in as different user
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("CommentUser");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("pass");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		//go back to listing and add comment
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("Cool Post!");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/button")).click();
		Thread.sleep(1000);
		
		//edit comment
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("This is a cool post!");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/button")).click();
		Thread.sleep(1000);
		
		//logout
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\'landing-header\']/a")).click();
		Thread.sleep(1000);
		
		//login back to first user 
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("User123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/input")).sendKeys("password123");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);
		
		//reply to other user on post
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/input")).sendKeys("Thanks!");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/button")).click();
		Thread.sleep(1000);
		
		//delete post
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/form/button")).click();
		Thread.sleep(1000);

		//logout
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.quit();
		
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		test5();
	}
}
