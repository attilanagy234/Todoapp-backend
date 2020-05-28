# TodoApp
Spring application to track your TODOs.

## Backend description

The backend is composed of two main parts. The [todo-api](https://github.com/alkalmazasfejlesztes/alf-hf-2020t-naatho/tree/master/backend/todo-api) contains all the entities of our todo app and serve HTTP requests. Apart from this, a [cron job](https://github.com/alkalmazasfejlesztes/alf-hf-2020t-naatho/blob/master/backend/todo-api/src/main/java/com/naatho/todoapp/utils/ReminderScheduler.java) is checking for Tasks in the MySQL DB, whose deadline is approaching (less than 1 hour remaining). If this happens, we put a [Notification](https://github.com/alkalmazasfejlesztes/alf-hf-2020t-naatho/blob/master/backend/todo-common/src/main/java/com/naatho/todoapp/common/Notification.java) object to a Kafka queue. On the other end of the queue is our other backend component, the [todo-notifier](https://github.com/alkalmazasfejlesztes/alf-hf-2020t-naatho/tree/master/backend/todo-notifier). It's main job is listening for these events and notifying an email sender to send out a reminder email to the assignees of the task.

## Setup
The backend components run in Docker. To spin them up, just run:
```bat
cd backend/todo-api
docker-compose up
```
This will start an instance of MySQL, Kafka and Zookeeper.

The MySQL volume is mounted to ./Database.

## Data
If the Database is empty upon startup, a [data populator](https://github.com/alkalmazasfejlesztes/alf-hf-2020t-naatho/blob/master/backend/todo-api/src/main/java/com/naatho/todoapp/utils/DemoDataCreator.java) adds dummy data to the DB, so it is easier to test requests.

## Open endpoints
* Login: `POST /login`
* Registration: `POST /register`

Everything else requires authentication. 

Swagger is available at http://localhost:8080/swagger-ui.html. Although it is accessible without logging in, you cannot make requests anonimously.