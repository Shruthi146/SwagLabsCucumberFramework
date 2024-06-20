package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportPath;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance(getReportPath());
        }
        return extent;
    }

    private static String getReportPath() {
        if (reportPath == null) {
            String baseFolder = "target/ExtentReport";
            String dateTimePattern = new SimpleDateFormat("d-MMM--YY HH-mm-ss").format(new Date());
            reportPath = baseFolder + "/" + dateTimePattern + "/SparkReport/ExtentReports-TestExecutionreport.html";
        }
        return reportPath;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("Extent Reports");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Shruthi S");
        return extent;
    }
}
