package com.siliconelabs.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup {

	static ExtentReports extent;
	static ExtentSparkReporter sparkReport;
	static ExtentTest extentTest;

	public static ExtentReports extentReportSetup() {

		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport/" + "1.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);

		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("Test Automation Report");
		sparkReport.config().setReportName("Regression Test");

		return extent;

	}

}
