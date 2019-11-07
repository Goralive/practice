package runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/resources/features/", glue = "steps", monochrome = true,
        format = {"pretty",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber.json",})
@RunWith(Cucumber.class)
public class TestRunner {
        @Rule
        public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

        @Before
        public void setUp() {
            Configuration.startMaximized = true;
            Configuration.reportsFolder = "target/surefire-reports";
        }
}
