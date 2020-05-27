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
This will start an instance of a MySQL, Kafka and Zookeeper.

The MySQL volume is mounted to ./Database.

## Data
If the Database is empty upon startup, a [data populator](https://github.com/alkalmazasfejlesztes/alf-hf-2020t-naatho/blob/master/backend/todo-api/src/main/java/com/naatho/todoapp/utils/DemoDataCreator.java) adds dummy data to the DB, so it is easier to test requests.

## Open endpoints
* Login: `POST /login`
* Registration: `POST /register`

Everything else requires authentication. 

We also configured Swagger, which is available at http://localhost:8080/swagger-ui.html. Although it is accessible without logging in, you cannot make requests anonimously.


---
**Házi feladat**

Csapatnév: Naatho

Csapattagok Neptun kóddal:
- Atyi Ádám (PTZY5J)
- Bóka Máté (NBU9HK)
- Nagy Attila (ER2KCI)

---
Bemutató videó URL: 
(Ugye minden olyan dolog szerepel benne a kiírásnak megfelelően, amire pontot szeretnétek kapni?)

**Pontot érő technológiák**
(Amit elkészítettetek, azt X-eljétek be!)

Alap feladatok (maximális kapható pontokkal):
- [ ] 7p: Yocto projekt alapokon készített szerver vagy kliens (házi feladatonként egyszer)
- [ ] 5p: Beágyazott Linux rendszerben (de nem Yocto alapokon) készített szerver vagy kliens (feladatonként egyszer).
- [x] 7p: QML alapú grafikus felület (benne legalább egy grafikon vagy egyéb rajzolás, egy lista, valamint menü)
- [x] 7p: REST API (benne új adat létrehozása, lekérdezés, adat módosítása, logikusan felépített URL-ekkel)
- [x] 8p: Több felhasználó, az authentikáció és különböző szerepkörök támogatása.
- [ ] 7p: Linux alatt saját, jól átgondolt kommunikációs protokoll implementálása.
- [ ] 15p: Linux alatt eszközvezérlő készítése
- [x] 5p: Aszinkron üzenetsorral kommunikáló szerverek (vagyis több backend komponens van).
- [x] 5p: Java Persistence API használata, legalább 5 osztállyal.
- [x] 2p: Spring Data használata
- [x] 3p: Függőséginjektálás Spring alapokon
- [ ] 3p: Az alapértelmezettől eltérő tranzakció kezelés.
- [x] 5p: Megfelelő biztonsági óvintézkedések (authorizáció, SQL injection kivédése, szerver oldali validáció, biztonságos jelszó tárolás stb.)
- [x] 2p: Unit tesztek használata (Jelentős lefedettség esetén további bónusz pontokat ér.)
- [x] 3p: Qt alatt signals and slots mechanizmus használata.
- [x] 3p: Logolási mechanizmus használata loglevel támogatással.

Bónusz feladatok, melyek plusz utánajárást is igényelhetnek (maximális kapható pontokkal, csak ha az alap feladatokból időben leadva legalább 30 pont összegyűlt):
- [ ] 5p: Linux alatt telepítő csomag készítése
- [x] 5p: Időzített taskok a backendben.
- [ ] 5p: Linux alatt megszakítás kezelő készítése
- [x] 5p: E-mail küldés a backendben.
- [ ] 3-10p: Jelentős automatikus teszt lefedettség, lefedettségtől függően pontozva
- [ ] 3p: QRC mechanizmus használata nem QML fájlok tárolására és elérésére.
- [ ] 3p: Saját fejlesztésű dinamikusan linkelt könyvtár használata.
- [ ] 8p: Induláskor lefutó öntesztelő funkció megvalósítása, mely a rendszer minden komponensének elérhetőségét és alapvető funkcióinak működőképességét teszteli (pl. webes felületről egy adat elmentése adatbázisba, majd visszaolvasása, hardver periféria megszólítása, valamint a vastag kliensen a logba írás).

A hivatalos teljes lista a HF feladatkiírásban található: https://www.aut.bme.hu/Course/VIAUAC04

**A videó újrahasznosíthatósága**

A házi feladat videót oktatási célokra újrahasznosíthatjuk? (Későbbi évfolyamoknak bemutatás, vágott anyagban felhasználás.)
- [ ] Igen, a szerzők megjelölésével
- [ ] Igen, névtelenül
- [ ] Nem
