# ReslivCityBot

**Вступительное задание для компании Resliv**

Стек: Java8, Spring Boot, Spring MVC, SpringData, Hibernate, PostgreSQL, Maven.

**Создание базы данных**
- создать базу данных в pgAdmin и придумать ей имя,например:resliv.
- в конфигурационном файле,который находится по пути src/main/resources/application.properties, необходимо указать данные своей базы данных по следующему шаблону: 
spring.datasource.url=jdbc:postgresql://<хост>:<порт>/<имя_базы_данных> 

    Например: _spring.datasource.url=jdbc:postgresql://localhost:5432/resliv_
    
    **Замечание:** имя базы данных должно совпадать с именем, указанным при создании БД (п.1.)
    
- В том же файле требуется указать логин и пароль для доступа к своей базе данных в spring.datasource.username и 
spring.datasource.password соответственно, например:

    _spring.datasource.username=login_
        
    _spring.datasource.password=password_
    
     **_Примечание:_** _если на этом этапе вы выполнили настройку приложения правильно,то при первом запуске будет автоматически создана таблица_
     
 - Для инициализации базы данных используйте sql скрипты в resources.


**Настройка бота**

Вы можете воспользоваться уже готовым ботом с именем CityBot

Данные,необходимые для подключения уже созданного бота (указываются в конфигурационном файле telegram.properties):

_resliv.bot.name=CityMessageReslivbot_

_resliv.bot.token=1132435302:AAGILmsnnbZSTGMLcF7jqZbHuZP1fmXZ9zo_


**О работе приложения(REST):**

Получить запись по id: [GET] /cities/{id}

Получить все записи: [GET] /cities

Добавить новую запись: [GET] /cities

Обновление записи: [PUT] /cities/{id}

Удаление записи: [DELETE] /cities/{id}

_Все тестирования проводились в Postman_
