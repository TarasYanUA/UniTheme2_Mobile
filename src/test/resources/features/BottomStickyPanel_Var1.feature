@BottomStickyPanel_Var1

Feature: Проверка отображения Нижней липкой панели - Вариант 1

  Scenario: Работаем с настройками Нижней липкой панели
    Given Переходим на страницу "Модули" -- "Скачанные модули"
    Given Переходим на страницу "UniTheme2 -- Настройки темы", вкладка "Общие"
    And Устанавливаем настройки Нижней липкой панели:
      | Отображать блок с контактами для элемента "Контакты". Укажите ID блока | -  |
      | Включить нижнюю липкую панель                                          | y  |
      | Отображать названия элементов панели                                   | n  |
      | Ссылка на главную страницу                                             | y  |
      | Ссылка на главную страницу, Позиция                                    | 40 |
      | Главное Меню                                                           | y  |
      | Главное Меню, Позиция                                                  | 60 |
      | Поиск товаров                                                          | y  |
      | Поиск товаров, Позиция                                                 | 30 |
      | Мини корзина                                                           | y  |
      | Мини корзина, Позиция                                                  | 10 |
      | Избранные товары                                                       | n  |
      | Сравнение товаров                                                      | n  |
      | Аккаунт                                                                | y  |
      | Аккаунт, Позиция                                                       | 20 |
      | Контакты                                                               | y  |
      | Контакты, Позиция                                                      | 50 |
    Then Сохраняем выбранные настройки

  Scenario: Работаем с витриной и выполняем проверки
    When Переходим на витрину
    Given Разавторизоваться на витрине
    And Скроллимся к блоку товаров
    And Выполняем проверки в Нижней липкой панели:
      | Нижняя липкая панель       | y |
      | Ссылка на главную страницу | y |
      | Главное Меню               | y |
      | Поиск товаров              | y |
      | Мини корзина               | y |
      | Избранные товары           | n |
      | Сравнение товаров          | n |
      | Аккаунт                    | y |
      | Контакты                   | y |
    Then Делаем скриншот "BottomStickyPanel_Var1 - Нижняя липкая панель"

  Scenario Outline: Открываем окна в Нижней липкой панели и делаем скриншоты
    When Переходим на витрину
    Given Разавторизоваться на витрине
    And Скроллимся к блоку товаров
    And Нажимаем кнопку "<Button>" в Нижней липкой панели
    Then Делаем скриншот "<ScreenRu>"

    Examples:
      | Button        | ScreenRu                               |
      | Главное Меню  | BottomStickyPanel_Var1 - Главное Меню  |
      | Поиск товаров | BottomStickyPanel_Var1 - Поиск товаров |
      | Мини корзина  | BottomStickyPanel_Var1 - Мини корзина  |
      | Аккаунт       | BottomStickyPanel_Var1 - Аккаунт       |
      | Контакты      | BottomStickyPanel_Var1 - Контакты      |

  Scenario Outline: Открываем окна в Нижней липкой панели и делаем скриншоты на языке RTL
    When Переходим на витрину
    Given Разавторизоваться на витрине
    And Переключаемся на "ar" язык интерфейса витрины
    And Скроллимся к блоку товаров
    And Нажимаем кнопку "<Button>" в Нижней липкой панели
    Then Делаем скриншот "<ScreenRTL>"

    Examples:
      | Button        | ScreenRTL                                    |
      | Главное Меню  | BottomStickyPanel_Var1 - Главное Меню (RTL)  |
      | Поиск товаров | BottomStickyPanel_Var1 - Поиск товаров (RTL) |
      | Мини корзина  | BottomStickyPanel_Var1 - Мини корзина (RTL)  |
      | Аккаунт       | BottomStickyPanel_Var1 - Аккаунт (RTL)       |
      | Контакты      | BottomStickyPanel_Var1 - Контакты (RTL)      |
