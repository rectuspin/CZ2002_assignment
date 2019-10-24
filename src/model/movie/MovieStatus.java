package model.movie;

public enum MovieStatus {
    ComingSoon(0),
    Preview(1),
    NowShowing(2),
    NotShowing(3);

    private final int statusCode;

    MovieStatus(int statusCode) {
        this.statusCode = statusCode;
    }
}
