package model.cinema;

public enum CinemaType {
    NORMAL("normal"),
    PLATINUM_MOVIE_SUITES("platinum");

    private String name;

    CinemaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
