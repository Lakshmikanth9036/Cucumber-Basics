package training.bdd.stepdefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	
	@Before
	public void setup(){
		System.out.println("Before w/o tag");
	}
	
	@After
	public void teardown(){
		System.out.println("After w/o tag");
	}
	
	@Before("@userReg")
	public void setupForReg(){
		System.out.println("Before with tag");
	}
	
	@After("@userReg")
	public void teardownForReg(){
		System.out.println("After with tag");
	}
}
