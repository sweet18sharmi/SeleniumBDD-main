
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by Sharmila on 14-07-2022.
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"pretty", "html:target/index.html", "json:target/cucumber.json"},
        features = "src/test/resources/features",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"summary" } /* , tags = "@both" */ )

public class Runner {
}
