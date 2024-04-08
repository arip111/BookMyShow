package Dev.Arip.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String name;

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    @OneToMany
    private List<Theatre> theatres;
}
