@CategoryPage_ListWithoutOptions_Var1

Feature: Страница категории, шаблон "Список без опций" - Вариант 1

  Scenario: Работаем с настройками темы
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Выключаем модуль с ИД "addon_ab__category_banners", если модуль включён
    Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Списки товаров"
    And Устанавливаем настройки темы:
      | Обесцвечивать товары, которых нет в наличии                  | y                     |
      | Формат отображения цен                                       | Вариант 4             |
      | Отображать цену вверху                                       | n                     |
      | Отображать пустые звёзды рейтинга товара                     | y                     |
      | Отображать общее значение рейтинга товара                    | n                     |
      | Отображать кнопку "Добавить в избранное"                     | y                     |
      | Отображать кнопку "Добавить в список сравнения"              | y                     |
      | Отображать "Вы экономите"                                    | Сокращенный вид       |
      | Список без опций, Ширина иконки товара                       | 200                   |
      | Список без опций, Высота иконки товара                       | 200                   |
      | Список без опций, Отображать код товара                      | y                     |
      | Список без опций, Отображать статус наличия                  | y                     |
      | Список без опций, Отображать модификатор количества          | y                     |
      | Список без опций, Отображать кнопку "Купить"                 | Только Иконка корзины |
      | Список без опций, Содержимое под описанием                   | Список характеристик  |
      | Список без опций, Отображать опции товара                    | y                     |
      | Список без опций, Отображать логотип бренда                  | y                     |
      | Список без опций, Отображать стандартную галерею изображений | Навигация стрелками   |
    Then Сохраняем выбранные настройки

  Scenario: Работаем с настройками цветосхемы
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Общие"
    And Устанавливаем настройки цветосхемы:
      | Скруглить углы для элементов интерфейса     | Полностью скруглить          |
      | Скруглить углы блоков, окон, баннеров       | y                            |
      | Отображать заголовки заглавными буквами     | n                            |
      | Кнопки, Стиль                               | Использовать фоновую заливку |
      | Кнопки, Отображать текст заглавными буквами | n                            |
      | Кнопки, Отображать тень                     | n                            |
      | Кнопки, Добавить объем                      | n                            |
      | Кнопки, Иконка Корзины                      | Вариант 1                    |
    Then Сохраняем выбранные настройки
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Списки товаров"
    And Устанавливаем настройки цветосхемы:
      | Тип обрамления товара в сетке             | Рамка с внешними отступами |
      | Добавить фон/маску для изображений товара | n                          |
      | Насыщенность шрифта для названия товара   | Нормальный                 |
    Then Сохраняем выбранные настройки

  Scenario: Настраиваем налог для всех товаров
    Given Переходим на страницу 'Настройки', раздел "Общие настройки"
    Given Переходим во вкладку настроек CS-Cart "Внешний вид"
    And Устанавливаем настройки CS-Cart:
      | Показывать цены с налогом на страницах категорий и товаров | y |
    Then Сохраняем выбранные настройки
    Given Переходим во вкладку настроек CS-Cart "Оформление заказа"
    And Устанавливаем настройки CS-Cart:
      | Расчет налога по | Цена за единицу |
    Then Сохраняем выбранные настройки
    Given Переходим на страницу 'Настройки', раздел "Налоги"
    And Устанавливаем настройки CS-Cart:
      | Цена включает налог | n |
    Then Сохраняем настройки налога

  Scenario: Настраиваем характеристику "Бренд"
    Given Переходим на страницу "Товары" -- "Характеристики"
    And Переходим в настройки характеристики "Бренд"
    And Устанавливаем настройки характеристики:
      | Показывать в списке товаров | y |
    Then Сохраняем выбранные настройки

  Scenario: Работаем с витриной и выполняем проверки
    When Переходим на витрину
    Given Разавторизоваться на витрине
    And Переключаемся на "ru" язык интерфейса витрины
    And Переходим на страницу категории "electronics" "Телефоны"
    And Переходим на шаблон "Список без опций" страницы категории
    And Выполняем проверки на странице категории:
      | Отображать пустые звёзды рейтинга товара        | y                     |
      | Отображать общее значение рейтинга товара       | n                     |
      | Отображать кнопку "Добавить в избранное"        | y                     |
      | Отображать кнопку "Добавить в список сравнения" | y                     |
      | Список без опций, Отображать "Вы экономите"     | Сокращенный вид       |
      | Отображать код товара                           | y                     |
      | Список без опций, Отображать статус наличия     | y                     |
      | Отображать модификатор количества               | y                     |
      | Отображать кнопку "Купить"                      | Только Иконка корзины |
      | Список без опций, Содержимое под описанием      | Список характеристик  |
      | Список без опций, Отображать логотип бренда     | y                     |
      | Отображать стандартную галерею изображений      | Навигация стрелками   |
      | Текст налога "[цена налога] + Вкл налог"        | y                     |
    And Делаем скриншот "@CategoryPage_ListWithoutOptions_Var1 - категория Телефоны 01"
    And Скроллимся вниз по странице на 400 px
    And Делаем скриншот "@CategoryPage_ListWithoutOptions_Var1 - категория Телефоны 02"
    And Переключаемся на "ar" язык интерфейса витрины
    And Делаем скриншот "@CategoryPage_ListWithoutOptions_Var1 - категория Телефоны (RTL) 01"
    And Скроллимся вниз по странице на 400 px
    And Делаем скриншот "@CategoryPage_ListWithoutOptions_Var1 - категория Телефоны (RTL) 02"
    And Переключаемся на "ru" язык интерфейса витрины
    And Переходим на страницу категории "apparel" "Мужская одежда"
    And Переходим на шаблон "Список без опций" страницы категории
    And Выполняем проверки на странице категории:
      | Отображать общее значение рейтинга товара       | n                     |
      | Отображать кнопку "Добавить в избранное"        | y                     |
      | Отображать кнопку "Добавить в список сравнения" | y                     |
      | Список без опций, Отображать "Вы экономите"     | Сокращенный вид       |
      | Отображать код товара                           | y                     |
      | Список без опций, Отображать статус наличия     | y                     |
      | Отображать модификатор количества               | y                     |
      | Отображать кнопку "Купить"                      | Только Иконка корзины |
      | Список без опций, Содержимое под описанием      | Список характеристик  |
      | Список без опций, Отображать опции товара       | y                     |
      | Список без опций, Отображать логотип бренда     | y                     |
      | Отображать стандартную галерею изображений      | Навигация стрелками   |
      | Текст налога "[цена налога] + Вкл налог"        | y                     |
    And Делаем скриншот "@CategoryPage_ListWithoutOptions_Var1 - категория Мужская одежда"
    And Переключаемся на "ar" язык интерфейса витрины
    And Делаем скриншот "@CategoryPage_ListWithoutOptions_Var1 - категория Мужская одежда (RTL)"