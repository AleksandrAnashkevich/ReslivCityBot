# ReslivCityBot

Вступительное задание для компании Resliv

Стек: Java8, Spring Boot, Spring MVC, SpringData, Hibernate, PostreSQL, Maven.

Для инициализации базы данных используйте sql скрипты в resources.

Настройка бота

Вы можете воспользоваться уже готовым ботом с именем CityBot

Данные,необходимые для подключения уже созданного бота (указываются в конфигурационном файле telegram.properties):

resliv.bot.name=CityMessageReslivbot

resliv.bot.token=1132435302:AAGILmsnnbZSTGMLcF7jqZbHuZP1fmXZ9zo


О работе приложения(REST):

Получить запись по id: [GET] /cities/{id}

Получить все записи: [GET] /cities

Добавить новую запись: [GET] /cities

Обновление записи: [PUT] /cities/{id}

Удаление записи: [DELETE] /cities/{id}

Все тестирования проводились в Postman
