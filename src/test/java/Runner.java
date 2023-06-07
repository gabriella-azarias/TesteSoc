import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = "pretty",
    monochrome = true,
    snippets = SnippetType.UNDERSCORE,
    dryRun = false,
    strict = false
)
public class Runner {

}
