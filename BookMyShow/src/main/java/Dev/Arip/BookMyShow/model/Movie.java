package Dev.Arip.BookMyShow.model;

import Dev.Arip.BookMyShow.model.constant.MovieFaeture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFaeture> movieFaetures;
}
