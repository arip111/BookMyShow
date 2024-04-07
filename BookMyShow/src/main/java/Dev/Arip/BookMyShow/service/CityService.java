package Dev.Arip.BookMyShow.service;

import Dev.Arip.BookMyShow.model.City;
import Dev.Arip.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName)
    {
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }
    public boolean deleteCity(int cityId)
    {
        cityRepository.deleteById(cityId);
        return true;
    }

    public City getCity(String cityName)
    {
        return cityRepository.findCitiesByName(cityName);
    }
}
