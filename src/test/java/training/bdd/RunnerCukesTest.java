package training.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/features/",
		glue = "training.bdd.stepdefinations", 
		tags = {"@userlogin" },
		plugin = { 
				"pretty",
				"html:target/cucumber_report",
				"json:target/cucumber.json",
				"junit:target/cukes.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:target/extends-reports/report.html" },
		monochrome = true)
public class RunnerCukesTest {
//	@AfterClass
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig(new File("config/report.xml"));
//
//	}
}
