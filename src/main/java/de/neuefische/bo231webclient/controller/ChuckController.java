package de.neuefische.bo231webclient.controller;

import de.neuefische.bo231webclient.model.ChuckNorrisJoke;
import de.neuefische.bo231webclient.service.ChuckNorrisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class ChuckController {

    private final ChuckNorrisService service;

    @GetMapping
    public String getRandomJoke(){
        return service.getRandomJoke();
    }

    @GetMapping( "/all/{category}")
    public List<ChuckNorrisJoke> getRandomJoke(@PathVariable String category){
        return service.getJokesByCategory(category);
    }

}
