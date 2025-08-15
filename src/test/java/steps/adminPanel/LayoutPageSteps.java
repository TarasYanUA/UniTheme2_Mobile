package steps.adminPanel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LayoutPageSteps {
    public LayoutPageSteps() { super(); }

    LayoutPage layoutPage = new LayoutPage();

    @Given("Переходим во вкладку {string}, что на странице 'Макеты'")
    public void navigateTo_LayoutTab(String tabName) {
        layoutPage.navigateTo_LayoutTab(tabName);
    }

    @Given("Выключаем LazyLoad в секции с блоком {string} и Включаем отображение для мобильного устройства")
    public void disableLazyLoadFromSection(String blockName) {
        layoutPage.disableLazyLoadFromSection(blockName);
    }

    @Given("Получаем ID блока {string}")
    public void getBlockID(String blockName) {
        layoutPage.getBlockID(blockName);
    }

    @And("Переходим в настройки блока {string}")
    public void navigateToBlockSettings(String blockName) {
        layoutPage.navigateToBlockSettings(blockName);
    }

    @And("Выбираем шаблон блока {string} и нажимаем кнопку 'Настройки'")
    public void selectTemplateForBlock(String templateName) {
        layoutPage.selectTemplateForBlock(templateName);
    }

    @And("Устанавливаем настройки блока:")
    public void setBlockSettings(DataTable table) {
        layoutPage.setBlockSettings(table);
    }

    @Then("Сохраняем настройки блока")
    public void saveBlockSettings() {
        layoutPage.saveBlockSettings();
    }

    @Given("Переходим на страницу {string}, что на странице 'Макеты'")
    public void navigateTo_BlocksPage(String pageName) {
        layoutPage.navigateTo_BlocksPage(pageName);
    }

    @And("Создаём блок с шаблоном {string}")
    public void createNewBlock(String blockTemplate) {
        layoutPage.createNewBlock(blockTemplate);
    }

    @Given("Получаем ID блока {string} на странице 'Блоки'")
    public void getBlockIDFrom_BlocksPage(String blockName) {
        layoutPage.getBlockIDFrom_BlocksPage(blockName);
    }
}
