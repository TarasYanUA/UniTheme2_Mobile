@ProductsAtBanners_SmallElements_1Column_InOneRow

Feature: Проверка отображения баннера с товарами - шаблон "Мелкие элементы", 1 колонка, В один ряд

  Scenario: Создаём баннер с товарами
    Given Переходим на страницу "Маркетинг" -- "Баннеры"
    And Создаём новый баннер с товарами: "ProductsAtBanners_SmallElements_1Column_InOneRow", "small_items", "1", "1", "ccffcc"

  Scenario: Создаём блок для баннера с товарами
    Given Переходим на страницу "Веб-сайт" -- "Темы"
    Given Переходим на страницу "Макеты", что на странице 'Темы'
    Given Переходим во вкладку "Домашняя страница", что на странице 'Макеты'
    And Получаем ID секции с блоком "<mark>Возможно,</mark> вас это заинтересует"
    And Отключаем все блоки в секции, если в секции отсутствует блок "ProductsAtBanners_SmallElements_1Column_InOneRow"
    And Добавляем в секцию новый блок типа "Баннеры" и переименовываем его на "ProductsAtBanners_SmallElements_1Column_InOneRow"
    Given Получаем ID блока "ProductsAtBanners_SmallElements_1Column_InOneRow"
    And Переходим в настройки блока "ProductsAtBanners_SmallElements_1Column_InOneRow"
    And Выбираем шаблон блока "AB: Расширенный баннер" и нажимаем кнопку 'Настройки'
    And Добавляем в блок баннер "ProductsAtBanners_SmallElements_1Column_InOneRow"
    Then Сохраняем настройки блока

  Scenario: Работаем с витриной и выполняем проверки
    When Переходим на витрину
    Given Разавторизоваться на витрине
    Given Переключаемся на "ru" язык интерфейса витрины
    And Скроллимся к блоку "баннера"
    And Выполняем проверки в блоке с баннером:
      | Проверяем, что шаблон у товаров "Мелкие элементы"                           | y |
      | Проверяем у баннера наличие названия                                        | y |
      | Проверяем у баннера наличие скроллера                                       | y |
      | Проверяем количество колонок у товаров баннера с шаблоном "Мелкие элементы" | 1 |
      | Проверяем у баннера с шаблоном "Мелкие элементы" количество товаров         | 6 |
    And Делаем скриншот "ProductsAtBanners_SmallElements_1Column_InOneRow 01"
    And Переключаемся на "ar" язык интерфейса витрины
    And Скроллимся к блоку "баннера"
    And Делаем скриншот "ProductsAtBanners_SmallElements_1Column_InOneRow 02(RTL)"