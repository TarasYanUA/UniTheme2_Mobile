package steps.storefront;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;
import steps.adminPanel.LayoutPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Asserts_ProductBlock_CategoryPage {
    public Asserts_ProductBlock_CategoryPage() {
        super();
    }

    SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();
    String blockID = LayoutPage.blockID;


    //Настройки темы -- вкладка "Списки товаров"

    //Настройка "Обесцвечивать товары, которых нет в наличии"
    SelenideElement decolorizeOutOfStockProducts = $(".decolorize");

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

    //Настройка "Отображать "Вы экономите -- Сокращенный вид" (вариант "Полный вид" на мобильном отсутствует)
    String text_YouSave_Short = " .ut2-sld-short span.ty-save-price";

    SelenideElement youSave_Short_Grid = $(".ut2-gl__body" + text_YouSave_Short);

    SelenideElement youSave_Short_ListWithoutOptions = $(".ty-product-list" + text_YouSave_Short);

    SelenideElement youSave_Short_CompactList = $(".ty-compact-list__content" + text_YouSave_Short);

    SelenideElement getText_YouSave_Short() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "']" + text_YouSave_Short);
    }

    //Настройка "Отображать код товара"
    SelenideElement productCode = $("label[id*='sku_']");

    SelenideElement getProductCode() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] label[id*='sku_']");
    }

    //Настройка "Отображать статус наличия"
    String availabilityStatus = " .ty-qty-in-stock.ty-control-group__item";

    SelenideElement availabilityStatus_Grid = $(".ut2-gl__body" + availabilityStatus);

    SelenideElement availabilityStatus_ListWithoutOptions = $(".ty-product-list" + availabilityStatus);

    SelenideElement availabilityStatus_CompactList = $(".ty-compact-list__content" + availabilityStatus);

    SelenideElement getAvailabilityStatus() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "']" + availabilityStatus);
    }

    //Настройка "Отображать модификатор количества"
    SelenideElement quantityChanger = $("div[class='ty-center ty-value-changer cm-value-changer']");

    SelenideElement getQuantityChanger() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[class='ty-center ty-value-changer cm-value-changer']");
    }


    //Настройки темы -- вкладка "Списки товаров -- "Вид списка "Сетка"

    //Настройка "Количество строк в названии товара"
    SelenideElement getNumberOfLinesInProductName(int number) {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[style*='lines-in-name-product: " + number + ";'], " +
                "div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] ul[style*='lines-in-name-product: " + number + ";']");
    }


    SelenideElement numberOfLinesInProductName(String number) {
        return $("div[style*='lines-in-name-product: " + number + ";']");
    }


    // Настройка "Отображать кнопку "Купить" -- Только иконка корзины"
    SelenideElement showAddToCartButton_IconOnly = $(".ut2-icon-use_icon_cart");

    SelenideElement getShowAddToCartButton_IconOnly() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-icon-use_icon_cart");
    }

    //Настройка "Отображать кнопку "Купить" -- Только текст"
    SelenideElement showAddToCartButton_TextOnly = $(".ut2-view-qty.text");

    SelenideElement getShowAddToCartButton_TextOnly() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ty-btn__primary.ty-btn__add-to-cart.cm-form-dialog-closer");
    }

    //Настройка "Отображать кнопку "Купить" -- Иконка корзины и текст"
    SelenideElement showAddToCartButton_IconAndText = $x("//i[@class='ut2-icon-use_icon_cart']//..//bdi[text()='В корзину']");


    //Настройка "Дополнительная информация о товаре -- Краткое описание"
    SelenideElement additionalInformationOfProduct_ShortDescription = $(".product-description");

    //Настройка "Дополнительная информация о товаре -- Характеристики"
    SelenideElement additionalInformationOfProduct_Features = $(".ut2-gl__feature");

    //Настройка "Дополнительная информация о товаре -- Список характеристик и вариаций"
    SelenideElement additionalInformationOfProduct_Variations = $(".ut2-lv__item-features");


    //Настройка "Отображать стандартную галерею изображений -- Навигация точками"
    SelenideElement galleryOfMiniIcons_Dots = $(".owl-pagination");

    SelenideElement getGalleryOfMiniIcons_Dots() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .owl-pagination");
    }

    //Настройка "Отображать стандартную галерею изображений -- Навигация стрелками"
    SelenideElement galleryOgMiniIcons_Arrows = $(".icon-right-circle");

    SelenideElement getGalleryOfMiniIcons_Arrows() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .icon-right-circle");
    }


    //Настройки темы -- вкладка "Списки товаров -- "Вид списка "Список без опций"
    SelenideElement contentUnderDescription_Features = $(".ty-product-feature__label");
    SelenideElement contentUnderDescription_Variations = $(".ut2-lv__item-features");
    SelenideElement showProductOptions = $(".cm-picker-product-options.ty-product-options");
    SelenideElement showBrandLogo = $(".ut2-cat-container .brand-img");


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

    ElementsCollection getNumberOfElements_Mobile() {
        return $$("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .owl-item.active");
    }

    //Настройка "Внешняя навигация"
    SelenideElement getOutsideNavigation() {
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .owl-theme.ty-owl-controls");
    }

    //Настройка "Показать номер элемента"
    SelenideElement numbersOfElements = $(".ut2-hit");


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

                //Проверяем максимальное количество элементов в блоке (не превышает указанное значение). Настройка блока "Макс. число элементов"
                case "Макс. число элементов":
                    softAssert.assertThat(getMaxNumberOfColumnsInBlock().size())
                            .as("Max number of products increases " + value + " products in the product block!")
                            .isLessThanOrEqualTo(Integer.parseInt(value));
                    break;

                //Проверяем, количество элементов в блоке. Настройка блока "Количество элементов (мобильный)"
                case "Количество элементов (мобильный)":
                    softAssert.assertThat(getNumberOfElements_Mobile().size())
                            .as("Number of elements is not equal " + value + " in the product block!")
                            .isEqualTo(Integer.parseInt(value));
                    break;

                //Проверяем Внешнюю навигацию в блоке товаров
                case "Внешняя навигация":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(getOutsideNavigation().exists())
                                .as("There is no Outside navigation in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getOutsideNavigation().exists())
                                .as("There is Outside navigation but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем номера элементов в блоке товаров. Настройка блока "Показать номер элемента"
                case "Показать номер элемента":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(numbersOfElements.exists())
                                .as("There are no Item numbers in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(numbersOfElements.exists())
                                .as("There are Item numbers but shouldn't in the product block!")
                                .isFalse();
                    }
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
                                .as("There is no common value of product rating in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getCommonValueOfProductRating().exists())
                                .as("There is a common value of product rating but shouldn't in the product block!")
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
                        softAssert.assertThat(getButton_AddToComparisonList().exists())
                                .as("There is no button 'Add to comparison list' in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getButton_AddToComparisonList().exists())
                                .as("There is a button 'Add to comparison list' but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем текст "Вы экономите"
                case "Отображать \"Вы экономите\"":
                    if (value.equalsIgnoreCase("Сокращенный вид")) {
                        softAssert.assertThat(getText_YouSave_Short().exists())
                                .as("The text 'You save' is not Short or missed in the product block!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(getText_YouSave_Short().exists())
                                .as("There is a text 'You save' but shouldn't in the product block!")
                                .isFalse();
                    }
                    break;

                //Проверяем Количество строк в названии товара
                case "Количество строк в названии товара":
                    softAssert.assertThat(getNumberOfLinesInProductName(Integer.parseInt(value)).exists())
                            .as("Number of lines in the product name is not " + value)
                            .isTrue();
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
                        softAssert.assertThat(getShowAddToCartButton_IconOnly().exists())
                                .as("The button 'Add to cart' does not have a view 'Icon only' in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Только текст")) {
                        softAssert.assertThat(getShowAddToCartButton_TextOnly().exists())
                                .as("The button 'Add to cart' does not have a view 'Text only' in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Иконка корзины и текст")) {
                        softAssert.assertThat(getShowAddToCartButton_IconOnly().exists()
                                        && getShowAddToCartButton_TextOnly().exists())
                                .as("The button 'Add to cart' does not have a view 'Icon and Text' in the product block!")
                                .isTrue();
                    }
                    break;

                //Проверяем настройку "Отображать стандартную галерею изображений"
                case "Отображать стандартную галерею изображений":
                    if (value.equalsIgnoreCase("Навигация точками")) {
                        softAssert.assertThat(getGalleryOfMiniIcons_Dots().exists())
                                .as("Image gallery of the product is not with Dots navigation in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Навигация стрелками")) {
                        softAssert.assertThat(getGalleryOfMiniIcons_Arrows().exists())
                                .as("Image gallery of the product is not with Arrows navigation in the product block!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Не отображать")) {
                        softAssert.assertThat(getGalleryOfMiniIcons_Dots().exists() && getGalleryOfMiniIcons_Arrows().exists())
                                .as("Image gallery of the product is not switched off in the product block!")
                                .isFalse();
                    }
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

                default:
                    System.out.println("Неизвестная проверка: " + setting);
                    break;
            }
        }
    }

    @And("Выполняем проверки на странице категории:")
    public void assertsOnCategoryPage(DataTable table) {
        executeJavaScript("window.scrollBy(0, -450);");
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Обесцвечивать товары, которых нет в наличии":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(decolorizeOutOfStockProducts.exists())
                                .as("There is no decolorized product on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(decolorizeOutOfStockProducts.exists())
                                .as("There are decolorized products but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Отображать пустые звёзды рейтинга товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(emptyStarsOfProductRating.exists())
                                .as("There are no empty stars on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(emptyStarsOfProductRating.exists())
                                .as("There are empty stars but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Отображать общее значение рейтинга товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(commonValueOfProductRating.exists())
                                .as("There is no common value of product rating on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(commonValueOfProductRating.exists())
                                .as("There is a common value of product rating but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Отображать кнопку \"Добавить в избранное\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(button_AddToWishList.exists())
                                .as("There is no button 'Add to wish list' on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(button_AddToWishList.exists())
                                .as("There is a button 'Add to wish list' but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Отображать кнопку \"Добавить в список сравнения\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(button_AddToComparisonList.exists())
                                .as("There is no button 'Add to comparison list' on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(button_AddToComparisonList.exists())
                                .as("There is a button 'Add to comparison list' but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Сетка, Отображать \"Вы экономите\"":
                    if (value.equalsIgnoreCase("Сокращенный вид")) {
                        softAssert.assertThat(youSave_Short_Grid.exists())
                                .as("The text 'You save' is not Short or missed on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(youSave_Short_Grid.exists())
                                .as("There is a text 'You save' but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Сетка, Количество строк в названии товара":
                    softAssert.assertThat(numberOfLinesInProductName(value).exists())
                            .as("Number of lines in the product name is not " + value)
                            .isTrue();
                    break;

                case "Отображать код товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(productCode.exists())
                                .as("There is no product code on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(productCode.exists())
                                .as("There is a product code but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Сетка, Отображать статус наличия":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(availabilityStatus_Grid.exists())
                                .as("There is no availability status on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(availabilityStatus_Grid.exists())
                                .as("There is an availability status but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Отображать модификатор количества":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(quantityChanger.exists())
                                .as("There is no quantity Changer on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(quantityChanger.exists())
                                .as("There is a quantity Changer but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Отображать кнопку \"Купить\"":
                    if (value.equalsIgnoreCase("Только Иконка корзины")) {
                        softAssert.assertThat(showAddToCartButton_IconOnly.exists())
                                .as("The button 'Add to cart' does not have a view 'Icon only' on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Только текст")) {
                        softAssert.assertThat(showAddToCartButton_TextOnly.exists())
                                .as("The button 'Add to cart' does not have a view 'Text only' on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Иконка корзины и текст")) {
                        softAssert.assertThat(showAddToCartButton_IconAndText.exists())
                                .as("The button 'Add to cart' does not have a view 'Icon and Text' on the category page!")
                                .isTrue();
                    }
                    break;

                case "Дополнительная информация о товаре":
                    if (value.equalsIgnoreCase("Краткое описание и характеристики")) {
                        softAssert.assertThat(additionalInformationOfProduct_ShortDescription.exists() && additionalInformationOfProduct_Features.exists())
                                .as("Additional information about products is not 'Short description and variations' on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Список характеристик и вариаций")) {
                        softAssert.assertThat(additionalInformationOfProduct_Features.exists() && additionalInformationOfProduct_Variations.exists())
                                .as("Additional information about products is not 'Features and variations list' on the category page!")
                                .isTrue();
                    }
                    break;

                case "Отображать стандартную галерею изображений":
                    if (value.equalsIgnoreCase("Навигация точками")) {
                        softAssert.assertThat(galleryOfMiniIcons_Dots.exists())
                                .as("Standard Image Gallery of the product is not with Dots navigation on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Навигация стрелками")) {
                        softAssert.assertThat(galleryOgMiniIcons_Arrows.exists())
                                .as("Standard Image Gallery of the product is not with Arrows navigation on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Не отображать")) {
                        softAssert.assertThat(galleryOfMiniIcons_Dots.exists() && galleryOgMiniIcons_Arrows.exists())
                                .as("Standard Image Gallery of the product is not switched off on the category page!")
                                .isFalse();
                    }
                    break;

                case "Текст налога \"[цена налога] + Вкл налог\"":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(pricesWithTaxes.exists())
                                .as("There is no text of a product tax on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(pricesWithTaxes.exists())
                                .as("There is a text of a product tax but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Список без опций, Отображать \"Вы экономите\"":
                    if (value.equalsIgnoreCase("Сокращенный вид")) {
                        softAssert.assertThat(youSave_Short_ListWithoutOptions.exists())
                                .as("The text 'You save' is not Short or missed on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(youSave_Short_ListWithoutOptions.exists())
                                .as("There is a text 'You save' but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Список без опций, Отображать статус наличия":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(availabilityStatus_ListWithoutOptions.exists())
                                .as("There is no availability status on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(availabilityStatus_ListWithoutOptions.exists())
                                .as("There is an availability status but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Список без опций, Содержимое под описанием":
                    if (value.equalsIgnoreCase("Список характеристик")) {
                        softAssert.assertThat(contentUnderDescription_Features.exists())
                                .as("Content under description is not 'Features' on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Список вариаций")) {
                        softAssert.assertThat(contentUnderDescription_Variations.exists())
                                .as("Content under description is not 'Variations' on the category page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Список характеристик и вариаций")) {
                        softAssert.assertThat(contentUnderDescription_Features.exists() && contentUnderDescription_Variations.exists())
                                .as("Content under description is not 'Features and variations list' on the category page!")
                                .isTrue();
                    }
                    break;

                case "Список без опций, Отображать опции товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showProductOptions.exists())
                                .as("There are no Product Options on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showProductOptions.exists())
                                .as("There are Product Options but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Список без опций, Отображать логотип бренда":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showBrandLogo.exists())
                                .as("There is no Brand logo on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showBrandLogo.exists())
                                .as("There is a Brand logo but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Компактный список, Отображать \"Вы экономите\"":
                    if (value.equalsIgnoreCase("Сокращенный вид")) {
                        softAssert.assertThat(youSave_Short_CompactList.exists())
                                .as("The text 'You save' is not Short or missed on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(youSave_Short_CompactList.exists())
                                .as("There is a text 'You save' but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                case "Компактный список, Отображать статус наличия":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(availabilityStatus_CompactList.exists())
                                .as("There is no availability status on the category page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(availabilityStatus_CompactList.exists())
                                .as("There is an availability status but shouldn't on the category page!")
                                .isFalse();
                    }
                    break;

                default:
                    System.out.println("Неизвестная проверка: " + setting);
                    break;
            }
        }
    }
}