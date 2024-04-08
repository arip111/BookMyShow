package Dev.Arip.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDTO {
    private String name;
    private String email;
    private String pwd;
}
