package steps.adminPanel.themeSettings;

import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class BottomStickyPanelSettings {
    public BottomStickyPanelSettings() {
        super();
    }

    SelenideElement setting_BlockID_ContactUs = $(By.id("settings.abt__ut2.general.sticky_panel.sticky_panel_contacts_block_id"));
    SelenideElement setting_EnableBottomStickyPanel = $(By.id("settings.abt__ut2.general.sticky_panel.enable_sticky_panel.mobile"));
    SelenideElement setting_DisplayTitlesForPanelItems = $(By.id("settings.abt__ut2.general.sticky_panel.enable_sticky_panel_labels.mobile"));
    SelenideElement setting_LinkToHomePage = $(By.id("settings.abt__ut2.general.sticky_panel.link_home.mobile"));
    SelenideElement position_LinkToHomePage = $(By.id("settings.abt__ut2.general.sticky_panel.link_home.position"));
    SelenideElement setting_CatalogMenu = $(By.id("settings.abt__ut2.general.sticky_panel.catalog.mobile"));
    SelenideElement position_CatalogMenu = $(By.id("settings.abt__ut2.general.sticky_panel.catalog.position"));
    SelenideElement setting_SearchProducts = $(By.id("settings.abt__ut2.general.sticky_panel.search.mobile"));
    SelenideElement position_SearchProducts = $(By.id("settings.abt__ut2.general.sticky_panel.search.position"));
    SelenideElement setting_MiniCart = $(By.id("settings.abt__ut2.general.sticky_panel.cart.mobile"));
    SelenideElement position_MiniCart = $(By.id("settings.abt__ut2.general.sticky_panel.cart.position"));
    SelenideElement setting_Wishlist = $(By.id("settings.abt__ut2.general.sticky_panel.wishlist.mobile"));
    SelenideElement position_Wishlist = $(By.id("settings.abt__ut2.general.sticky_panel.wishlist.position"));
    SelenideElement setting_ComparisonList = $(By.id("settings.abt__ut2.general.sticky_panel.comparison.mobile"));
    SelenideElement position_ComparisonList = $(By.id("settings.abt__ut2.general.sticky_panel.comparison.position"));
    SelenideElement setting_Account = $(By.id("settings.abt__ut2.general.sticky_panel.account.mobile"));
    SelenideElement position_Account = $(By.id("settings.abt__ut2.general.sticky_panel.account.position"));
    SelenideElement setting_Contacts = $(By.id("settings.abt__ut2.general.sticky_panel.phones.mobile"));
    SelenideElement position_Contacts = $(By.id("settings.abt__ut2.general.sticky_panel.phones.position"));


    private void setCheckboxState(SelenideElement checkbox, String value) {
        boolean isValueNo = value.equalsIgnoreCase("n");
        boolean isCheckboxSelected = checkbox.isSelected();

        if ((isValueNo && isCheckboxSelected) || (!isValueNo && !isCheckboxSelected))
            checkbox.click();
    }

    @And("Устанавливаем настройки Нижней липкой панели:")
    public void setBottomStickyPanelSettings(DataTable table) {
        List<List<String>> rows = table.asLists((String.class));

        for (List<String> row : rows) {
            String setting = row.getFirst(); // Ключ (название настройки)
            String value = row.get(1);       // Значение настройки

            switch (setting) {
                case "Отображать блок с контактами для элемента \"Контакты\". Укажите ID блока" -> {
                    setting_BlockID_ContactUs.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
                    setting_BlockID_ContactUs.setValue(value);
                }
                case "Включить нижнюю липкую панель" -> setCheckboxState(setting_EnableBottomStickyPanel, value);
                case "Отображать названия элементов панели" -> setCheckboxState(setting_DisplayTitlesForPanelItems, value);
                case "Ссылка на главную страницу" -> setCheckboxState(setting_LinkToHomePage, value);
                case "Ссылка на главную страницу, Позиция" -> position_LinkToHomePage.setValue(value);
                case "Главное Меню" -> setCheckboxState(setting_CatalogMenu, value);
                case "Главное Меню, Позиция" -> position_CatalogMenu.setValue(value);
                case "Поиск товаров" -> setCheckboxState(setting_SearchProducts, value);
                case "Поиск товаров, Позиция" -> position_SearchProducts.setValue(value);
                case "Мини корзина" -> setCheckboxState(setting_MiniCart, value);
                case "Мини корзина, Позиция" -> position_MiniCart.setValue(value);
                case "Избранные товары" -> setCheckboxState(setting_Wishlist, value);
                case "Избранные товары, Позиция" -> position_Wishlist.setValue(value);
                case "Сравнение товаров" -> setCheckboxState(setting_ComparisonList, value);
                case "Сравнение товаров, Позиция" -> position_ComparisonList.setValue(value);
                case "Аккаунт" -> setCheckboxState(setting_Account, value);
                case "Аккаунт, Позиция" -> position_Account.setValue(value);
                case "Контакты" -> setCheckboxState(setting_Contacts, value);
                case "Контакты, Позиция" -> position_Contacts.setValue(value);
                default -> throw new IllegalArgumentException("Неизвестная настройка: " + setting);
            }

        }
    }

    //Кнопки/Проверки на витрине
    String bottomStickyPanel = ".ut2-sticky-panel__wrap ";
    SelenideElement element_BottomStickyPanel = $(bottomStickyPanel);
    SelenideElement linkToHomePage = $(".ut2-icon-home_page");
    SelenideElement catalogMenu = $(bottomStickyPanel + ".ut2-icon-outline-menu");
    SelenideElement searchProducts = $(bottomStickyPanel + ".ut2-icon-search");
    SelenideElement miniCart = $(bottomStickyPanel + ".ut2-icon-use_icon_cart");
    SelenideElement wishlist = $(".ut2-icon-baseline-favorite-border");
    SelenideElement comparisonList = $(".ut2-icon-addchart");
    SelenideElement account = $(bottomStickyPanel + ".ut2-icon-outline-account-circle");
    SelenideElement contacts = $(".ut2-icon-local_phone");

    @And("Выполняем проверки в Нижней липкой панели:")
    public void assertsOfBottomStickyPanel(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        SoftAssertions softAssert = CollectAssertMessages.getSoftAssertions();

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Нижняя липкая панель" -> softAssert.assertThat(element_BottomStickyPanel.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Bottom Sticky Panel!"
                                : "There is a Bottom Sticky Panel but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Ссылка на главную страницу" -> softAssert.assertThat(linkToHomePage.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Link To Home Page!"
                                : "There is a Link To Home Page but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Главное Меню" -> softAssert.assertThat(catalogMenu.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Catalog Menu!"
                                : "There is a Catalog Menu but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Поиск товаров" -> softAssert.assertThat(searchProducts.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Search Products button!"
                                : "There is a Search Products button but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Мини корзина" -> softAssert.assertThat(miniCart.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Mini Cart!"
                                : "There is a Mini Cart but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Избранные товары" -> softAssert.assertThat(wishlist.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Wish List!"
                                : "There is a Wish List but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Сравнение товаров" -> softAssert.assertThat(comparisonList.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Comparison List!"
                                : "There is a Comparison List but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Аккаунт" -> softAssert.assertThat(account.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Account!"
                                : "There is an Account but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                case "Контакты" -> softAssert.assertThat(contacts.exists())
                        .as(value.equalsIgnoreCase("y")
                                ? "There is no Contacts button!"
                                : "There is a Contacts button but shouldn't!")
                        .isEqualTo(value.equalsIgnoreCase("y"));

                default -> System.out.println("Неизвестная проверка: " + setting);
            }
        }
    }

    private SelenideElement getButtonByName(String buttonName) {
        return switch (buttonName) {
            case "Главное Меню" -> catalogMenu;
            case "Поиск товаров" -> searchProducts;
            case "Мини корзина" -> miniCart;
            case "Аккаунт" -> account;
            case "Контакты" -> contacts;
            default -> throw new IllegalArgumentException("Неизвестная кнопка: " + buttonName);
        };
    }
    @And("Нажимаем кнопку {string} в Нижней липкой панели")
    public void clickButton(String buttonName) {
        SelenideElement button = getButtonByName(buttonName);
        button.click();
    }
}