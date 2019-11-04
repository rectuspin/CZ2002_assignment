package model.movie;

import model.Model;

public class MovieEnums implements Model {
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

    public enum MovieType {
        THREE_DIMENSION("3D", 14),
        DIGITAL("Digital", 12),
        IMAX("IMAX", 16);


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

    public enum Subtitle {
        English,
        Mandarin,
        Malay,
        Tamil,
        None
    }

    public enum Language {
        ENGLISH,
        MANDARIN,
        MALAY,
        TAMIl
    }
}
