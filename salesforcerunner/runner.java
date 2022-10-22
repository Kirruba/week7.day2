package week7.day2.salesforcerunner;

import io.cucumber.testng.CucumberOptions;
import week7.day2.salesforcesteps.BaseClass;

@CucumberOptions(features = "src/test/java/week7/day2/salesforcefeature", glue = "week7.day2.salesforcesteps", monochrome = true, publish = true, tags = "@regression or @functional or @smoke and @sanity")
public class runner extends BaseClass {

}
