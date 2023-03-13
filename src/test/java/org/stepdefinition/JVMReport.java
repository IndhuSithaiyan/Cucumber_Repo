package org.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {

	public static void generateJVMReport(String jsonPath) {
		//1.Mention file Location
		File file = new File(System.getProperty("user.dir")+"./AllFolder./JVM Report");

		//2.Add details to the report by using configaration class
		Configuration c = new Configuration(file, "FACEBOOK Application");

		c.addClassifications("Platform", "Windows");
		c.addClassifications("Sprint", "123");
		c.addClassifications("JDK Version", "1.8");

		//3.Add json file path to list
		List<String> list = new ArrayList<String>();
		list.add(jsonPath);

		//4.
		ReportBuilder rB = new ReportBuilder(list, c);
		rB.generateReports();
	}
}
