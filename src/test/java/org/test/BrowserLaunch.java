package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.BaseClass;

public class BrowserLaunch extends BaseClass {
	public static void main(String[] args) {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		
		WebElement txtUser = driver.findElement(By.id("email"));
		fill(txtUser, "amuthaindrajith@gmail.com");
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		fill(txtPass, "Varsikasri@123");
		WebElement btnlogin = driver.findElement(By.name("login"));
		btnClick(btnlogin);
	}

}
