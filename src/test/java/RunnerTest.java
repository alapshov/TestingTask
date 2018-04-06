import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java",
        tags = "@withdrawal",
        snippets = SnippetType.CAMELCASE
)
public class RunnerTest {

}


