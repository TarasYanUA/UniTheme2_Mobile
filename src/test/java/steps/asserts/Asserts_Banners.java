package steps.asserts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;
import steps.adminPanel.LayoutPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Asserts_Banners {
    public Asserts_Banners() {
        super();
    }

    SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();
    String blockID = LayoutPage.blockID;

    private final String productBlockSelector = "//div[contains(@id, 'products') and contains(@id, '" + blockID + "')]/..";

    SelenideElement templateOfProducts_Grid = $(productBlockSelector + "/div[contains(@class, 'grid-list')]");
    SelenideElement templateOfProducts_SmallElements = $(productBlockSelector + "//ul[contains(@class, 'ut2-template-small')]");
    SelenideElement templateOfProducts_Thumbnails = $(productBlockSelector + "//div[contains(@class, 'ut2-thumbnail-list')]");
    SelenideElement columnsOfProducts_Grid = $(productBlockSelector + "//div[contains(@class, 'ty-column')]");
    SelenideElement columnsOfProducts_SmallElements = $(productBlockSelector + "//ul[contains(@style, '--si-columns: ')]");
    SelenideElement columnsOfProducts_Thumbnails = $(productBlockSelector + "//div[contains(@style, '--tls-pr-count: ')]");
    SelenideElement bannerTitle = $(productBlockSelector + "/..//div[contains(@class, 'ut2-a__title')]");
    SelenideElement productScroller = $(productBlockSelector + "//button[contains(@class, 'ut2-scroll-right') and not(contains(@style, 'display: none'))]");
    ElementsCollection quantityOfProducts_Grid = $$(productBlockSelector + "//div[contains(@class, 'ty-column')]");
    ElementsCollection quantityOfProducts_SmallElements = $$(productBlockSelector + "//li[contains(@class, 'ut2-template-small__item')]");
    ElementsCollection quantityOfProducts_Thumbnails = $$(productBlockSelector + "//div[contains(@class, 'ut2-thumbnail-list__item')]");
    

    @And("Выполняем проверки в блоке с баннером:")
    public void assertsAtBlockWithBanner(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Проверяем, что шаблон у товаров \"Сетка\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(templateOfProducts_Grid.exists())
                                .as("Template of products is not 'Grid'!")
                                .isTrue();
                    }
                    break;

                case "Проверяем, что шаблон у товаров \"Мелкие элементы\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(templateOfProducts_SmallElements.exists())
                                .as("Template of products is not 'Small elements'!")
                                .isTrue();
                    }
                    break;

                case "Проверяем, что шаблон у товаров \"Миниатюры\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(templateOfProducts_Thumbnails.exists())
                                .as("Template of products is not 'Thumbnails'!")
                                .isTrue();
                    }
                    break;

                case "Проверяем у баннера с шаблоном \"Сетка\" количество товаров":
                    softAssert.assertThat(quantityOfProducts_Grid.size())
                            .as("Number of products in 'Grid' template is not " + value)
                            .isEqualTo(Integer.parseInt(value));
                    break;

                case "Проверяем у баннера с шаблоном \"Мелкие элементы\" количество товаров":
                    softAssert.assertThat(quantityOfProducts_SmallElements.size())
                            .as("Number of products in 'Small elements' template is not " + value)
                            .isEqualTo(Integer.parseInt(value));
                    break;

                case "Проверяем у баннера с шаблоном \"Миниатюры\" количество товаров":
                    softAssert.assertThat(quantityOfProducts_Thumbnails.size())
                            .as("Number of products in 'Thumbnails' template is not " + value)
                            .isEqualTo(Integer.parseInt(value));
                    break;

                default:
                    System.out.println("Неизвестная проверка: " + setting);
                    break;
            }
        }
    }
}
