package Dev.Arip.BookMyShow.model;

import Dev.Arip.BookMyShow.model.constant.SeatStatus;
import Dev.Arip.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNo;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private int row;
    private int col;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

}
