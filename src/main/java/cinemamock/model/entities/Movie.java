package cinemamock.model.entities;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Movie")
public class Movie {


    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "movie_sequence"
    )

    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "duration")
    private int duration; //change to Duration class later here and constructor

    @Column(name = "image")
    private String image; //change to BitMap class later here and constructor


    @OneToMany(mappedBy = "movie")
    private Set<Session> session;

    public Movie() {
    }

    public Movie(String title, String description, int duration, String image) {
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

    public int getDuration() {

        return duration;
    }

    public void setDuration(int duration) {

        this.duration = duration;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public Set<Session> getSession() {
        return session;
    }

    public void setSession(Set<Session> session) {
        this.session = session;
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