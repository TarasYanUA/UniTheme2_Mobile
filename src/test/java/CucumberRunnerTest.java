import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        tags = "@BottomStickyPanel_Var2",
        //@ProductBlock_GridMore_Var1 or @ProductBlock_GridMore_Var2 or @ProductBlock_GridMore_Var3
        //@ProductBlock_Scroller_Var1 or @ProductBlock_Scroller_Var2 or @ProductBlock_Scroller_Var3
        //@ProductBlock_SmallItems_Var1 or @ProductBlock_SmallItems_Var2 or @ProductBlock_SmallItems_Var3
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"}
)
public class CucumberRunnerTest {
}