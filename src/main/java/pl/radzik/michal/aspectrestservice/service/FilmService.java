package pl.radzik.michal.aspectrestservice.service;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.radzik.michal.aspectrestservice.domain.Film;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

        List<Film> films = new ArrayList<>();

        @EventListener(ApplicationReadyEvent.class)
        public void init() {

            films.add(new Film(1, "Terminator", 1991, "Jems Hamilton"));
            films.add(new Film(2, "Rambo", 1988, "Andrev Laszlo"));
            films.add(new Film(3, "Nicko", 1996, "Andrev Metz"));
            films.add(new Film(4, "Rocky", 1979, "Sylwester Stallone"));
        }

        public List<Film> getFilms() {
            return films;
        }


        public boolean addFilm(Film film) {
            return films.add(film);
        }

}
