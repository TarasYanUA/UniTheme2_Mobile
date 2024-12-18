package steps.adminPanel.themeSettings;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
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
                case "Отображать блок с контактами для элемента \"Контакты\". Укажите ID блока":
                    setting_BlockID_ContactUs.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
                    setting_BlockID_ContactUs.setValue(value);
                    break;

                case "Включить нижнюю липкую панель":
                    setCheckboxState(setting_EnableBottomStickyPanel, value);
                    break;

                case "Отображать названия элементов панели":
                    setCheckboxState(setting_DisplayTitlesForPanelItems, value);
                    break;

                case "Ссылка на главную страницу":
                    setCheckboxState(setting_LinkToHomePage, value);
                    break;

                case "Ссылка на главную страницу, Позиция":
                    position_LinkToHomePage.setValue(value);
                    break;

                case "Главное Меню":
                    setCheckboxState(setting_CatalogMenu, value);
                    break;

                case "Главное Меню, Позиция":
                    position_CatalogMenu.setValue(value);
                    break;

                case "Поиск товаров":
                    setCheckboxState(setting_SearchProducts, value);
                    break;

                case "Поиск товаров, Позиция":
                    position_SearchProducts.setValue(value);
                    break;

                case "Мини корзина":
                    setCheckboxState(setting_MiniCart, value);
                    break;

                case "Мини корзина, Позиция":
                    position_MiniCart.setValue(value);
                    break;

                case "Избранные товары":
                    setCheckboxState(setting_Wishlist, value);
                    break;

                case "Избранные товары, Позиция":
                    position_Wishlist.setValue(value);
                    break;

                case "Сравнение товаров":
                    setCheckboxState(setting_ComparisonList, value);
                    break;

                case "Сравнение товаров, Позиция":
                    position_ComparisonList.setValue(value);
                    break;

                case "Аккаунт":
                    setCheckboxState(setting_Account, value);
                    break;

                case "Аккаунт, Позиция":
                    position_Account.setValue(value);
                    break;

                case "Контакты":
                    setCheckboxState(setting_Contacts, value);
                    break;

                case "Контакты, Позиция":
                    position_Contacts.setValue(value);
                    break;

                default:
                    throw new IllegalArgumentException("Неизвестная настройка: " + setting);
            }
        }
    }
}