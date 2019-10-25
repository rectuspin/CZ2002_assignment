package model.movie;

public enum MovieType {
    THREE_DIMENSION("3D"),
    DIGITAL("Digital"),
    IMAX("IMAX");


    private String description;


    MovieType(String description) {
        this.description = description;
    }
}
