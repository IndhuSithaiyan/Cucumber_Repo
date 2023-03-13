package org.finalrun;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinition.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="@Rerun\\failed.txt",
		glue="org.stepdefinition",
		strict=true,
		dryRun=false,
		monochrome=true,
		snippets=SnippetType.CAMELCASE,
		plugin= {"pretty",
				"rerun:./Rerun/failed.txt"
				}
		)

public class RerunnerClass {
	
	@AfterClass  //--> must be static method 
	public static void report() {
		JVMReport.generateJVMReport(System.getProperty("user.dir")+"./AllFolder/Json Report/index.json");
	}

}
