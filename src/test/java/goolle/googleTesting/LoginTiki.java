package goolle.googleTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTiki {
	@Test
	public void testlogin() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nguyenanh\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://tiki.vn/");
		
		String pageTitle = driver.getTitle();
		//Thông báo đã load thành công trang
		System.out.println("Bạn đã load thành công trang: "+pageTitle);
		//hover dang nhap
		WebElement ele = driver.findElement(By.cssSelector("#header-user > div:nth-child(1) > div:nth-child(1) > b:nth-child(2)"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();
		//click dang nhap
		driver.findElement(By.cssSelector(".user-name-login > span:nth-child(1)")).click();
		//dang nhap
		String use = "nguyenanhanh1515@gmail.com";
		String pwd = "nguyentuananh";
		
		driver.findElement(By.cssSelector("#popup-login-email")).sendKeys(use);
		driver.findElement(By.cssSelector("#login_password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("#login_popup_submit")).click();
		
		Thread.sleep(2000);
		//loi email
		String gtemail = driver.findElement(By.xpath(".//*[@id='popup_login']/small[2]")).getText();
		//bat loi khong nhap email
		String gtemail1 = driver.findElement(By.xpath(".//*[@id='popup_login']/small[1]")).getText();
		//loi password
		String gtpass = driver.findElement(By.xpath(".//*[@id='popup_password']/span")).getText();
		//bat loi dang nhap thanh cong hay that bai
		if(gtpass.equals("")&&gtemail.equals("")&&gtemail1.equals("")){
			System.out.println("dang nhap thanh cong");
			// dang nhap thanh cong thi logout ra
			WebElement ele1 = driver.findElement(By.cssSelector("#header-user > div:nth-child(1) > div:nth-child(1) > b:nth-child(2)"));
			Actions ac1 = new Actions(driver);
			ac1.moveToElement(ele1).build().perform();
			
			driver.findElement(By.cssSelector(".user-ajax-customer > li:nth-child(12) > a:nth-child(1)")).click();
			
			System.out.println("đã đăng xuất");
		}else{
			System.out.println("Loi dang nhap: "+gtemail1+" "+gtemail+" "+gtpass);
		}
		
		
		Thread.sleep(5000);
		driver.quit();
	}
	
}
