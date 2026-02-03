package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport/ExecutionReport.html");
            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Cucumber Selenium Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
