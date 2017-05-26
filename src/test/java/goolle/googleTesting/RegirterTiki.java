package goolle.googleTesting;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RegirterTiki {
	@Test
	public void testing() throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nguyenanh\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://tiki.vn/");
		
		String pageTitle = driver.getTitle();
		//Thông báo đã load thành công trang
		System.out.println("Bạn đã load thành công trang: "+pageTitle);
		//hover dang ki
		WebElement ele = driver.findElement(By.xpath(".//*[@id='header-user']/div/div[1]/b"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();
		//click nut tao tai khoang
		driver.findElement(By.xpath(".//*[@id='header-user']/div/div[2]/ul/li[2]/a/span")).click();
		//tao thong tin tai khoang
		driver.findElement(By.cssSelector(".register-email-input")).sendKeys("nguyenanhanh1515@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("nguyentuananh");
		driver.findElement(By.cssSelector("#name")).sendKeys("Nguyen Tuan Anh");
		driver.findElement(By.cssSelector("div.col-xs-4:nth-child(1) > label:nth-child(1) > div:nth-child(1) > ins:nth-child(2)")).click();
		
		Select day = new Select(driver.findElement(By.cssSelector(".birth-day")));
		day.selectByVisibleText("20");
		Select month = new Select(driver.findElement(By.cssSelector(".birth-month")));
		month.selectByVisibleText("02");
		Select year = new Select(driver.findElement(By.cssSelector(".birth-year")));
		year.selectByVisibleText("1995");
		
		driver.findElement(By.cssSelector("#register_popup_submit")).click();
		
		Thread.sleep(3000);
		driver.quit();
			
	}
}
