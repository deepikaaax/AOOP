import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", 8.8, 2010));
        movies.add(new Movie("Interstellar", 8.6, 2014));
        movies.add(new Movie("The Dark Knight", 9.0, 2008));
        movies.add(new Movie("Memento", 8.4, 2000));

        Collections.sort(movies);

        System.out.println("Movies sorted by release year:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
