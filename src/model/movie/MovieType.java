package model.movie;

public enum MovieType {
    THREE_DIMENSION("3D", 0),
    DIGITAL("Digital", 0),
    IMAX("IMAX", 0);


    private String description;
    protected double prices;

    MovieType(String description, double prices) {

        this.description = description;
        this.prices = prices;
    }

    public double getTicketPrice() {
        return prices;
    }

    public void setTicketPrice(double prices) {
        this.prices = prices;
    }
}

