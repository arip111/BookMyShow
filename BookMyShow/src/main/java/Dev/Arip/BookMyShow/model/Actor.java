package Dev.Arip.BookMyShow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ACTOR")
public class Actor extends BaseModel{
    private String name;
}
