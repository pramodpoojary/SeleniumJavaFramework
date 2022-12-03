package pramodpoojary.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		// ExtentReports , ExtentSparkReporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\reports\\index.html");
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results!");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pramod Poojary");

		return extent;
	}

}
