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

public class AssertsOnStorefront {
    public AssertsOnStorefront(){super();}

    SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();
    String blockID = LayoutPage.blockID;


    //Настройки темы -- вкладка "Списки товаров"

    //Настройка "Обесцвечивать товары, которых нет в наличии"
    SelenideElement decolorizeOutOfStockProducts = $x(".ut2-gl__body.content-on-hover.decolorize");

    //Настройка "Отображать пустые звёзды рейтинга товара"
    SelenideElement emptyStarsOfProductRating = $("div[class*='ty-product-review-reviews-stars'][data-ca-product-review-reviews-stars-full='0']");

    //Настройка "Отображать общее значение рейтинга товара"
    SelenideElement commonValueOfProductRating = $(".ut2-show-rating-num");

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

    //Настройка "Отображать кнопку "Добавить в список сравнения""
    SelenideElement button_AddToComparisonList = $(".ut2-add-to-compare");

    //Настройка "Отображать кнопки "Быстрый просмотр, Добавить в избранное, Добавить в список сравнения" при наведении на ячейку товара"
    SelenideElement buttonsAreDisplayedOnHover = $(".ut2-w-c-q__buttons.w_c_q-hover");

    //Настройка "Отображать "Вы экономите -- Полный вид"
    SelenideElement text_YouSave_Full = $("span.ty-save-price");
    //Настройка "Отображать "Вы экономите -- Сокращенный вид"
    SelenideElement text_YouSave_Short = $(".ut2-sld-short span.ty-save-price");

    //Настройка "Отображать код товара"
    SelenideElement productCode = $("label[id*='sku_']");

    //Настройка "Отображать статус наличия"
    SelenideElement availabilityStatus = $(".ty-qty-in-stock.ty-control-group__item");
    public SelenideElement getAvailabilityStatus(){
        return $("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ty-qty-in-stock.ty-control-group__item");
    }

    //Настройка "Отображать модификатор количества"
    SelenideElement quantityChanger = $("div[class='ty-center ty-value-changer cm-value-changer']");


    //Настройки темы -- вкладка "Списки товаров -- "Вид списка "Сетка"

    // Настройка "Отображать кнопку "Купить" -- Только иконка корзины"
    SelenideElement gridList__ShowAddToCartButton_IconOnly = $(".ut2-icon-use_icon_cart");
    //Настройка "Отображать кнопку "Купить" -- Только текст"
    SelenideElement gridList__ShowAddToCartButton_TextOnly = $(".ty-btn__primary.ty-btn__add-to-cart.cm-form-dialog-closer");

    //Настройка "Отображать дополнительную информацию при наведении"
    SelenideElement additionalInformationOnHover = $("div[class='ut2-gl__body content-on-hover']");

    //Настройка "Отображать логотип бренда"
    SelenideElement brandLogo = $(".brand-img");

    //Настройка "Отображать стандартную галерею изображений -- Навигация точками"
    SelenideElement galleryOgMiniIcons_Dots = $(".owl-pagination");
    //Настройка "Отображать стандартную галерею изображений -- Навигация стрелками"
    SelenideElement galleryOgMiniIcons_Arrows = $(".ut2-gl__body.content-on-hover .icon-right-circle");

    //Настройка "Переключать изображение товара при движении мышки -- с полосками"
    SelenideElement switchProductImage_WithStripes = $("div[class='cm-ab-hover-gallery abt__ut2_hover_gallery lines']");


    //Настройки -- Общие настройки -- Внешний вид

    //Текст налога "[цена налога] + Вкл налог". Настройка "Показывать цены с налогом на страницах категорий и товаров"
    SelenideElement pricesWithTaxes = $("span[id*='line_product_price_']");

    //Настройка "Показывать мини-иконки в виде галереи"
    SelenideElement miniThumbnailImagesAsGallery = $(".ty-icon-right-open-thin");


    //Настройки блока товаров

    //Настройка "Количество колонок в списке"
    ElementsCollection numberOfColumnsInList() {
        return $$("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] div[class*='ty-column']");
    }

    //Настройка "Максимальное число элементов"
    ElementsCollection maxNumberOfColumns(){
        return $$("div[id^='content_abt__ut2_grid_tab_'][id$='" + blockID + "'] .ut2-gl__item");
    }


    @And("Выполняем проверки в блоке на витрине:")
    public void assertsAtBlock(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for(List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch(setting) {
                case "Количество колонок в списке":
                    softAssert.assertThat(numberOfColumnsInList().size())
                            .as("Number of columns is not equal to " + value + " in the product block!")
                            .isEqualTo(Integer.parseInt(value));
            }
        }
    }
}