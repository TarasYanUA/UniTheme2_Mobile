@ProductBlock_SmallItems_Var3

  Feature: Проверка отображения блока товаров "Скроллер" - Вариант 3

    Scenario: Работаем с настройками блока товаров "Распродажа"
      Given Переходим на страницу "Веб-сайт" -- "Темы"
      Given Переходим на страницу "Макеты", что на странице 'Темы'
      Given Переходим во вкладку "Домашняя страница", что на странице 'Макеты'
      Given Выключаем LazyLoad в секции с блоком "Распродажа"
      Given Получаем ID блока "Распродажа"
      And Переходим в настройки блока "Распродажа"
      And Выбираем шаблон блока "Мелкие элементы" и нажимаем кнопку 'Настройки'
      And Устанавливаем настройки блока:
        | Показать номер элемента           | y                 |
        | Заполнение                        | Товары со скидкой |
        | Макс. число элементов             | 13                |
        | Спрятать кнопку добавления        | n                 |
      Then Сохраняем настройки блока

    Scenario: Работаем с настройками темы
      Given Переходим на страницу "Модули" -- "Скачанные модули"
      Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Списки товаров"
      And Устанавливаем настройки темы:
        | Формат отображения цен                                      | Вариант 1               |
        | Отображать цену вверху                                      | y                       |
        | Отображать пустые звёзды рейтинга товара                    | y                       |
        | Отображать общее значение рейтинга товара                   | y                       |
        | Отображать "Вы экономите"                                   | Сокращенный вид         |
        | Мелкие элементы, Количество строк в названии товара         | 4                       |
        | Мелкие элементы, Отображать код товара                      | n                       |
        | Мелкие элементы, Отображать статус наличия                  | n                       |
        | Мелкие элементы, Отображать модификатор количества          | n                       |
        | Мелкие элементы, Отображать кнопку "Купить"                 | Только текст            |
      Then Сохраняем выбранные настройки

    Scenario: Работаем с настройками цветосхемы
      Given Переходим на страницу "Модули" -- "Скачанные модули"
      Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Списки товаров"
      And Устанавливаем настройки цветосхемы:
        | Тип обрамления товара в сетке                         | Рамка без внешних отступов  |
        | Добавить фон/маску для изображений товара             | y                           |
        | Насыщенность шрифта для названия товара               | Жирный                      |
      Then Сохраняем выбранные настройки

    Scenario: Настраиваем налог для всех товаров
      Given Переходим на страницу 'Настройки', раздел "Общие настройки"
      Given Переходим во вкладку настроек CS-Cart "Внешний вид"
      And Устанавливаем настройки CS-Cart:
        | Показывать цены с налогом на страницах категорий и товаров  | y |
      Then Сохраняем выбранные настройки
      Given Переходим во вкладку настроек CS-Cart "Оформление заказа"
      And Устанавливаем настройки CS-Cart:
        | Расчет налога по    | Цена за единицу |
      Then Сохраняем выбранные настройки
      Given Переходим на страницу 'Настройки', раздел "Налоги"
      And Устанавливаем настройки CS-Cart:
        | Цена включает налог    | n |
      Then Сохраняем настройки налога

    Scenario: Работаем с витриной и выполняем проверки
      When Переходим на витрину
      Given Разавторизоваться на витрине
      And Переключаемся на "ru" язык интерфейса витрины
      And Скроллимся к блоку товаров
      And Раскрываем вкладку "Распродажа" у блока
      And Скроллимся вниз по странице на 350 px
      Then Делаем скриншот "ProductBlock_SmallItems_Var3"
      And Выполняем проверки в блоке:
        | Показать номер элемента                                     | y                                         |
        | Отображать пустые звёзды рейтинга товара                    | y                                         |
        | Отображать общее значение рейтинга товара                   | y                                         |
        | Отображать "Вы экономите"                                   | Сокращенный вид                           |
        | Количество строк в названии товара                          | 4                                         |
        | Отображать код товара                                       | n                                         |
        | Отображать статус наличия                                   | n                                         |
        | Отображать модификатор количества                           | n                                         |
        | Отображать кнопку "Купить"                                  | Только текст                              |
        | Текст налога "[цена налога] + Вкл налог"                    | y                                         |
      And Переключаемся на "ar" язык интерфейса витрины
      And Скроллимся к блоку товаров
      And Раскрываем вкладку "On Sale" у блока
      And Скроллимся вниз по странице на 350 px
      Then Делаем скриншот "ProductBlock_SmallItems_Var3 (RTL)"
