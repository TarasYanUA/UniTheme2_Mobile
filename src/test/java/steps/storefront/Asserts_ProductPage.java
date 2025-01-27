package steps.storefront;

import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Asserts_ProductPage {
    public Asserts_ProductPage() {
        super();
    }

    SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();

    //Настройки темы, вкладка "Товар"
    SelenideElement customBlockID = $(".ut2-pb__custom-block");
    SelenideElement quantityChanger = $("div.ty-qty[id*='qty_']");
    SelenideElement productCode = $(".ut2-pb__sku");
    SelenideElement productFeatures = $(".ty-features-list");
    SelenideElement featuresInTwoColumns_Enabled = $(".fg-two-col");
    SelenideElement featuresInTwoColumns_Disabled = $("div.cm-ab-similar-filter-container");
    SelenideElement shortDescription = $(".ut2-pb__short-descr");
    SelenideElement youSave_Full = $(".ty-save-price:not(.ut2-sld-short .ty-save-price)");
    SelenideElement youSave_Short = $(".ut2-sld-short .ty-save-price");
    SelenideElement stickyBlockAddToCart = $(".ut2-pb__sticky_add_to_cart");
    SelenideElement productBrandInformation_Name = $(".ut2-pb__product-brand-name");
    SelenideElement productBrandInformation_Logo = $(".ut2-pb__product-brand");
    SelenideElement appearanceOfImageGallery_Counter = $(".abt__ut2_pig_counter");
    SelenideElement appearanceOfImageGallery_Dots = $(".abt__ut2_pig_counter.lines");
    SelenideElement shareButtons = $(".ut2-pb__share");

    //CS-Cart настройки
    SelenideElement pricesWithTaxes = $("span[id*='line_product_price_']");
    SelenideElement numberOfAvailableProducts = $x("//span[contains(@class, 'ty-qty-in-stock')][text()='Доступность:']");
    SelenideElement miniThumbnailImagesAsGallery_Enabled = $(".ty-product-thumbnails_gallery");
    SelenideElement miniThumbnailImagesAsGallery_Disabled = $(".ty-product-thumbnails.ty-center");
    SelenideElement displayProductDetailsInTabs_Enabled = $(".ut2-pb__tabs .ty-accordion");
    SelenideElement displayProductDetailsInTabs_Disabled = $(".ut2-pb__tabs .tab-list-title");

    //Характеристики
    SelenideElement showOnFeaturesTab_Brand = $x("//div[@class='ty-product-feature']//span[text()='Бренд']");
    SelenideElement showInHeaderOnProductPage_Brand = $x("//div[@class='ty-features-list']//em[text()='Бренд']");
    SelenideElement showInHeaderOnProductPage_HardDrive = $x("//div[@class='ty-features-list']//em[text()='Жесткий диск']");

    //Настройки из страницы редактирования товара
    SelenideElement listPrice = $("span[id*='old_price_update_'] .ty-list-price");
    SelenideElement pricePerUnit = $(".ty-price-per-unit");
    SelenideElement promoText = $(".ut2-pb__note");
    SelenideElement product_allowPaymentByPoints = $(".ty-reward-group");
    SelenideElement quantityDiscounts = $(".ut2__qty-discounts");


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
                        softAssert.assertThat(quantityChanger.exists())
                                .as("There is no Quantity changer on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(quantityChanger.exists())
                                .as("There is a Quantity changer but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать код товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(productCode.exists())
                                .as("There is no Product Code on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(productCode.exists())
                                .as("There is a Product Code but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать характеристики товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(productFeatures.exists())
                                .as("There is no Product features on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(productFeatures.exists())
                                .as("There are Product features but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать характеристики в две колонки":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(featuresInTwoColumns_Enabled.exists())
                                .as("Features are located in one column instead of two on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(featuresInTwoColumns_Disabled.exists())
                                .as("Features are located in two columns instead of one on the product page!")
                                .isTrue();
                    }
                    break;

                case "Отображать краткое описание":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(shortDescription.exists())
                                .as("There is no Short description on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(shortDescription.exists())
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
                                .as("The text 'You save' is not Short or missed on the product page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Не отображать")) {
                        softAssert.assertThat(youSave_Full.exists() || youSave_Short.exists())
                                .as("There is a text 'You save' but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать липкий блок Купить":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(stickyBlockAddToCart.exists())
                                .as("There is no Sticky block 'Add to Cart' on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(stickyBlockAddToCart.exists())
                                .as("There is a Sticky block 'Add to Cart' but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать информацию о бренде товара":
                    if (value.equalsIgnoreCase("Отображать название бренда товара")) {
                        softAssert.assertThat(productBrandInformation_Name.exists())
                                .as("There is no Product Brand Name on the product page!")
                                .isTrue();
                    } else if (value.equalsIgnoreCase("Отображать логотип бренда товара")) {
                        softAssert.assertThat(productBrandInformation_Logo.exists())
                                .as("There is a Product Brand Name but shouldn't on the product page!")
                                .isFalse();
                    } else if (value.equalsIgnoreCase("Не отображать")) {
                        softAssert.assertThat(productBrandInformation_Name.exists() || productBrandInformation_Logo.exists())
                                .as("There is a Brand name or Brand logo but shouldn't on the product page!")
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
                        softAssert.assertThat(appearanceOfImageGallery_Counter.exists() || appearanceOfImageGallery_Dots.exists())
                                .as("The appearance of image gallery is not 'Default' on the product page!")
                                .isFalse();
                    }
                    break;

                case "Отображать кнопки социальных сетей":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(shareButtons.exists())
                                .as("There is no Share button on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(shareButtons.exists())
                                .as("There is a Share button but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;


                //CS-Cart настройки
                case "Показывать цены с налогом на страницах категорий и товаров":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(pricesWithTaxes.exists())
                                .as("There is no text of a product tax on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(pricesWithTaxes.exists())
                                .as("There is a text of a product tax but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Показывать количество доступных товаров":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(numberOfAvailableProducts.exists())
                                .as("There is no Number of available products on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(numberOfAvailableProducts.exists())
                                .as("There is a Number of available products but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Показывать мини-иконки в виде галереи":   //можно проверить только при настройке "Внешний вид галереи изображений - По умолчанию"
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(miniThumbnailImagesAsGallery_Enabled.exists())
                                .as("Mini-icons of a product are not as a Gallery on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(miniThumbnailImagesAsGallery_Disabled.exists())
                                .as("Mini-icons of a product are as a Gallery but shouldn't on the product page!")
                                .isTrue();
                    }
                    break;

                case "Показывать информацию о товаре во вкладках":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(displayProductDetailsInTabs_Enabled.exists())
                                .as("Product information is displayed not in tabs on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(displayProductDetailsInTabs_Disabled.exists())
                                .as("Product information is displayed in tabs but shouldn't on the product page!")
                                .isTrue();
                    }
                    break;


                //Характеристики
                case "Бренд, Показывать во вкладке «Характеристики» карточки товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showOnFeaturesTab_Brand.exists())
                                .as("There is no feature Brand in the product tab of features!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showOnFeaturesTab_Brand.exists())
                                .as("There is a feature Brand in the product tab of features but shouldn't!")
                                .isFalse();
                    }
                    break;

                case "Бренд, Показывать в заголовке карточки товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showInHeaderOnProductPage_Brand.exists())
                                .as("There is no feature Brand in the product header!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showInHeaderOnProductPage_Brand.exists())
                                .as("There is a feature Brand in the product header but shouldn't!")
                                .isFalse();
                    }
                    break;

                case "Жесткий диск, Показывать в заголовке карточки товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(showInHeaderOnProductPage_HardDrive.exists())
                                .as("There is no feature HardDrive in the product header!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(showInHeaderOnProductPage_HardDrive.exists())
                                .as("There is a feature HardDrive in the product header but shouldn't!")
                                .isFalse();
                    }
                    break;


                //Настройки из страницы редактирования товара
                case "Рекомендованная цена":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(listPrice.exists())
                                .as("There is no List price on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(listPrice.exists())
                                .as("There is a List price but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Цена за единицу":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(pricePerUnit.exists())
                                .as("There is no Price per unit on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(pricePerUnit.exists())
                                .as("There is a Price per unit but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Промо-текст":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(promoText.exists())
                                .as("There is no Promo-text on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(promoText.exists())
                                .as("There is a Promo-text but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Бонусные баллы":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(product_allowPaymentByPoints.exists())
                                .as("There is no Reward points on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(product_allowPaymentByPoints.exists())
                                .as("There is a Reward points but shouldn't on the product page!")
                                .isFalse();
                    }
                    break;

                case "Оптовые скидки":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertThat(quantityDiscounts.exists())
                                .as("There is no Quantity discounts on the product page!")
                                .isTrue();
                    } else {
                        softAssert.assertThat(quantityDiscounts.exists())
                                .as("There is a Quantity discounts but shouldn't on the product page!")
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