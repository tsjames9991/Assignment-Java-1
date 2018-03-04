package org.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {
    private List<MovieClass> database = Arrays.asList(
            (new MovieClass("Shawshank Redemption", 1994, 9, "Crime")),
            (new MovieClass("12 Angry Men", 1957, 9, "Drama")),
            (new MovieClass("Ex Machina", 2014, 7, "Sci-Fi")),
            (new MovieClass("The Good, the Bad and the Ugly", 1966, 9, "Western")),
            (new MovieClass("Fistful of Dollars", 1964, 8, "Western")),
            (new MovieClass("Inception", 2010, 8, "Action")),
            (new MovieClass("Interstella 5555: The 5tory of the 5ecret 5tar 5ystem", 2003, 7, "Animation")),
            (new MovieClass("Shichinin No Samurai", 1954, 9, "Adventure")),
            (new MovieClass("Kill Bill: Vol. 1", 2003, 8, "Action")),
            (new MovieClass("fifty Shades Freed", 2018, 4, "Drama")),
            (new MovieClass("A Walk T Remember", 2002, 7, "Romance")),
            (new MovieClass("If I Stay", 2014, 6, "Drama")),
            (new MovieClass("Gravity", 2013, 7, "Sci-Fi")),
            (new MovieClass("Music And Lyrics", 2007, 6, "Comedy")),
            (new MovieClass("Moulin Rouge", 2001, 7, "Musical")),
            (new MovieClass("Phantom Of The Opera", 2004, 7, "Musical")),
            (new MovieClass("Encounter II", 2018, 9, "Sci-Fi")),
            (new MovieClass("The Matrix", 1999, 8, "Sci-Fi")),
            (new MovieClass("Interstellar", 2016, 8, "Sci-Fi"))
    );

    public void filterGenreWithRating(String genre, int rating) {
        database.stream()
                .filter(movie -> genre.equals(movie.getGenre()) && (rating == movie.getRating()))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public void filterYearWithRating(int year, int rating) {
        database.stream()
                .filter(movie -> (year < movie.getYear()) && (rating > movie.getRating()))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public void filterAsEvenRating() {
        database.stream()
                .filter(movie -> (movie.getRating() % 2 == 0))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public class MovieClass {
        String name;
        int year;
        int rating;
        String genre;

        public MovieClass(String name, int year, int rating, String genre) {
            this.name = name;
            this.year = year;
            this.rating = rating;
            this.genre = genre;
        }

        @Override
        public String toString() {
            return ("\nMovie: " + this.name + "\nYear: " + this.year + "\nRating: " + this.rating + "\nGenre: " + this.genre);
        }

        public int getYear() {
            return year;
        }

        public int getRating() {
            return rating;
        }

        public String getGenre() {
            return genre;
        }
    }
}
