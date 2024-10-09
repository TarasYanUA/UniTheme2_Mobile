package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;
import steps.adminPanel.LayoutPage;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class AssertsOnStorefront {
    public AssertsOnStorefront() {
        super();
    }

    SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();
    String blockID = LayoutPage.blockID;


    //Настройки темы -- вкладка "Списки товаров"

    //Настройка "Обесцвечивать товары, которых нет в наличии"
    SelenideElement decolorizeOutOfStockProducts = $(".ut2-gl__body.content-on-hover.decolorize");

    //Настройка "Отображать пустые звёзды рейтинга товара"
    SelenideElement emptyStarsOfProductRating = $("div[class*='ty-product-review-reviews-stars'][data-ca-product-review-reviews-stars-full='0']");

    SelenideElement getEmptyStarsOfProductRating() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[class*='ty-product-review-reviews-stars'][data-ca-product-review-reviews-stars-full='0']");
    }

    //Настройка "Отображать общее значение рейтинга товара"
    SelenideElement commonValueOfProductRating = $(".ut2-show-rating-num");

    SelenideElement getCommonValueOfProductRating() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-show-rating-num");
    }

    //Настройка "Отображать статусы для кнопок "Купить" -- Иконка"
    SelenideElement statusesForButton_AddToCart_Icon = $("a.ut2-added-to-cart");
    //Настройка "Отображать статусы для кнопок "Купить" -- Количество товаров"
    SelenideElement statusesForButton_AddToCart_Number = $("a.ut2-added-to-cart[data-added-amount='1']");

    //Настройка "Отображать статусы для кнопок... "Добавить в избранное"
    SelenideElement statusesForButton_AddToWishList = $("a.ut2-add-to-wish.active");

    //Настройка "Отображать статусы для кнопок... "Добавить в список сравнения"
    SelenideElement statusesForButton_AddToComparisonList = $("a.ut2-add-to-wish.active");

    //Настройка "Отображать кнопку "Добавить в избранное""
    SelenideElement button_AddToWishList = $(".ut2-add-to-wish");

    SelenideElement getButton_AddToWishList() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-add-to-wish");
    }

    //Настройка "Отображать кнопку "Добавить в список сравнения""
    SelenideElement button_AddToComparisonList = $(".ut2-add-to-compare");

    SelenideElement getButton_AddToComparisonList() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-add-to-compare");
    }

    //Настройка "Отображать кнопки "Быстрый просмотр, Добавить в избранное, Добавить в список сравнения" при наведении на ячейку товара"
    SelenideElement buttonsAreDisplayedOnHover = $(".ut2-w-c-q__buttons.w_c_q-hover");

    SelenideElement getButtonsAreDisplayedOnHover() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-w-c-q__buttons.w_c_q-hover");
    }


    //Настройка "Отображать "Вы экономите -- Полный вид"
    SelenideElement text_YouSave_Full = $("span.ty-save-price");

    SelenideElement getText_YouSave_Full() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] span.ty-save-price");
    }

    //Настройка "Отображать "Вы экономите -- Сокращенный вид"
    SelenideElement text_YouSave_Short = $(".ut2-sld-short span.ty-save-price");

    SelenideElement getText_YouSave_Short() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-sld-short span.ty-save-price");
    }


    //Настройка "Отображать код товара"
    SelenideElement productCode = $("label[id*='sku_']");

    SelenideElement getProductCode() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] label[id*='sku_']");
    }

    //Настройка "Отображать статус наличия"
    SelenideElement availabilityStatus = $(".ty-qty-in-stock.ty-control-group__item");

    SelenideElement getAvailabilityStatus() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ty-qty-in-stock.ty-control-group__item");
    }

    //Настройка "Отображать модификатор количества"
    SelenideElement quantityChanger = $("div[class='ty-center ty-value-changer cm-value-changer']");

    SelenideElement getQuantityChanger() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[class='ty-center ty-value-changer cm-value-changer']");
    }


    //Настройки темы -- вкладка "Списки товаров -- "Вид списка "Сетка"

    // Настройка "Отображать кнопку "Купить" -- Только иконка корзины"
    SelenideElement gridList__ShowAddToCartButton_IconOnly = $(".ut2-icon-use_icon_cart");

    SelenideElement getGridList__ShowAddToCartButton_IconOnly() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-icon-use_icon_cart");
    }

    //Настройка "Отображать кнопку "Купить" -- Только текст"
    SelenideElement gridList__ShowAddToCartButton_TextOnly = $(".ty-btn__primary.ty-btn__add-to-cart.cm-form-dialog-closer");

    SelenideElement getGridList__ShowAddToCartButton_TextOnly() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ty-btn__primary.ty-btn__add-to-cart.cm-form-dialog-closer");
    }


    //Настройка "Дополнительная информация о товаре -- Краткое описание"
    SelenideElement additionalInformationOfProduct_ShortDescription = $(".product-description");

    SelenideElement getAdditionalInformationOfProduct_ShortDescription() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .product-description");
    }

    //Настройка "Дополнительная информация о товаре -- Характеристики"
    SelenideElement additionalInformationOfProduct_Features = $(".ut2-gl__feature");

    SelenideElement getAdditionalInformationOfProduct_Features() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-gl__feature");
    }


    //Настройка "Отображать дополнительную информацию при наведении"
    SelenideElement additionalInformationOnHover = $("div[class='ut2-gl__body content-on-hover']");

    SelenideElement getAdditionalInformationOnHover() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[class='ut2-gl__body content-on-hover']");
    }

    //Настройка "Отображать логотип бренда"
    SelenideElement brandLogo = $(".brand-img");

    SelenideElement getBrandLogo() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .brand-img");
    }


    //Настройка "Отображать стандартную галерею изображений -- Навигация точками"
    SelenideElement galleryOgMiniIcons_Dots = $(".owl-pagination");

    SelenideElement getGalleryOgMiniIcons_Dots() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .owl-pagination");
    }

    //Настройка "Отображать стандартную галерею изображений -- Навигация стрелками"
    SelenideElement galleryOgMiniIcons_Arrows = $(".ut2-gl__body.content-on-hover .icon-right-circle");

    SelenideElement getGalleryOgMiniIcons_Arrows() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-gl__body.content-on-hover .icon-right-circle");
    }


    //Настройка "Переключать изображение товара при движении мышки -- с полосками"
    SelenideElement switchProductImage_WithStripes = $("div[class='cm-ab-hover-gallery abt__ut2_hover_gallery lines']");


    //Настройки -- Общие настройки -- Внешний вид

    //Текст налога "[цена налога] + Вкл налог". Настройка "Показывать цены с налогом на страницах категорий и товаров"
    SelenideElement pricesWithTaxes = $("span[id*='line_product_price_']");

    SelenideElement getPricesWithTaxes() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] span[id*='line_product_price_']");
    }

    //Настройка "Показывать мини-иконки в виде галереи"
    SelenideElement miniThumbnailImagesAsGallery = $(".ty-icon-right-open-thin");


    //Настройки блока товаров

    //Настройка "Количество колонок в списке"
    ElementsCollection getNumberOfColumnsInBlock() {
        return $$("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[class*='ty-column']");
    }

    //Настройка "Максимальное число элементов"
    ElementsCollection getMaxNumberOfColumnsInBlock() {
        return $$("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-gl__item");
    }


    @And("Выполняем проверки в блоке:")
    public void assertsAtBlock(DataTable table) {
        executeJavaScript("window.scrollBy(0, -450);");
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                //Проверяем количество колонок. Настройка блока "Количество колонок в списке"
                case "Количество колонок в списке":
                    softAssert.assertThat(getNumberOfColumnsInBlock().size())
                            .as("Number of columns is not equal to " + value + " in the product block!")
                            .isEqualTo(Integer.parseInt(value));
                    break;

                //Проверяем пустые звёздочки рейтинга
                case "Отображать пустые звёзды рейтинга товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getEmptyStarsOfProductRating().exists())
                                .as("There are no empty stars in the product block!")
                                .isTrue();

                    } else {
                        softAssert.assertThat(getEmptyStarsOfProductRating().exists())
                                .as("There are empty stars but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем общее значение рейтинга товара
                case "Отображать общее значение рейтинга товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getCommonValueOfProductRating().exists())
                                .as("There are no common value of product rating in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getCommonValueOfProductRating().exists())
                                .as("There is common value of product rating but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем кнопку "Избранное"
                case "Отображать кнопку \"Добавить в избранное\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getButton_AddToWishList().exists())
                                .as("There is no button 'Add to wish list' in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getButton_AddToWishList().exists())
                                .as("There is a button 'Add to wish list' but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем кнопку "Сравнить" присутствует
                case "Отображать кнопку \"Добавить в список сравнения\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getButton_AddToComparisonList().shouldBe(Condition.visible, Duration.ofSeconds(10)).exists())
                                .as("There is no button 'Add to comparison list' in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getButton_AddToComparisonList().exists())
                                .as("There is a button 'Add to comparison list' but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем отображение кнопок "Быстрый просмотр, Добавить в избранное, Добавить в список сравнения" при наведении на ячейку товара
                case "Отображать кнопки \"Быстрый просмотр, Добавить в избранное, Добавить в список сравнения\" при наведении на ячейку товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getButtonsAreDisplayedOnHover().exists())
                                .as("Buttons are not displayed when hovering over a product cell in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getButtonsAreDisplayedOnHover().exists())
                                .as("Buttons are displayed when hovering over a product cell but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем текст "Вы экономите"
                case "Отображать \"Вы экономите\"":
                    if (value.equalsIgnoreCase("Сокращенный вид")) {
                        softAssert.assertThat(getText_YouSave_Short().exists())
                                .as("The text 'You save' is not Short or missed in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Полный вид")) {
                        softAssert.assertThat(getText_YouSave_Full().exists())
                                .as("The text 'You save' is not Full or missed in the product block!")
                                .isTrue();
                    }
                    break;

                //Проверяем код товара
                case "Отображать код товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getProductCode().exists())
                                .as("There is no product code in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getProductCode().exists())
                                .as("There is a product code but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем статус наличия
                case "Отображать статус наличия":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getAvailabilityStatus().exists())
                                .as("There is no availability status in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getAvailabilityStatus().exists())
                                .as("There is an availability status but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем модификатор количества
                case "Отображать модификатор количества":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getQuantityChanger().exists())
                                .as("There is no quantity Changer in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getQuantityChanger().exists())
                                .as("There is a quantity Changer but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем вид кнопки "Купить"
                case "Отображать кнопку \"Купить\"":
                    if (value.equalsIgnoreCase("Только иконка корзины")) {
                        softAssert.assertThat(getGridList__ShowAddToCartButton_IconOnly().exists())
                                .as("The button 'Add to cart' does not have a view 'Icon only' in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Только текст")) {
                        softAssert.assertThat(getGridList__ShowAddToCartButton_TextOnly().exists())
                                .as("The button 'Add to cart' does not have a view 'Text only' in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Иконка корзины и текст")) {
                        softAssert.assertThat(getGridList__ShowAddToCartButton_IconOnly().exists()
                                        && getGridList__ShowAddToCartButton_TextOnly().exists())
                                .as("The button 'Add to cart' does not have a view 'Icon and Text' in the product block!")
                                .isTrue();
                    }
                    break;

                //Проверяем дополнительную информацию о товаре
                case "Дополнительная информация о товаре":
                    if (value.equalsIgnoreCase("Краткое описание")) {
                        softAssert.assertThat(getAdditionalInformationOfProduct_ShortDescription().exists())
                                .as("Additional information about products is not 'Short description' in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Характеристики")) {
                        softAssert.assertThat(getAdditionalInformationOfProduct_Features().exists())
                                .as("Additional information about products is not 'Features' in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Краткое описание и характеристики")) {
                        softAssert.assertThat(getAdditionalInformationOfProduct_ShortDescription().exists()
                                        && getAdditionalInformationOfProduct_Features().exists())
                                .as("Additional information about products is not 'Short description and features' in the product block!")
                                .isTrue();
                    }
                    break;

                //Проверяем отображение дополнительной информации при наведении на ячейку товара
                case "Отображать дополнительную информацию при наведении":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getAdditionalInformationOnHover().exists())
                                .as("Additional information is displayed without mouse hover in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getAdditionalInformationOnHover().exists())
                                .as("Additional information is displayed with mouse hover but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем логотип бренда
                case "Отображать логотип бренда":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getBrandLogo().exists())
                                .as("There is no brand logo in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getBrandLogo().exists())
                                .as("There is a brand logo but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем настройку "Отображать стандартную галерею изображений"
                case "Отображать стандартную галерею изображений":
                    if (value.equalsIgnoreCase("Навигация точками")) {
                        softAssert.assertThat(getGalleryOgMiniIcons_Dots().exists())
                                .as("Image gallery of the product is not with Dots navigation in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Навигация стрелками")) {
                        softAssert.assertThat(getGalleryOgMiniIcons_Arrows().exists())
                                .as("Image gallery of the product is not with Arrows navigation in the product block!")
                                .isTrue();
                    }
                    break;

                //Проверяем максимальное количество элементов в блоке (не превышает указанное значение)
                case "Макс. число элементов":
                    softAssert.assertThat(getMaxNumberOfColumnsInBlock().size())
                            .as("Max number of products increases " + value + " products in the product block!")
                            .isLessThanOrEqualTo(Integer.parseInt(value));
                    break;

                //Проверяем текст "[цена налога] + Вкл налог"
                case "Текст налога \"[цена налога] + Вкл налог\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getPricesWithTaxes().exists())
                                .as("There is no text of a product tax in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getPricesWithTaxes().exists())
                                .as("There is a text of a product tax but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;
            }
        }
    }
}