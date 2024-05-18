# Studienprojekt IPWA02

## Beschreibung
Dieses Projekt ist eine Webanwendung, die CO2-Daten verwaltet. Die Daten werden aus einer CSV-Testdatei importiert und in einer Datenbank gespeichert. 
Für das erfolgreiche Testen der Anwendung werden insgesamt drei Tabellen benötigt: `co2-data`, `co2-data-tmp`, und `loginuser`.

### CSV-Testdatei
Die CSV-Testdatei kann unter folgendem Link bezogen werden: [CO2-Daten CSV-Testdatei](https://github.com/owid/co2-data)

### Tabellenstruktur
- Die Tabellen `co2-data` und `co2-data-tmp` haben den exakt gleichen Aufbau.
- Die Tabelle `loginuser` hat folgenden Aufbau:

#### Table: loginuser
**Spalten:**
- `id` bigint AI PK
- `email` varchar(255)
- `password` varchar(255)
- `username` varchar(255)
- `country` text

### Verwendung der Testdaten
Die Tabelle für die CO2-Daten kann über die Testdatei bezogen und in die Datenbank importiert werden.

## Anleitung zur Verwendung
1. Clone das Repository auf deinem lokalen System.
2. Importiere die CO2-Daten aus der CSV-Testdatei in die `co2-data` Tabelle.
3. Stelle sicher, dass die benötigten Tabellen in der Datenbank vorhanden sind (`co2-data`, `co2-data-tmp`, `loginuser`).
4. Starte die Webanwendung und führe die erforderlichen Aktionen aus.


