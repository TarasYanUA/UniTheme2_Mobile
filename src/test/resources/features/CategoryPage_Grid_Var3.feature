@CategoryPage_Grid_Var3

Feature: Страница категории, шаблон "Сетка" - Вариант 3

  Scenario: Работаем с настройками темы
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Выключаем модуль с ИД "addon_ab__category_banners", если модуль включён
    Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Списки товаров"
    And Устанавливаем настройки темы:
      | Обесцвечивать товары, которых нет в наличии       | n                                          |
      | Формат отображения цен                            | Вариант 1                                  |
      | Отображать цену вверху                            | y                                          |
      | Отображать пустые звёзды рейтинга товара          | y                                          |
      | Отображать общее значение рейтинга товара         | n                                          |
      | Отображать кнопку "Добавить в избранное"          | y                                          |
      | Отображать кнопку "Добавить в список сравнения"   | y                                          |
      | Отображать "Вы экономите"                         | Не отображать                              |
      | Сетка, Ширина иконки товара                       | 300                                        |
      | Сетка, Высота иконки товара                       | 300                                        |
      | Сетка, Количество строк в названии товара         | 1                                          |
      | Сетка, Отображать код товара                      | y                                          |
      | Сетка, Отображать статус наличия                  | y                                          |
      | Сетка, Отображать модификатор количества          | y                                          |
      | Сетка, Отображать кнопку "Купить"                 | Только Иконка корзины (упрощенный вариант) |
      | Сетка, Дополнительная информация о товаре         | Краткое описание и характеристики          |
      | Сетка, Отображать стандартную галерею изображений | Не отображать                              |
    Then Сохраняем выбранные настройки

  Scenario: Работаем с настройками цветосхемы
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Общие"
    And Устанавливаем настройки цветосхемы:
      | Скруглить углы для элементов интерфейса     | Не использовать            |
      | Скруглить углы блоков, окон, баннеров       | Не использовать            |
      | Отображать заголовки заглавными буквами     | y                          |
      | Кнопки, Стиль                               | Использовать только контур |
      | Кнопки, Отображать текст заглавными буквами | y                          |
      | Кнопки, Отображать тень                     | y                          |
      | Кнопки, Добавить объем                      | y                          |
      | Кнопки, Иконка Корзины                      | Вариант 4                  |
    Then Сохраняем выбранные настройки
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Списки товаров"
    And Устанавливаем настройки цветосхемы:
      | Тип обрамления товара в сетке                        | Без рамки |
      | Добавить фон/маску для изображений товара            | y         |
      | Использовать выравнивание элементов в товарной сетке | y         |
      | Насыщенность шрифта для названия товара              | Жирный    |
    Then Сохраняем выбранные настройки

  Scenario: Работаем с витриной и выполняем проверки
    When Переходим на витрину
    Given Разавторизоваться на витрине
    And Переключаемся на "ru" язык интерфейса витрины
    And Переходим на страницу категории "electronics" "Телефоны"
    And Выполняем проверки на странице категории:
      | Отображать пустые звёзды рейтинга товара        | y                                 |
      | Отображать общее значение рейтинга товара       | n                                 |
      | Отображать кнопку "Добавить в избранное"        | y                                 |
      | Отображать кнопку "Добавить в список сравнения" | y                                 |
      | Сетка, Отображать "Вы экономите"                | Не отображать                     |
      | Сетка, Количество строк в названии товара       | 1                                 |
      | Отображать код товара                           | y                                 |
      | Сетка, Отображать статус наличия                | y                                 |
      | Отображать модификатор количества               | y                                 |
      | Отображать кнопку "Купить"                      | Только Иконка корзины             |
      | Дополнительная информация о товаре              | Краткое описание и характеристики |
      | Отображать стандартную галерею изображений      | Не отображать                     |
      | Текст налога "[цена налога] + Вкл налог"        | y                                 |
    And Делаем скриншот "@CategoryPage_Grid_Var3 - категория Телефоны 01"
    And Скроллимся вниз по странице на 650 px
    And Делаем скриншот "@CategoryPage_Grid_Var3 - категория Телефоны 02"
    And Переключаемся на "ar" язык интерфейса витрины
    And Делаем скриншот "@CategoryPage_Grid_Var3 - категория Телефоны (RTL) 01"
    And Скроллимся вниз по странице на 650 px
    And Делаем скриншот "@CategoryPage_Grid_Var3 - категория Телефоны (RTL) 02"
    And Переключаемся на "ru" язык интерфейса витрины
    And Переходим на страницу категории "apparel" "Женская одежда"
    And Выполняем проверки на странице категории:
      | Обесцвечивать товары, которых нет в наличии     | n                                 |
      | Отображать пустые звёзды рейтинга товара        | y                                 |
      | Отображать общее значение рейтинга товара       | n                                 |
      | Отображать кнопку "Добавить в избранное"        | y                                 |
      | Отображать кнопку "Добавить в список сравнения" | y                                 |
      | Сетка, Отображать "Вы экономите"                | Не отображать                     |
      | Сетка, Количество строк в названии товара       | 1                                 |
      | Отображать код товара                           | y                                 |
      | Сетка, Отображать статус наличия                | y                                 |
      | Отображать модификатор количества               | y                                 |
      | Отображать кнопку "Купить"                      | Только Иконка корзины             |
      | Дополнительная информация о товаре              | Краткое описание и характеристики |
      | Отображать стандартную галерею изображений      | Не отображать                     |
      | Текст налога "[цена налога] + Вкл налог"        | y                                 |
    And Делаем скриншот "@CategoryPage_Grid_Var3 - категория Женская одежда"
    And Переключаемся на "ar" язык интерфейса витрины
    And Делаем скриншот "@CategoryPage_Grid_Var3 - категория Женская одежда (RTL)"