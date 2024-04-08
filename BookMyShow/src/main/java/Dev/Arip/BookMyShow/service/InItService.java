package Dev.Arip.BookMyShow.service;

import Dev.Arip.BookMyShow.model.*;
import Dev.Arip.BookMyShow.model.constant.AuditoriumFeature;
import Dev.Arip.BookMyShow.model.constant.SeatStatus;
import Dev.Arip.BookMyShow.model.constant.SeatType;
import Dev.Arip.BookMyShow.model.constant.ShowSeatStatus;
import Dev.Arip.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InItService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public  boolean initialize()
    {
        City delhi = new City("Delhi");
        City banglore = new City("Banglore");
        City canberra = new City("Canberra");

        cityRepository.save(delhi);
        cityRepository.save(banglore);
        cityRepository.save(canberra);

        City saveDelhi = cityRepository.findCitiesByName("Delhi");
        Theatre ghatalTheatre = new Theatre("PVR","Ghatal");
        Theatre barodaTheatre = new Theatre("INOX","Baroda");
        theatreRepository.save(ghatalTheatre);
        theatreRepository.save(barodaTheatre);
        Theatre saveGhatalTheatre = theatreRepository.findTheatreByName("PVR");
        Theatre saveBarodaTheatre = theatreRepository.findTheatreByName("INOX");

        List<Theatre> delhiTheatre = new ArrayList<>();
        saveDelhi.setTheatres(delhiTheatre);
        delhiTheatre.add(saveGhatalTheatre);
        delhiTheatre.add(saveBarodaTheatre);

        cityRepository.save(saveDelhi);

        for(int i=1;i<=5;i++)
        {
            Seat s = new Seat(i,i,i+" "+i,SeatType.GOLD,SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }
        List<Seat> savedSeat = seatRepository.findAll();

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY,AuditoriumFeature.IMAX));
        auditorium.setSeats(savedSeat);
        auditoriumRepository.save(auditorium);
        //saveGhatalTheatre.setAuditoriums(List.of(auditoriumRepository.findAuditoriumByName("Audi01")));
        //theatreRepository.save(saveGhatalTheatre);

        Auditorium savedAudi = auditoriumRepository.findAuditoriumByName("Audi01");
        Theatre saveTheatre = theatreRepository.findTheatreByName("PVR");
        List<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(savedAudi);
        saveTheatre.setAuditoriums(auditoriums);
        theatreRepository.save(saveTheatre);

        Movie movie = new Movie("Titanic","Best Movie");
        movieRepository.save(movie);

        Show show = new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Titanic"));
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        showRepository.save(show);

        for(int i=1;i<=5;i++)
        {
            ShowSeat s = new ShowSeat(1200,showRepository.findById(1).get(),seatRepository.findSeatBySeatNo(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }


        return true;
    }


}
