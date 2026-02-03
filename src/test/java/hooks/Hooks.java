package hooks;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.*;

import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeAll
    public static void initReport() {
        extent = ExtentManager.getExtent();
    }

    @Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver();
        ExtentTest test = extent.createTest(scenario.getName());
        extentTest.set(test);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        ExtentTest test = extentTest.get();

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName() + "_" + System.currentTimeMillis());

        if (scenario.isFailed()) {
            test.fail("Step failed").addScreenCaptureFromPath(screenshotPath);
        } else {
            test.pass("Step passed").addScreenCaptureFromPath(screenshotPath);
        }
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        extent.flush();
    }
}
