@BottomStickyPanel_Var1

  Feature: Проверка отображения Нижней липкой панели - Вариант 1

    Scenario: Работаем с настройками Нижней липкой панели
      Given Переходим на страницу "Модули" -- "Скачанные модули"
      Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Общие"
      And Устанавливаем настройки Нижней липкой панели:
      |Отображать блок с контактами для элемента "Контакты". Укажите ID блока |- |
      |Включить нижнюю липкую панель        |y    |
      |Отображать названия элементов панели |n    |
      |Ссылка на главную страницу           |y    |
      |Ссылка на главную страницу, Позиция  |40   |
      |Главное Меню                         |y    |
      |Главное Меню, Позиция                |60   |
      |Поиск товаров                        |y    |
      |Поиск товаров, Позиция               |30   |
      |Мини корзина                         |y    |
      |Мини корзина, Позиция                |10   |
      |Избранные товары                     |n    |
      |Сравнение товаров                    |n    |
      |Аккаунт                              |y    |
      |Аккаунт, Позиция                     |20   |
      |Контакты                             |y    |
      |Контакты, Позиция                    |50   |
      Then Сохраняем выбранные настройки