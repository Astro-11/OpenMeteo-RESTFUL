# Weather API

Applicazione Spring Boot per la raccolta e la presentazione di dati meteorologici tramite API REST.
Il progetto acquisisce periodicamente i dati meteo di alcune città tramite l'API pubblica di [Open-Meteo](https://open-meteo.com/) e li salva in un database H2. 
Successivamente espone endpoint REST per ottenere le medie delle misurazioni raccolte per ogni città.

## API REST:

GET /weather - Mostra gli endpoint disponibili.

GET /weather/cities - Restituisce le città configurate e le relative coordinate.

GET /weather/averages - Restituisce le medie delle misurazioni raccolte per tutte le città.

GET /weather/averages/{city} - Restituisce le medie delle misurazioni raccolte per una specifica città.

## Note:

OpenMeteo restituisce sempre i dati in formato metrico. Per questo si è reputato superfluo salvare le unità di misura di ciascuna misurazione.
Anche le medie, di conseguenza, vengono sempre restituite in formato metrico, esplicitando comunque le unità di misura per chiarezza.
