package de.neuefische.bo231webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuckNorrisJoke {
    private String id;
    private String value;
}
