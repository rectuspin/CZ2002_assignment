package model.movie;

public enum MovieRating {
    G("General"),
    PG("Parental Guidance"),
    PG13("Parental Guidance 13 years and below"),
    NC16("No children under 16"),
    M18("Mature 18"),
    R21("Restricted 21");


    private String description;

    MovieRating(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
