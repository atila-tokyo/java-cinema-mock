package cinemamock.model.entities;

import sun.jvm.hotspot.utilities.BitMap;

import javax.persistence.Entity;
import java.time.Duration;

@Entity
public class Movie {
    private String title;
    private String description;
    private Duration duration;
    private BitMap image;

    public Movie(String title, String description, java.time.Duration duration, BitMap image) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public BitMap getImage() {
        return image;
    }

    public void setImage(BitMap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", image=" + image +
                '}';
    }
}