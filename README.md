# FitManager – Edzőtermi nyilvántartó rendszer

## A projekt bemutatása

A FitManager egy Java nyelven készült, grafikus felhasználói felülettel rendelkező asztali alkalmazás, amely egy edzőterem mindennapi nyilvántartási feladatait támogatja. Egyetemi projektfeladatként készült.

Az alkalmazás a tagok kezelését, a bérletek nyilvántartását, a belépések ellenőrzését és az alapvető kimutatások megjelenítését teszi lehetővé.

## Főbb funkciók

### Tagnyilvántartás
- Tagok rögzítése, adatainak módosítása és törlése.
- Tagok keresése és táblázatos megjelenítése.

### Bérletkezelés
- Tag és bérlettípus kiválasztása.
- Bérlet kezdő- és lejárati dátumának megadása.
- Bérletek mentése és keresése a tag neve alapján.
- Automatikus állapotjelzés az aktuális dátum szerint: **Aktív**, **Lejárt**, **Még nem érvényes**.
- Az állapotok színes megjelenítése.

### Beléptetés
- Tag kiválasztása.
- Érvényes bérlet ellenőrzése.
- Belépés rögzítése az adatbázisban.

### Kimutatások
- Tagok számának megjelenítése.
- Bérletek számának megjelenítése.
- Rögzített belépések számának megjelenítése.

## Felhasznált technológiák

- Java SE 8
- Java Swing, NetBeans GUI Builder
- NetBeans IDE 8.2
- Apache Derby adatbázis
- JDBC és SQL
- Git és GitHub verziókövetés

## A program főbb osztályai

| Osztály | Feladat |
| --- | --- |
| `FitManager` | A program indítása |
| `Foablak` | A főmenü megjelenítése |
| `TagokAblak` | Tagok kezelése |
| `BerletekAblak` | Bérletek kezelése |
| `BeleptetesAblak` | Beléptetés |
| `KimutatasokAblak` | Kimutatások |
| `AdatbazisKezelo` | Adatbázis-kapcsolat és műveletek |
| `Megjelenes` | Egységes grafikus megjelenés |

## Adatbázis

Az alkalmazás Apache Derby adatbázist használ. A főbb táblák a tagok, a bérletek és a belépések adatait tárolják, egymáshoz kapcsolódva.

Az adatbázis JDBC-elérési útja:

```text
jdbc:derby:FitManagerDB
```

Az adatbázis relatív elérési útvonalon található, ezért az indítás munkakönyvtára fontos.

## Futtatás

### NetBeans IDE használatával

1. Nyissuk meg a `FitManager` projektet a NetBeans IDE-ben.
2. Ellenőrizzük, hogy a Derby-könyvtárak elérhetők-e a projektben.
3. Indítsuk el a programot a **Run Project** paranccsal.

### JAR-fájlból

A program Java 8 futtatókörnyezetet igényel. Az alábbi parancsot **a FitManager projekt gyökérkönyvtárából** kell kiadni, ahol a `FitManagerDB` és a `dist` mappa is található:

```bat
java -jar dist\FitManager.jar
```

A szükséges állományok:

- `dist/FitManager.jar`
- `dist/lib/` – a futtatáshoz szükséges Derby-függőségek
- `FitManagerDB/` – az adatbázis állományai

Az adatbázis másolása előtt a programot és az esetlegesen futó Derby-kapcsolatokat le kell állítani. A tényleges beadási csomagot egy másik mappából történő indítással is ajánlott ellenőrizni.

## Dokumentáció

A beadási csomag a projekthez kapcsolódó dokumentációt is tartalmazza:

- Projektterv
- Adatbázisterv
- Programterv, UML-modell és Use-case diagram

## A projekt célja

A FitManager a Java-programozási, grafikusfelület-készítési, adatbázis-kezelési és szoftvertervezési ismeretek gyakorlati alkalmazását mutatja be egy összetett, működőképes alkalmazásban.

## GitHub

A FitManager projekt forráskódja és fejlesztési előzményei a GitHubon is elérhetők.

**GitHub-tároló:** https://github.com/elekvk/FitManager
