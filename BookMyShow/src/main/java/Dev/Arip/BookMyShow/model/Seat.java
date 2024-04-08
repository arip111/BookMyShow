package Dev.Arip.BookMyShow.model;

import Dev.Arip.BookMyShow.model.constant.SeatStatus;
import Dev.Arip.BookMyShow.model.constant.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int seatRow;
    private int seatCol;
    private String seatNo;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    public Seat(int seatRow, int seatCol, String seatNo, SeatType seatType, SeatStatus seatStatus) {
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }

    public Seat() {
    }


}
