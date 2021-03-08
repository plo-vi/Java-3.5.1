## Задача №1 - "Менеджер Товаров"

На основании проекта из лекции необходимо реализовать менеджер товаров, который умеет:

1. Добавлять товары в репозиторий
1. Искать товары

Что нужно сделать:
1. Разработайте базовый класс `Product`, содержащий `id`, название, стоимость
1. Разработать два унаследованных от `Product` класса: `Book` (с полями название* и автор) и `Smartphone` (с полями название* и производитель)
1. Разработайте репозиторий, позволяющий сохранять `Product`'ы, получать все сохранённые `Product`'ы и удалять по `id`
1. Разработайте менеджера, который умеет добавлять `Product`'ы в репозиторий и осуществлять поиск по ним 

#### Как осуществлять поиск

У менеджера должен быть метод `searchBy(String text)`, который возвращает массив найденных товаров 

Менеджер при переборе всех продуктов, хранящихся в массиве (или в репозитории, если вы в предыдущих ДЗ сделали репозиторий)*, должен для каждого продукта вызывать собственный метод `matches`, который проверяет, соответствует ли продукт поисковому запросу.

Примечание*: если вы сделали репозиторий, то пусть менеджер забирает из репозитория все товары и сам уже по ним ищет.

Проверку соответствия проводится с помощью `instanceof` - для книги по полям название и автор, для смартфона по полям название и производитель.

Требования к проекту:
1. Создайте ветку (не делайте ДЗ в `master`!)
1. Подключите плагин Surefire так, чтобы сборка падала в случае отсутсвия тестов
1. Подключите плагин JaCoCo в режиме генерации отчётов (обрушать сборку по покрытию не нужно)
1. Реализуйте нужные классы и методы
1. Напишите автотесты на метод поиска (только на метод поиска в менеджере), добившись 100% покрытия по branch'ам* (вспомните, что мы говорили про тестирование методов, возвращающих набор значений)
1. Подключите CI на базе Github Actions и выложите всё на Github

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код в ветке (в `master` должен быть только `pom.xml`).