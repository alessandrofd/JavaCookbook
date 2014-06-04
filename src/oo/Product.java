package oo;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class Product {
    String title;
    String artist;
    Media media;

    public Product(String title, String artist, Media media) {
        this.title = title;
        this.artist = artist;
        this.media = media;
    }

    @Override
    public String toString() {
        switch (media) {
            case BOOK:
                return title + " is a book";
            case MUSIC_CD:
                return title + " is a CD";
            case MUSIC_VINYL:
                return title + " is a relic of the age of vinyl";
            case MOVIE_VHS:
                return  title + " is an old video tape";
            case MOVIE_DVD:
                return title + " is on DVD";
            default:
                return title + ": Unknown media " + media;
        }
    }
}
