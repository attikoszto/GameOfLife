# GameOfLife
Dieses Projekt ist eine Implementierung des berühmten zellulären Automaten "Game of Life", der von John Conway erfunden wurde. Die Anwendung wurde in Java mit Swing für die grafische Benutzeroberfläche entwickelt. Das Spielfeld besteht aus einem 90x90 Gitter, wobei jede Zelle entweder lebendig (weiß) oder tot (schwarz) sein kann. Die Nutzer können das Spiel steuern, indem sie entweder die Simulation starten oder pausieren, oder das Spielfeld zufällig mit lebenden und toten Zellen füllen.

Hauptmerkmale:

    Ein 90x90 Gitter, das die Welt des "Game of Life" repräsentiert.
    Ein "Start"-Button, um die Simulation zu starten oder zu pausieren.
    Ein "Random"-Button, um das Spielfeld zufällig zu füllen.
    Die Möglichkeit, auf einzelne Zellen zu klicken, um ihren Zustand manuell zu ändern.
    Eine visuelle Darstellung des Spiels, die in Echtzeit aktualisiert wird, um die Entwicklung der Zellen über die Zeit zu zeigen.

Die Logik des Spiels ist in der Klasse Alive gekapselt, die die Regeln für die Überlebensfähigkeit der Zellen in der nächsten Generation definiert, basierend auf der Anzahl der lebenden Nachbarn. Die Klasse GameOfLife enthält die Hauptlogik für die Verwaltung des Spielfelds, die Benutzeroberfläche und die Interaktionen des Nutzers.
