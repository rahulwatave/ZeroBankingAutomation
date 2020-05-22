package com.bank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.base.Base;
import com.bank.pages.LoginPage;
import com.bank.pages.WelcomePage;

public class WelcomeTest extends Base {
	WelcomePage wp;
	LoginPage lp;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		wp=new WelcomePage();
	}
	@Test
	public void verifySiginIn()
	{
		lp=wp.clksignIn();
		String actual=driver.getTitle();
		String extected="Zero - Log in";
		Assert.assertEquals(actual, extected);
	}

}
