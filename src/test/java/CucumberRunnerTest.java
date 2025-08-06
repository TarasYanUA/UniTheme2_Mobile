import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        //tags = "",
        //tags = "@ProductBlock_GridMore_Var1 or @ProductBlock_GridMore_Var2 or @ProductBlock_GridMore_Var3",
        //tags = "@ProductBlock_Scroller_Var1 or @ProductBlock_Scroller_Var2 or @ProductBlock_Scroller_Var3",
        //tags = "@ProductBlock_SmallItems_Var1 or @ProductBlock_SmallItems_Var2 or @ProductBlock_SmallItems_Var3",

        //tags = "@BottomStickyPanel_Var1 or @BottomStickyPanel_Var2 or @BottomStickyPanel_Var3",

        //tags = "@CategoryPage_Grid_Var1 or @CategoryPage_Grid_Var2 or @CategoryPage_Grid_Var3",
        //tags = "@CategoryPage_ListWithoutOptions_Var1 or @CategoryPage_ListWithoutOptions_Var2",
        //tags = "@CategoryPage_CompactList_Var1 or @CategoryPage_CompactList_Var2",

        tags = "@CategoryPage_ListWithoutOptions_Var2",

        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"}
)
public class CucumberRunnerTest {
}