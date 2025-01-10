@CategoryPage_Grid_Var2

Feature: Страница категории, шаблон "Сетка" - Вариант 2

  Scenario: Работаем с настройками темы
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Выключаем модуль с ИД "addon_ab__category_banners", если модуль включён
    Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Списки товаров"
    And Устанавливаем настройки темы:
      | Обесцвечивать товары, которых нет в наличии     | y                               |
      | Формат отображения цен                          | Вариант 3                       |
      | Отображать цену вверху                          | n                               |
      | Отображать пустые звёзды рейтинга товара        | n                               |
      | Отображать общее значение рейтинга товара       | y                               |
      | Отображать кнопку "Добавить в избранное"        | y                               |
      | Отображать кнопку "Добавить в список сравнения" | y                               |
      | Отображать "Вы экономите"                       | Сокращенный вид                 |
      | Ширина иконки товара                            | 400                             |
      | Высота иконки товара                            | 380                             |
      | Количество строк в названии товара              | 2                               |
      | Отображать код товара                           | n                               |
      | Отображать статус наличия                       | n                               |
      | Отображать модификатор количества               | n                               |
      | Отображать кнопку "Купить"                      | Иконка корзины и текст          |
      | Дополнительная информация о товаре              | Список характеристик и вариаций |
      | Отображать стандартную галерею изображений      | Навигация точками               |
    Then Сохраняем выбранные настройки

  Scenario: Работаем с настройками цветосхемы
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Общие"
    And Устанавливаем настройки цветосхемы:
      | Скруглить углы для элементов интерфейса     | Придать небольшую округлость |
      | Скруглить углы блоков, окон, баннеров       | y                            |
      | Отображать заголовки заглавными буквами     | n                            |
      | Кнопки, Стиль                               | Использовать только контур   |
      | Кнопки, Отображать текст заглавными буквами | n                            |
      | Кнопки, Отображать тень                     | y                            |
      | Кнопки, Добавить объем                      | y                            |
      | Кнопки, Иконка Корзины                      | Вариант 7                    |
    Then Сохраняем выбранные настройки
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Списки товаров"
    And Устанавливаем настройки цветосхемы:
      | Тип обрамления товара в сетке                        | Рамка без внешних отступов |
      | Добавить фон/маску для изображений товара            | y                          |
      | Использовать выравнивание элементов в товарной сетке | y                          |
      | Насыщенность шрифта для названия товара              | Жирный                     |
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

  Scenario: Работаем с витриной и выполняем проверки
    When Переходим на витрину
    Given Разавторизоваться на витрине
    And Переключаемся на "ru" язык интерфейса витрины
    And Переходим на страницу категории "electronics" "Телефоны"
    And Выполняем проверки на странице категории:
      | Отображать пустые звёзды рейтинга товара        | n                      |
      | Отображать общее значение рейтинга товара       | y                      |
      | Отображать кнопку "Добавить в избранное"        | y                      |
      | Отображать кнопку "Добавить в список сравнения" | y                      |
      | Отображать "Вы экономите"                       | Сокращенный вид        |
      | Сетка, Количество строк в названии товара       | 2                      |
      | Отображать код товара                           | n                      |
      | Отображать статус наличия                       | n                      |
      | Отображать модификатор количества               | n                      |
      | Отображать кнопку "Купить"                      | Иконка корзины и текст |
      | Отображать стандартную галерею изображений      | Навигация точками      |
      | Текст налога "[цена налога] + Вкл налог"        | y                      |
    And Делаем скриншот "@CategoryPage_Grid_Var2 - категория Телефоны 01"
    And Скроллимся вниз по странице на 650 px
    And Делаем скриншот "@CategoryPage_Grid_Var2 - категория Телефоны 02"
    And Переключаемся на "ar" язык интерфейса витрины
    And Делаем скриншот "@CategoryPage_Grid_Var2 - категория Телефоны (RTL) 01"
    And Скроллимся вниз по странице на 650 px
    And Делаем скриншот "@CategoryPage_Grid_Var2 - категория Телефоны (RTL) 02"
    And Переключаемся на "ru" язык интерфейса витрины
    And Переходим на страницу категории "apparel" "Женская одежда"
    And Выполняем проверки на странице категории:
      | Обесцвечивать товары, которых нет в наличии     | y                      |
      | Отображать пустые звёзды рейтинга товара        | n                      |
      | Отображать общее значение рейтинга товара       | y                      |
      | Отображать кнопку "Добавить в избранное"        | y                      |
      | Отображать кнопку "Добавить в список сравнения" | y                      |
      | Отображать "Вы экономите"                       | Сокращенный вид        |
      | Сетка, Количество строк в названии товара       | 2                      |
      | Отображать код товара                           | n                      |
      | Отображать статус наличия                       | n                      |
      | Отображать модификатор количества               | n                      |
      | Отображать кнопку "Купить"                      | Иконка корзины и текст |
      | Отображать стандартную галерею изображений      | Навигация точками      |
      | Текст налога "[цена налога] + Вкл налог"        | y                      |
    And Делаем скриншот "@CategoryPage_Grid_Var2 - категория Женская одежда"
    And Переключаемся на "ar" язык интерфейса витрины
    And Делаем скриншот "@CategoryPage_Grid_Var2 - категория Женская одежда (RTL)"