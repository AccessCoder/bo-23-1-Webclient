package de.neuefische.bo231webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuckNorrisJokeCollection {

    private int total;
    private List<ChuckNorrisJoke> result;

}
