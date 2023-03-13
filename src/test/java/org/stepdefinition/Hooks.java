package org.stepdefinition;

import org.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{

	@Before("@smoke")
	public void befSmokeScenario() {
		System.out.println("Smoke scenario started...");
	}
	
	@After("@smoke")
	public void aftSmokeScenario() {
		System.out.println("Smoke scenario ended...");
	}
	
	@Before
	public void bef() {
		System.out.println("Bef Scenario >>>");
		openChromeBrowser();
		maxWindow();
		applyImplicitwait();
	}

	@Before(order=1)
	public void bef1() {
		System.out.println("Bef Scenario >>> 1");
	}

	@Before(order=2)
	public void bef12() {
		System.out.println("Bef Scenario >>> 2");
	}

	@After
	public void aft() {
		System.out.println("aft Scenario >>>");
	}

	@After(order=1)
	public void aft1() {
		System.out.println("aft Scenario >>> 1");
	}

	@After(order=2)
	public void aft2() {
		System.out.println("aft Scenario >>> 2");
	}
}
