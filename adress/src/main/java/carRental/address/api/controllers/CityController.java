package carRental.address.api.controllers;

import carRental.address.business.abstracts.CityService;
import carRental.address.business.abstracts.StreetService;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/City")
public class CityController {
    private CityService cityService;
    private StreetService streetService;
    @Autowired
    public CityController(CityService cityService,StreetService streetService){
        super();
        this.cityService=cityService;
        this.streetService=streetService;
    }
    @PostMapping("/AddCity")
    @ResponseStatus(HttpStatus.CREATED)
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }
    @PutMapping("/UpdateCityByName/{cityName}")
    public City updateCityByName(String cityName,City city){
        return cityService.updateCityByName(cityName,city);

    }
    @PutMapping("/UpdateCityById/{cityId}")
    public City updateCityByName(int cityId,City city){
        return cityService.updateCityById(cityId,city);

    }
    @DeleteMapping("/DeleteCityByName/{cityName}")
    public void deleteCityByName(@PathVariable String cityName){
        cityService.deleteCityByName(cityName);
    }

    @DeleteMapping("/DeleteCityById/{cityId}")
    public void deleteCityByName(@PathVariable int cityId){

        cityService.deleteCityById(cityId);
    }
    @PostMapping("/AddStreetToCityByName/{cityName}")
    public Street addStreetToCityByName(@PathVariable String cityName,@RequestParam Street street){
        return cityService.addStreetToCityByName(cityName,street);

    }
    @PostMapping("/AddStreetToCityById/{cityId}")
    public Street addStreetToCityById(@PathVariable int cityId,@RequestParam Street street){
        return cityService.addStreetToCityById(cityId,street);

    }
    @PutMapping("/UpdateStreetInCityByName/{cityName}")
    public Street updateStreetInCityByName(String cityName,Street street){
        return cityService.updateStreetInCityByName(cityName,street);
    }


    @GetMapping("/GetStreetsInCity({cityName}")
    public List<Street> getStreetsInCity(@PathVariable String cityName){

        return getStreetsInCity(cityName);
    }
    @GetMapping("/GetAllCities")
    public List<City> getAllCities(){
        return cityService.getAllCities();

    }

}
