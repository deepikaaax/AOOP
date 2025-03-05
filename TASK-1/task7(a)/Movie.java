class Movie implements Comparable<Movie> {
    private String name;
    private double rating;
    private int year;

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Movie other) {
        return Integer.compare(this.year, other.year);
    }

    @Override
    public String toString() {
        return name + " (" + year + ") - Rating: " + rating;
    }
}
