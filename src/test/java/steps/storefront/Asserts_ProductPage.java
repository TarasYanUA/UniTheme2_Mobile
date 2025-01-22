package steps.storefront;

import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Asserts_ProductPage {
    public Asserts_ProductPage() {
        super();
    }

    SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();

    //Настройки темы, вкладка "Товар"
    SelenideElement customBlockID = $(".ut2-pb__custom-block");
    SelenideElement showQuantityChanger = $("div.ty-qty[id*='qty_']");
    SelenideElement showProductCode = $(".ut2-pb__sku");
    SelenideElement showProductFeatures = $(".ty-features-list");
    SelenideElement showFeaturesInTwoColumns_Enabled = $(".fg-two-col");
    SelenideElement showFeaturesInTwoColumns_Disabled = $("div.cm-ab-similar-filter-container");
    SelenideElement showShortDescription = $(".ut2-pb__short-descr");
    SelenideElement youSave_Full = $(".ty-save-price:not(.ut2-sld-short .ty-save-price)");
    SelenideElement youSave_Short = $(".ut2-sld-short .ty-save-price");
    SelenideElement showStickyBlockAddToCart = $(".ut2-pb__sticky_add_to_cart");
    SelenideElement showProductBrandInformation_Name = $(".ut2-pb__product-brand-name");
    SelenideElement showProductBrandInformation_Logo = $(".ut2-pb__product-brand");
    SelenideElement appearanceOfImageGallery_Counter = $(".abt__ut2_pig_counter");
    SelenideElement appearanceOfImageGallery_Dots = $(".abt__ut2_pig_counter.lines");
    SelenideElement appearanceOfImageGallery_Default = $(".ty-product-thumbnails_gallery");
    SelenideElement shareButtons = $(".ut2-pb__share");


    @And("Выполняем проверки на странице товара:")
    public void assertsOnProductPage(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                //Настройки темы, вкладка "Товар"
                case "ID пользовательского блока":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(customBlockID.exists())
                                .as("There is no Custom block on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(customBlockID.exists())
                                .as("There is a Custom block but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать модификатор количества":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showQuantityChanger.exists())
                                .as("There is no Quantity changer on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showQuantityChanger.exists())
                                .as("There is a Quantity changer but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать код товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showProductCode.exists())
                                .as("There is no Product Code on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showProductCode.exists())
                                .as("There is a Product Code but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать характеристики товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showProductFeatures.exists())
                                .as("There is no Product features on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showProductFeatures.exists())
                                .as("There are Product features but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать характеристики в две колонки":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showFeaturesInTwoColumns_Enabled.exists())
                                .as("Features are located in one column instead of two on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showFeaturesInTwoColumns_Disabled.exists())
                                .as("Features are located in two columns instead of one on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать краткое описание":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showShortDescription.exists())
                                .as("There is no Short description on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showShortDescription.exists())
                                .as("There is a Short description but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать \"Вы экономите\"":
                    if (value.equalsIgnoreCase("Полный вид")) {
                        softAssert.assertThat(youSave_Full.exists())
                                .as("The text 'You save' is not Full or missed on the product page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Сокращенный вид")) {
                        softAssert.assertThat(youSave_Short.exists())
                                .as("The text 'You save' is not Short or missed in the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать липкий блок Купить":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showStickyBlockAddToCart.exists())
                                .as("There is no Sticky block 'Add to Cart' on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showStickyBlockAddToCart.exists())
                                .as("There is a Sticky block 'Add to Cart' but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать информацию о бренде товара":
                    if (value.equalsIgnoreCase("Отображать название бренда товара")) {
                        softAssert.assertThat(showProductBrandInformation_Name.exists())
                                .as("There is no Product Brand Name on the product page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Отображать логотип бренда товара")) {
                        softAssert.assertThat(showProductBrandInformation_Logo.exists())
                                .as("There is a Product Brand Name but shouldn't on the product page!")
                                .isFalse();
                    } else if (value.equalsIgnoreCase("Не отображать")) {
                        softAssert.assertThat(showProductBrandInformation_Name.exists() || showProductBrandInformation_Logo.exists())
                                .as("There is a Brand name or Brand logo but shouldn't!")
                                .isFalse();
                    }
                    break;

                case "Внешний вид галереи изображений":
                    if (value.equalsIgnoreCase("Только счетчик")) {
                        softAssert.assertThat(appearanceOfImageGallery_Counter.exists())
                                .as("The appearance of image gallery is not 'Counter' on the product page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Только точки")) {
                        softAssert.assertThat(appearanceOfImageGallery_Dots.exists())
                                .as("The appearance of image gallery is not 'Dots' on the product page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("По умолчанию")) {
                        softAssert.assertThat(appearanceOfImageGallery_Default.exists())
                                .as("The appearance of image gallery is not 'Default' on the product page!")
                                .isTrue();
                    }
                    break;

                case "Отображать кнопки социальных сетей":
                    if(value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(shareButtons.exists())
                                .as("There is no Share button on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(shareButtons.exists())
                                .as("There is a Share button but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;
            }
        }
    }
}