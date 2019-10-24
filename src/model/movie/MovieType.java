package model.movie;

public enum MovieType {
    THREE_DIMENSION("3D"),
    TWO_DIMENSION("2D"),
    IMAX("IMAX");


    private String description;


    MovieType(String description) {
        this.description = description;
    }
}
