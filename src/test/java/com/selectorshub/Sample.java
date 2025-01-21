package com.selectorshub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Sample {
	
	@Test
	public void test1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriver driver1 = new FirefoxDriver();
		driver1.manage().window().maximize();
		WebDriver driver2 = new EdgeDriver();
		driver2.manage().window().maximize();
		
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123$%^GGGGG");
		driver.findElement(By.name("company")).sendKeys("IBM");
		driver.findElement(By.name("mobile number")).sendKeys("9876543210");
		//WebElement submit = driver.findElement(By.xpath("//button[@value='Submit']"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//button[@value='Submit']")));
		 WebDriverWait ww = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement submit= ww.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@value='Submit']"))));
		//driver.findElement(By.xpath("//button[@value='Submit']")).click();
		driver.close();
	}
	@Test
    public void dropDownTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select s1 = new Select(driver.findElement(By.id("cars")));
		List<WebElement> str = s1.getOptions();
		for(WebElement s:str) {
			System.out.println(s.getText());
		}
		s1.selectByValue("saab");
		s1.selectByValue("audi");
		driver.findElement(By.xpath("//input[@name='the_date']")).sendKeys("01/01/2004");
		driver.close();
    }
	@Test
	public void checkBoxTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("resultTable"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		int size = driver.findElements(By.xpath("//table[@id='resultTable']//tr")).size();
		System.out.println(size);
		for(int i=1;i<size;i++) {
			Thread.sleep(4000);
			System.out.println(i);
			driver.findElement(By.xpath("//table[@id='resultTable']//tr["+i+"]//td[1]/input")).click();
		}
		driver.close();
	}
	
	@Test
	public void alertTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500);");
		driver.findElement(By.xpath("//button[contains(text(),'Open Window')]")).click();
		driver.switchTo().alert().accept();
		driver.close();
	}
}




