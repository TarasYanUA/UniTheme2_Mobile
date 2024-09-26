@ProductBlock_GridMore_Var1

  Feature: Проверка отображения блока товаров "AB: Сетка (с кнопкой "Показать ещё")" на мобильном устройстве - Вариант 1

#    Scenario: Работаем с настройками блока товаров "Распродажа"
#      Given Переходим на страницу "Веб-сайт -- Темы -- Макеты", вкладка "Домашняя страница"
#      Given Выключаем LazyLoad в секции с блоком "Распродажа"
#      Given Получаем ID блока "Распродажа"
#      And Переходим в настройки блока "Распродажа"
#      And Выбираем шаблон блока "AB: Сетка (с кнопкой \"Показать ещё\")" и нажимаем кнопку 'Настройки'
#      And Устанавливаем настройки блока:
#        | Показать номер элемента    | n                                   |
#        | Количество колонок в списке| 5                                   |
#        | Тип загрузки               | По клику                            |
#        | Заполнение                 | Товары со скидкой                   |
#        | Макс. число элементов      | 17                                  |
#        | Спрятать кнопку добавления | n                                   |
#      Then Сохраняем настройки блока

 #   Scenario: Работаем с настройками характеристики Бренд
 #     Given Переходим на страницу "Товары" -- "Характеристики"
 #     And Переходим в настройки характеристики "Бренд"
 #     And Устанавливаем настройки характеристики Бренд:
 #       | Показывать в списке товаров | y |
 #     Then Сохраняем выбранные настройки

#    Scenario: Работаем с настройками темы
#      Given Переходим на страницу "Модули" -- "Скачанные модули"
#      Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Списки товаров"
#      And Устанавливаем настройки темы:
#        | Формат отображения цен                                      | Вариант 4                                 |
#        | Отображать цену вверху                                      | n                                         |
#        | Отображать пустые звёзды рейтинга товара                    | y                                         |
#        | Отображать общее значение рейтинга товара                   | n                                         |
#        | Отображать кнопку "Добавить в избранное"                    | y                                         |
#        | Отображать кнопку "Добавить в список сравнения"             | y                                         |
#        | Отображать кнопки "Быстрый просмотр, Добавить в избранное, Добавить в список сравнения" при наведении на ячейку товара | y |
#        | Отображать "Вы экономите"                                   | Сокращенный вид                           |
#        | Отображать код товара                                       | y                                         |
#        | Отображать статус наличия                                   | y                                         |
#        | Отображать модификатор количества                           | y                                         |
#        | Отображать кнопку "Купить"                                  | Иконка корзины и текст                    |
#        | Дополнительная информация о товаре                          | Краткое описание и характеристики         |
#        | Отображать дополнительную информацию при наведении          | y                                         |
#        | Отображать логотип бренда                                   | y                                         |
#        | Отображать стандартную галерею изображений                  | Навигация стрелками                       |
#        | Переключать изображение товара при движении мышки           | Не переключать                            |
#      Then Сохраняем выбранные настройки

    Scenario: Работаем с настройками цветосхемы
      Given Переходим на страницу "Модули" -- "Скачанные модули"
      Given Переходим на страницу "UniTheme2 -- Настройки цветосхемы", вкладка "Списки товаров"
      And Устанавливаем настройки цветосхемы:
        | Тип обрамления товара в сетке                         | Рамка с внешними отступами  |
        | Добавить фон/маску для изображений товара             | n                           |
        | Использовать выравнивание элементов в товарной сетке  | y                           |
        | Эффект увеличения ячейки при наведении                | y                           |
        | Насыщенность шрифта для названия товара               | Нормальный                  |
      Then Сохраняем выбранные настройки