@ProductBlock_SmallItems_Var1

  Feature: Проверка отображения блока товаров "Скроллер" - Вариант 1

    Scenario: Работаем с настройками блока товаров "Распродажа"
      Given Переходим на страницу "Веб-сайт" -- "Темы"
      Given Переходим на страницу "Макеты", что на странице 'Темы'
      Given Переходим во вкладку "Домашняя страница", что на странице 'Макеты'
      Given Выключаем LazyLoad в секции с блоком "Распродажа"
      Given Получаем ID блока "Распродажа"
      And Переходим в настройки блока "Распродажа"
      And Выбираем шаблон блока "Мелкие элементы" и нажимаем кнопку 'Настройки'
      And Устанавливаем настройки блока:
        | Показать номер элемента           | n                 |
        | Заполнение                        | Товары со скидкой |
        | Макс. число элементов             | 17                |
        | Спрятать кнопку добавления        | n                 |
      Then Сохраняем настройки блока

    Scenario: Работаем с настройками темы
      Given Переходим на страницу "Модули" -- "Скачанные модули"
      Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Списки товаров"
      And Устанавливаем настройки темы:
        | Формат отображения цен                                      | Вариант 4               |
        | Отображать цену вверху                                      | n                       |
        | Отображать пустые звёзды рейтинга товара                    | y                       |
        | Отображать общее значение рейтинга товара                   | n                       |
        | Отображать "Вы экономите"                                   | Сокращенный вид         |
        | Мелкие элементы, Количество строк в названии товара         | 2                       |
        | Мелкие элементы, Отображать код товара                      | y                       |
        | Мелкие элементы, Отображать статус наличия                  | y                       |
        | Мелкие элементы, Отображать модификатор количества          | y                       |
        | Мелкие элементы, Отображать кнопку "Купить"                 | Только Иконка корзины (упрощенный вариант)  |
      Then Сохраняем выбранные настройки

    Scenario: Работаем с настройками цветосхемы
      Given Переходим на страницу "Модули" -- "Скачанные модули"
      Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Списки товаров"
      And Устанавливаем настройки цветосхемы:
        | Тип обрамления товара в сетке                         | Рамка с внешними отступами  |
        | Добавить фон/маску для изображений товара             | n                           |
        | Насыщенность шрифта для названия товара               | Нормальный                  |
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

    Scenario: Настраиваем товар
        Given Переходим на страницу "Товары" -- "Товары"
        Given Переходим на страницу товара "Wildwood city classic"
        And Устанавливаем настройки товара:
          | Название товара | Wildwood city classic - Мы завезли настоящую американскую классику! Круизеры Drifter. Lorem Ipsum используют потому, что тот обеспечивает более или менее стандартное заполнение шаблона |
        Then Сохраняем настройки товара

    Scenario: Работаем с витриной и выполняем проверки
      When Переходим на витрину
      Given Разавторизоваться на витрине
      And Переключаемся на "ru" язык интерфейса витрины
      And Скроллимся к блоку товаров
      And Раскрываем вкладку "Распродажа" у блока
      And Скроллимся вниз по странице на 350 px
      Then Делаем скриншот "ProductBlock_SmallItems_Var1"
      And Выполняем проверки в блоке:
        | Отображать пустые звёзды рейтинга товара                    | y                                         |
        | Отображать общее значение рейтинга товара                   | n                                         |
        | Отображать "Вы экономите"                                   | Сокращенный вид                           |
        | Количество строк в названии товара                          | 2                                         |
        | Отображать код товара                                       | y                                         |
        | Отображать статус наличия                                   | y                                         |
        | Отображать модификатор количества                           | y                                         |
        | Отображать кнопку "Купить"                                  | Только Иконка корзины                     |
        | Текст налога "[цена налога] + Вкл налог"                    | y                                         |
      And Переключаемся на "ar" язык интерфейса витрины
      And Скроллимся к блоку товаров
      And Раскрываем вкладку "On Sale" у блока
      And Скроллимся вниз по странице на 350 px
      Then Делаем скриншот "ProductBlock_SmallItems_Var1 (RTL)"
