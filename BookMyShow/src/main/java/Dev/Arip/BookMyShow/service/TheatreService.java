package Dev.Arip.BookMyShow.service;

import Dev.Arip.BookMyShow.model.City;
import Dev.Arip.BookMyShow.model.Theatre;
import Dev.Arip.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId)
    {
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre saveTheatre = theatreRepository.save(theatre);

        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(saveTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return saveTheatre;
    }
}
