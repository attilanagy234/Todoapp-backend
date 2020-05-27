
## Useful Info

### Required java version: 11
### IDE used for dev: IntelliJ Ultimate 2020
- in IntelliJ install: Lombok plugin
### Setting up the MySQL db locally:
 1. Install Docker
 2. run docker-compose up
 
 The DB volume is mounted to ./database so it can remain persistent locally.

### Testing the REST API
[Postman](https://www.postman.com/) is awesome.

---
**Házi feladat**

Csapatnév: Naatho

Csapattagok Neptun kóddal:
- Atyi Ádám (PTZY5J)
- Bóka Máté (NBU9HK)
- Nagy Attila (ER2KCI)


## Things to do
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
