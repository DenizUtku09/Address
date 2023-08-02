package carRental.address.business.concretes;

import carRental.address.business.abstracts.CityService;
import carRental.address.dataAccess.abstracts.CityDao;
import carRental.address.dataAccess.abstracts.StreetDao;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
import carRental.address.entities.concretes.Street;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityManager implements CityService {

    private CityDao cityDao;
    private StreetDao streetDao;
    @Autowired
    public CityManager(CityDao cityDao, StreetDao streetDao){
        super();
        this.cityDao=cityDao;

        this.streetDao = streetDao;
    }





    @Override
    public City addCity(City city) {
        Optional<City> existingCity=cityDao.findCityByCityName(city.getCityName());
        if(existingCity.isPresent()){
            throw new RuntimeException("This city already exists");
        }
        else {
            City addedCity = cityDao.save(city);
            return addedCity;
        }
    }

    @Override
    public City updateCityByName(String cityName, City city) {
        Optional<City> existingCity=cityDao.findCityByCityName(cityName);
        if(existingCity.isPresent()){

            City updatedCity=cityDao.save(city);
            return updatedCity;




        }
        else{
            throw new EntityNotFoundException("City not found");
        }
    }

    @Override
    public City updateCityById(int cityId, City city) {
        Optional<City> existingCity=cityDao.findCityByCityId(cityId);
        if(existingCity.isPresent()){

            City updatedCity=cityDao.save(city);
            return updatedCity;
        }
        else{
            throw new EntityNotFoundException("City not found");
        }
    }

    @Override
    public void deleteCityByName(String cityName) {
        Optional<City> existingCity=cityDao.findCityByCityName(cityName);
        if(existingCity.isPresent()){

            cityDao.delete(existingCity.get());

        }

    }

    @Override
    public void deleteCityById(int cityId) {
        Optional<City> existingCity=cityDao.findCityByCityId(cityId);
        if(existingCity.isPresent()){
            cityDao.delete(existingCity.get());

        }
        else{
            throw new RuntimeException("This city already does not exist.");

        }


    }


    @Override
    public Street addStreetToCityById(int cityId, Street street) {
        Optional<City> existingCity=cityDao.findById(cityId);
        if(existingCity.isPresent()){
            Street addedStreet=streetDao.save(street);
            return addedStreet;

        }
        else{
            throw new RuntimeException("This city does not exist by ID.");
        }

    }

    @Override
    public Street addStreetToCityByName(String cityName, Street street) {
        Optional<City> existingCity=cityDao.findCityByCityName(cityName);
        if(existingCity.isPresent()){
            Street addedStreet=streetDao.save(street);
            return addedStreet;


        }
        else{
            throw new RuntimeException("This city name is not found.");
        }
    }

    @Override
    public Street updateStreetInCityByName(String cityName, Street street) {

        Optional<City> existingCity=cityDao.findCityByCityName(cityName);
        Optional<Street> existingStreet=streetDao.findStreetByStreetIdOrStreetName(street.getStreetId(),street.getStreetName());
        if(existingCity.isPresent() && existingStreet.isPresent()) {


            Street updatedStreet=streetDao.save(existingStreet.get());
            return updatedStreet;




        }
        else if(existingCity.isEmpty()){
            throw new RuntimeException("This country is not found");

        }
        else if(existingStreet.isEmpty()) {
            throw new RuntimeException("This city is not found");
        }
        else if(existingCity.isEmpty() && existingStreet.isEmpty()) {
            throw new RuntimeException("This city and country is not found");
        }
        return null;

    }

    @Override
    public Street updateStreetInCityById(int cityId, Street street) {
        return null;
    }

    @Override
    public void deleteStreetInCityByName(String cityName, Street street) {
        Optional<City> existingCity=cityDao.findCityByCityName(cityName);
        Optional<Street> existingStreet=streetDao.findStreetByStreetIdOrStreetName(street.getStreetId(),street.getStreetName());



        if (existingCity.isPresent() && existingStreet.isPresent()) {
            streetDao.delete(existingStreet.get());

        } else {

            throw new RuntimeException("Deleting operation is not successful.");




        }

    }

    @Override
    public void deleteStreetInCityById(int cityId, Street street) {

        Optional<City> existingCity=cityDao.findCityByCityId(cityId);
        Optional<Street> existingStreet=streetDao.findStreetByStreetIdOrStreetName(street.getStreetId(),street.getStreetName());



        if (existingCity.isPresent() && existingStreet.isPresent()) {
            streetDao.delete(existingStreet.get());

        } else {

            throw new RuntimeException("Deleting operation is not successful.");




        }

    }





    @Override
    public Optional<City> getCityByCityName(String cityName) {
        return cityDao.findCityByCityName(cityName);


    }
    public Optional<City> getCityById(int cityId){
        return cityDao.findCityByCityId(cityId);


    }

    @Override
    public List<Street> getStreetsInCityByName(String cityName) {
        return streetDao.findStreetsByCityCityName(cityName);


    }

    @Override
    public List<Street> getStreetsInCityById(int cityId) {
        return streetDao.findStreetsByCityCityId(cityId);

    }

    public List<City> getAllCities(){
        return cityDao.findAll();

    }
}
