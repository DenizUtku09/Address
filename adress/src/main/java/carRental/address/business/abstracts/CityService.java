package carRental.address.business.abstracts;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;
import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.StreetDTO;
import carRental.address.entities.concretes.dtos.requests.city.*;
import carRental.address.entities.concretes.dtos.requests.street.AddStreetRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByIdRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByNameRequest;
import java.util.List;

public interface CityService {
    CityDTO addCity(String countryName,AddCityRequest addCityRequest);
    void updateCityByName(String cityName, UpdateCityRequest updateCityRequest);
    void updateCityById(int cityId,UpdateCityRequest updateCityRequest);
    void deleteCityByName(DeleteCityByNameRequest deleteCityByNameRequest);
    void deleteCityById(DeleteCityByIdRequest deleteCityByIdRequest);
    StreetDTO addStreetToCityById(int cityId,AddStreetRequest addStreetRequest);
    StreetDTO addStreetToCityByName(String cityName,AddStreetRequest addStreetRequest);
    StreetDTO updateStreetInCityByName(String cityName,String streetName,AddStreetRequest addStreetRequest);
    StreetDTO updateStreetInCityById(int cityId,int streetId,AddStreetRequest addStreetRequest);
    void deleteStreetInCityByName(String cityName, DeleteStreetByNameRequest deleteStreetByNameRequest);
    void deleteStreetInCityById(int cityId, DeleteStreetByIdRequest deleteStreetByIdRequest);
    City getCityByCityName(String cityName);
    City getCityById(int cityId);
    List<Street> getStreetsInCityByName(String cityName);
    List<Street> getStreetsInCityById(int cityId);
    List<CityDTO> getAllCities();






}
