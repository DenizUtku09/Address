package carRental.address.api.controllers;

import carRental.address.business.abstracts.CityService;

import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.requests.city.AddCityRequest;
import carRental.address.entities.concretes.dtos.requests.city.DeleteCityByIdRequest;
import carRental.address.entities.concretes.dtos.requests.city.DeleteCityByNameRequest;
import carRental.address.entities.concretes.dtos.requests.city.UpdateCityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/City")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        super();
        this.cityService=cityService;

    }
    @PostMapping("/AddCity")
    @ResponseStatus(HttpStatus.CREATED)
    public CityDTO addCity(@RequestBody AddCityRequest addCityRequest){
        return cityService.addCity(addCityRequest);
    }
    @PutMapping("/UpdateCityByName/{cityName}")
    public void updateCityByName(@PathVariable String cityName, UpdateCityRequest updateCityRequest){cityService.updateCityByName(cityName,updateCityRequest);}
    @PutMapping("/UpdateCityById/{cityId}")
    public void updateCityById(@PathVariable int cityId,UpdateCityRequest updateCityRequest) {cityService.updateCityById(cityId,updateCityRequest);}
    @DeleteMapping("/DeleteCityByName")
    public void deleteCityByName(@RequestBody DeleteCityByNameRequest deleteCityByNameRequest){cityService.deleteCityByName(deleteCityByNameRequest);}
    @DeleteMapping("/DeleteCityById")
    public void deleteCityById(@RequestBody DeleteCityByIdRequest deleteCityByIdRequest){cityService.deleteCityById(deleteCityByIdRequest);}

}
