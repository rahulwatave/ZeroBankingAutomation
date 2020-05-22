package com.bank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bank.base.Base;

public class WelcomePage extends Base {
	
	@FindBy(id="signin_button")
	WebElement signInBtn;
	
	public WelcomePage()
	{
		PageFactory.initElements(driver, this);
	}

	// what action to be perform: click on sign in button
	

	public LoginPage clksignIn() {
		// TODO Auto-generated method stub
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
		signInBtn.click();
		return new LoginPage();// this is not mandatory but for good connectivity to be used
	}

}
