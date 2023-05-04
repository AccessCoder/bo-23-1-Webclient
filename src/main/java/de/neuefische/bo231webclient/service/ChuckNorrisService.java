package de.neuefische.bo231webclient.service;

import de.neuefische.bo231webclient.model.ChuckNorrisJoke;
import de.neuefische.bo231webclient.model.ChuckNorrisJokeCollection;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class ChuckNorrisService {

    WebClient webClient = WebClient.create("https://api.chucknorris.io/jokes/"); // Standard Uri für alle Anfragen
    public String getRandomJoke() {
        ChuckNorrisJoke response =
                Objects.requireNonNull(webClient.get()
                                .uri("random") // Spezifizierung der Uri auf genaue Adresse
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // JSON als Content festlegen
                                .retrieve() // hole mir die Daten!
                                .toEntity(ChuckNorrisJoke.class) // Mappe sie bitte auf folgende Klasse
                                .block()) // Warte bis alles andere fertig ist
                        .getBody(); // Gib mir den Körper der Antwort in welchem die Daten vorhanden sind ALTERNATIVE Header = beinhaltet Metadaten.
            return response.getValue();
    }

    public List<ChuckNorrisJoke> getJokesByCategory(String category) {
        ChuckNorrisJokeCollection response =
                Objects.requireNonNull(webClient.get()
                                .uri("search?query=" + category) // Spezifizierung der Uri auf genaue Adresse
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // JSON als Content festlegen
                                .retrieve() // hole mir die Daten!
                                .toEntity(ChuckNorrisJokeCollection.class) // Mappe sie bitte auf folgende Klasse
                                .block()) // Warte bis alles andere fertig ist
                        .getBody(); // Gib mir den Körper der Antwort in welchem die Daten vorhanden sind ALTERNATIVE Header = beinhaltet Metadaten.
        return response.getResult();
    }
}
