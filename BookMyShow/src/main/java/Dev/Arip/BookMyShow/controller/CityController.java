package Dev.Arip.BookMyShow.controller;

import Dev.Arip.BookMyShow.dtos.CityRequestDTO;
import Dev.Arip.BookMyShow.model.City;
import Dev.Arip.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO)
    {
        try {
            String cityName = cityRequestDTO.getName();
            if( cityName == null)
            {
                throw new Exception("CityName is null");
            }
            City saveCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(saveCity);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("city/{name}")
    public ResponseEntity getCity(@PathVariable("name") String cityName)
    {
        City city = cityService.getCity(cityName);
        return ResponseEntity.ok(city);

    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId)
    {
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }
}
