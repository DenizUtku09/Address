package carRental.address.business.abstracts;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;

import java.util.List;
import java.util.Optional;

public interface CityService {

    City addCity(City city);

    City updateCityByName(String cityName,City city);
    City updateCityById(int cityId,City city);

    void deleteCityByName(String cityName);
    void deleteCityById(int cityId);

    Street addStreetToCityById(int cityId, Street street);
    Street addStreetToCityByName(String cityName,Street street);
    Street updateStreetInCityByName(String cityName, Street street);
    Street updateStreetInCityById(int cityId,Street street);
    void deleteStreetInCityByName(String cityName,Street street);
    void deleteStreetInCityById(int cityId,Street street);

    Optional<City> getCityByCityName(String cityName);
    Optional<City> getCityById(int cityId);

    List<Street> getStreetsInCityByName(String cityName);
    List<Street> getStreetsInCityById(int cityId);

    List<City> getAllCities();






}
