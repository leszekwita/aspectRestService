package pl.radzik.michal.aspectrestservice.domain;

import java.util.Objects;

public class Film {


        private int id;

        private String name;

        private int year;

        private String producent;

    public Film() {
    }

    public Film(int id, String name, int year, String producent) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.producent = producent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && year == film.year && Objects.equals(name, film.name) && Objects.equals(producent, film.producent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, producent);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", producent='" + producent + '\'' +
                '}';
    }
}
