package pl.radzik.michal.aspectrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.radzik.michal.aspectrestservice.service.FilmService;
import pl.radzik.michal.aspectrestservice.domain.Film;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Film>> getFilms() {
        return new ResponseEntity<>(filmService.getFilms(), HttpStatus.OK);
    }


    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        boolean added = filmService.addFilm(film);
        if (added) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
