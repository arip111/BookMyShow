package Dev.Arip.BookMyShow.service;

import Dev.Arip.BookMyShow.model.ShowSeat;
import Dev.Arip.BookMyShow.model.Ticket;
import Dev.Arip.BookMyShow.model.constant.ShowSeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    public ShowSeatService showSeatService;
    public String greet()
    {
        return "Hello";
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        for(int showSeatId : showSeatIds)
        {
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!showSeatIds.equals(ShowSeatStatus.AVAILABLE))
            {
                throw new Exception("Seat is not Available");
            }
        }
        for(int showSeatId : showSeatIds)
        {
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
        startPayment(showSeatIds);

        return new Ticket();
    }

    public boolean startPayment(List<Integer> showSeatIds)
    {
        return true;
    }
}
