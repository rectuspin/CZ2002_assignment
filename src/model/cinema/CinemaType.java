package model.cinema;

public enum CinemaType {
    STANDARD("Standard"),
    PLATINUM_MOVIE_SUITES("Suites"),
    IMAX("IMAX");

    private String name;

    CinemaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
