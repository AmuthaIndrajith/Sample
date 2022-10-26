package org.testingconcept;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgOrders {
	
	@BeforeClass
	private void browserLaunch() {
		System.out.println("Chrome");
	}

	@AfterClass
	private void closeChrome() {
		System.out.println("Close Chrome");
	}
	
	@BeforeMethod
	private void startTime() {
		System.out.println("Start");
	}
	
	@AfterMethod
	private void endTime() {
		System.out.println("End");
	}
	
	@Test
	private void tc1() {
		System.out.println("Test1");
	}
	
	@Test
	private void tc2() {
		System.out.println("Test2");
	}
	
	@Test
	private void tc3() {
		System.out.println("Test3");
	}
}
