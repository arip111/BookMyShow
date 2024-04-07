package Dev.Arip.BookMyShow.service;

import Dev.Arip.BookMyShow.model.ShowSeat;
import Dev.Arip.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId)
    {
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat seat)
    {
        return showSeatRepository.save(seat);
    }
}
