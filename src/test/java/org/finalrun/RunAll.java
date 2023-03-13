package org.finalrun;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinition.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)

@CucumberOptions(
		features="src\\test\\resources\\FeatureFiles",
		glue="org.stepdefinition",
		strict=true,
		dryRun=false,
		monochrome=true,
		snippets=SnippetType.CAMELCASE,
		plugin= {"pretty",
				"html:./AllFolder/Html Report",
				"json:./AllFolder/Json Report/index.json",
				"junit:./AllFolder/Junit Report/index.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:./Rerun/failed.txt"
				}
		)

public class RunAll {

	@AfterClass  //--> must be static method 
	public static void report() {
		JVMReport.generateJVMReport(System.getProperty("user.dir")+"./AllFolder/Json Report/index.json");
	}
}
