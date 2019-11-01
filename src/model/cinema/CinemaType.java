package model.cinema;

public enum CinemaType {
    STANDARD("Standard", 0),
    PLATINUM_MOVIE_SUITES("Suites", 0),
    IMAX("IMAX", 0);

    private String name;
    private double prices;

    CinemaType(String name, double prices) {
        this.name = name;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public double getTicketPrice() {
        return prices;
    }

    public void setTicketPrice(double prices) {
        this.prices = prices;
    }
}
