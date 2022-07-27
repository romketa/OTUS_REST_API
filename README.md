Для запуска необходима Java 18

Для запуска тестов нужно:
    1. Склонировать к себе репозиторий
    2. Открыть консоль в папке с проектом
    3. В консоль ввести команду - mvn clean test
            *Первый тест проверяет метод создания заказа, заказ создаётся, проверяется что создался и удаляется, параллельно проводятся проверки кодов ответа и тел ответов
			*Второй тест проверяет метод удаления заказа, заказ создаётся, проверяется что создался и удаляется, затем пытаемся снова удалить и получить соотвествующую ошибку о том что заказа нет (404) параллельно проводятся проверки кодов ответа и тел ответов
			*Третий тест проверяет метод создания юзера, юзер создаётся, проверяется что создался и удаляется, параллельно проводятся проверки кодов ответа и тел ответов
			*Четвертый тест проверяет метод обновления юзера, юзер создаётся, проверяется что создался, обновляется удаляется, параллельно проводятся проверки кодов ответа и тел ответов

