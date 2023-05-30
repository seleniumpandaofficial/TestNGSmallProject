package com.tutorialsninja.practice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.testbase.TestBase;

public class CompleteTest extends TestBase {

	public WebDriver driver;
	public Actions actions;
	public Select select;
	
	public CompleteTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = openApplicationUrlinABrowser("chrome");
	}

	@Test(priority = 1)
	public void completeTestCasePositively() throws InterruptedException {
       Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

	}

	@Test(priority = 2)
	public void clickOnLaptopsandNotebooks() {

		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Laptops & Notebooks"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("Show AllLaptops & Notebooks"))).click().perform();

	}

	@Test(priority = 3)
	public void clickOnHPLaptop() {

		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Laptops & Notebooks"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("Show AllLaptops & Notebooks"))).click().perform();
		WebElement HPLaptop = driver.findElement(By.linkText("HP LP3065"));
		if (HPLaptop.isDisplayed()) {
			HPLaptop.click();
		} else {
			System.out.println("HP Laptop is not displayed");
		}

	}

	@Test(priority = 4)
	public void completeBuying() throws InterruptedException {

		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Laptops & Notebooks"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("Show AllLaptops & Notebooks"))).click().perform();
		WebElement HPLaptop = driver.findElement(By.linkText("HP LP3065"));
		if (HPLaptop.isDisplayed()) {
			HPLaptop.click();
		} else {
			System.out.println("HP Laptop is not displayed");
		}
		driver.findElement(By.xpath("//input[@id = 'input-option225']")).sendKeys("2011-04-22");
		driver.findElement(By.id("button-cart")).click();

		driver.findElement(By.cssSelector("i.fa.fa-shopping-cart+span")).click();
		driver.findElement(By.xpath("//input[starts-with(@name, 'quantity[')]")).clear();
		driver.findElement(By.xpath("//input[starts-with(@name, 'quantity[')]")).sendKeys("2");
		driver.findElement(By.linkText("Checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name = 'payment_address' and @value='new']")).click();

		driver.findElement(By.id("input-payment-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Panda");
		driver.findElement(By.id("input-payment-company")).sendKeys("AutomationHub");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("123, Mark St, Virginia");
		driver.findElement(By.id("input-payment-address-2")).sendKeys("Basement");
		driver.findElement(By.id("input-payment-city")).sendKeys("Vienna");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("22189");
		select = new Select(driver.findElement(By.id("input-payment-country")));
		select.selectByVisibleText("United States");
		Thread.sleep(3000);
		select = new Select(driver.findElement(By.id("input-payment-zone")));
		select.selectByVisibleText("Virginia");
		driver.findElement(By.id("button-payment-address")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("comment")).sendKeys("Please pack Laptop safely");
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-confirm")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Your order has been successfully processed!']"))
				.isDisplayed());
		driver.findElement(By.linkText("Continue")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
