@ProductsAtBanners_Grid_1Column

Feature: Проверка отображения баннера с товарами - шаблон "Сетка", 1 колонка

  Scenario: Создаём баннер с товарами
    Given Переходим на страницу "Маркетинг" -- "Баннеры"
    And Создаём новый баннер с товарами: "ProductsAtBanners_Grid_1Column", "grid_items", "1", "", "ccffcc"

  Scenario: Создаём блок для баннера с товарами
    Given Переходим на страницу "Веб-сайт" -- "Темы"
    Given Переходим на страницу "Макеты", что на странице 'Темы'
    Given Переходим во вкладку "Домашняя страница", что на странице 'Макеты'
    And Получаем ID секции с блоком "<mark>Возможно,</mark> вас это заинтересует"
    And Отключаем все блоки в секции кроме блока "ProductsAtBanners_Grid_1Column"
    And Добавляем в секцию "новый" блок типа "Баннеры" и переименовываем его на "ProductsAtBanners_Grid_1Column"
    Given Получаем ID блока "ProductsAtBanners_Grid_1Column"
    And Переходим в настройки блока "ProductsAtBanners_Grid_1Column"
