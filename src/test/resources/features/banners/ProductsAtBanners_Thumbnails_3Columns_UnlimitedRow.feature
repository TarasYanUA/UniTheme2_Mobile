@ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow

Feature: Проверка отображения баннера с товарами - шаблон "Миниатюры", 3 колонки, Без ограничений

  Scenario: Создаём баннер с товарами
    Given Переходим на страницу "Маркетинг" -- "Баннеры"
    And Создаём новый баннер с товарами: "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow", "links_thumb", "3", "0", "ead1dc"

  Scenario: Создаём блок для баннера с товарами
    Given Переходим на страницу "Веб-сайт" -- "Темы"
    Given Переходим на страницу "Макеты", что на странице 'Темы'
    Given Переходим во вкладку "Домашняя страница", что на странице 'Макеты'
    And Получаем ID секции с блоком "<mark>Возможно,</mark> вас это заинтересует"
    And Отключаем все блоки в секции, если в секции отсутствует блок "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow"
    And Добавляем в секцию новый блок типа "Баннеры" и переименовываем его на "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow"
    Given Получаем ID блока "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow"
    And Переходим в настройки блока "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow"
    And Выбираем шаблон блока "AB: Расширенный баннер" и нажимаем кнопку 'Настройки'
    And Добавляем в блок баннер "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow"
    Then Сохраняем настройки блока

  Scenario: Работаем с витриной и выполняем проверки
    When Переходим на витрину
    Given Разавторизоваться на витрине
    Given Переключаемся на "ru" язык интерфейса витрины
    And Скроллимся к блоку с баннером
    And Выполняем проверки в блоке с баннером:
      | Проверяем, что шаблон у товаров "Миниатюры"                           | y |
      | Проверяем у баннера наличие названия                                  | y |
      | Проверяем количество колонок у товаров баннера с шаблоном "Миниатюры" | 3 |
      | Проверяем у баннера с шаблоном "Миниатюры" количество товаров         | 6 |
    And Делаем скриншот "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow 01"
    And Переключаемся на "ar" язык интерфейса витрины
    And Скроллимся к блоку с баннером
    And Делаем скриншот "ProductsAtBanners_Thumbnails_3Columns_UnlimitedRow 02(RTL)"