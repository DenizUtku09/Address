package carRental.address.business.concretes;
import carRental.address.business.abstracts.CityService;
import carRental.address.dataAccess.abstracts.CityDao;
import carRental.address.dataAccess.abstracts.CountryDao;
import carRental.address.dataAccess.abstracts.StreetDao;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
import carRental.address.entities.concretes.Street;
import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.StreetDTO;
import carRental.address.entities.concretes.dtos.requests.city.AddCityRequest;
import carRental.address.entities.concretes.dtos.requests.city.DeleteCityByIdRequest;
import carRental.address.entities.concretes.dtos.requests.city.DeleteCityByNameRequest;
import carRental.address.entities.concretes.dtos.requests.city.UpdateCityRequest;
import carRental.address.entities.concretes.dtos.requests.street.AddStreetRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByIdRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByNameRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityManager implements CityService {
    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final StreetDao streetDao;
    @Autowired
    public CityManager(CityDao cityDao, StreetDao streetDao,CountryDao countryDao){
        super();
        this.cityDao=cityDao;
        this.countryDao=countryDao;
        this.streetDao = streetDao;
    }
    @Override
    public CityDTO addCity(AddCityRequest addCityRequest) {
        City city=cityDao.findCityByCityName(addCityRequest.cityName());
        Country country=countryDao.findCountryByCountryName(addCityRequest.countryName())
                .orElseThrow(()->new RuntimeException("This country does not exist."));

        if(addCityRequest.cityName().equals(city.getCityName())){
            throw new RuntimeException("This city already exists");
        }
        else{
            City addedCity=new City();
            addedCity.setCountry(country);
            addedCity.setCityName(addCityRequest.cityName());
            cityDao.save(addedCity);

            CityDTO addedCityDTO=new CityDTO();
            addedCityDTO.setCityName(addedCity.getCityName());
            addedCityDTO.setCountry(country);
            return addedCityDTO;
        }}
    @Override
    public void updateCityByName(String cityName, UpdateCityRequest updateCityRequest){
        City existingCity=cityDao.findCityByCityName(cityName);

        if(existingCity!=null) {
            City updatedCity = new City();
            updatedCity.setCityName(updatedCity.getCityName());
            updatedCity = cityDao.save(updatedCity);

            CityDTO updatedCityDTO = new CityDTO();
            updatedCityDTO.setCityId(updatedCity.getCityId());
            updatedCityDTO.setCityName(updatedCity.getCityName());
        }
        else{
            throw new RuntimeException("This city is not found.");
        }}

    @Override
    public void updateCityById(int cityId,UpdateCityRequest updateCityRequest){
        City existingCity=cityDao.findCityByCityId(cityId);

        if(existingCity!=null && !updateCityRequest.cityName().equals(existingCity.getCityName())){
            City updatedCity = new City();
            updatedCity.setCityName(updatedCity.getCityName());
            updatedCity = cityDao.save(updatedCity);

            CityDTO updatedCityDTO = new CityDTO();
            updatedCityDTO.setCityId(updatedCity.getCityId());
            updatedCityDTO.setCityName(updatedCity.getCityName());
        }
        else if(existingCity!=null && updateCityRequest.cityName().equals(existingCity.getCityName())){
            throw new RuntimeException("This city name update is same as before.");
        }
        else {
            throw new RuntimeException("This city is not found.");
        }}



    @Override
    public void deleteCityByName(DeleteCityByNameRequest deleteCityByNameRequest){
        if(deleteCityByNameRequest.cityName().isEmpty()){
            throw new RuntimeException("This city you're trying to delete does not exist.");
        }
        else{
            cityDao.deleteCityByCityName(deleteCityByNameRequest.cityName());
        }}
    public void deleteCityById(DeleteCityByIdRequest deleteCityByIdRequest){
        cityDao.deleteById(deleteCityByIdRequest.cityId());
    }

    @Override
    public StreetDTO addStreetToCityById(int cityId,AddStreetRequest addStreetRequest) {
        City existingCity = cityDao.findCityByCityId(cityId);
        Street existingStreet = streetDao.findStreetByStreetName(addStreetRequest.streetName());

        if(existingCity==null){
            throw new RuntimeException("This city is not found by id");
        }
        if(existingStreet!=null){
            throw new RuntimeException("This street name is same as before.");
        }

        Street addedStreet=new Street();
        addedStreet.setStreetName(addStreetRequest.streetName());
        addedStreet.setCity(existingCity);
        streetDao.save(addedStreet);

        StreetDTO addedStreetDTO=new StreetDTO();
        addedStreetDTO.setStreetId(addedStreet.getStreetId());
        addedStreetDTO.setStreetName(addedStreet.getStreetName());
        addedStreetDTO.setCity(addedStreet.getCity());

        return addedStreetDTO;
    }

    @Override
    public StreetDTO addStreetToCityByName(String cityName,AddStreetRequest addStreetRequest){
        City existingCity = cityDao.findCityByCityName(cityName);
        Street existingStreet = streetDao.findStreetByStreetName(addStreetRequest.streetName());

        if(existingCity==null){
            throw new RuntimeException("This city is not found by id");
        }
        if(existingStreet!=null){
            throw new RuntimeException("This street name is same as before.");
        }

        existingStreet.setStreetName(addStreetRequest.streetName());

        StreetDTO addedStreetDTO=new StreetDTO();
        addedStreetDTO.setStreetId(existingStreet.getStreetId());
        addedStreetDTO.setStreetName(existingStreet.getStreetName());
        addedStreetDTO.setCity(existingStreet.getCity());
        return addedStreetDTO;
    }
    public StreetDTO updateStreetInCityByName(String cityName,String streetName,AddStreetRequest addStreetRequest){
        City existingCity = cityDao.findCityByCityName(cityName);
        Street existingStreet = streetDao.findStreetByStreetName(addStreetRequest.streetName());
        if(existingCity==null){
            throw new RuntimeException("This city is not found by id");
        }
        if(existingStreet!=null && existingCity !=null){
            if(addStreetRequest.streetName().equals(existingStreet.getStreetName()))
            {
                throw new RuntimeException("This street name is same as before.");
            }
            Street addedStreet=new Street();
            addedStreet.setStreetName(addStreetRequest.streetName());
            addedStreet.setCity(existingCity);
            streetDao.save(addedStreet);

            StreetDTO addedStreetDTO=new StreetDTO();
            addedStreetDTO.setStreetId(addedStreet.getStreetId());
            addedStreetDTO.setStreetName(addedStreet.getStreetName());
            addedStreetDTO.setCity(addedStreet.getCity());
            return addedStreetDTO;
        }
        return null;}

    public StreetDTO updateStreetInCityById(int cityId,int streetId,AddStreetRequest addStreetRequest){
        City existingCity = cityDao.findCityByCityId(cityId);
        Street existingStreet = streetDao.findStreetByStreetName(addStreetRequest.streetName());
        if(existingCity==null){
            throw new RuntimeException("This city is not found by id");
        }
        if(existingStreet!=null && existingCity !=null){
            if(addStreetRequest.streetName().equals(existingStreet.getStreetName()))
            {
                throw new RuntimeException("This street name is same as before.");
            }
            existingStreet.setStreetName(addStreetRequest.streetName());

            StreetDTO addedStreetDTO=new StreetDTO();
            addedStreetDTO.setStreetId(existingStreet.getStreetId());
            addedStreetDTO.setStreetName(existingStreet.getStreetName());
            addedStreetDTO.setCity(existingStreet.getCity());
            return addedStreetDTO;
        }
        return null;
    }
    public void deleteStreetInCityByName(String cityName, DeleteStreetByNameRequest deleteStreetByNameRequest){
        City existingCity=cityDao.findCityByCityName(cityName);
        Street existingStreet=streetDao.findStreetByStreetName(deleteStreetByNameRequest.streetName());
        if(existingCity.equals(null)){
            throw new EntityNotFoundException("This city by name has not been found");
        }
        else if(existingStreet.equals(null)){
            throw new EntityNotFoundException("This street you are trying to delete does not exist by name.");
        }
        else{
            streetDao.delete(existingStreet);
        }}
    public void deleteStreetInCityById(int cityId, DeleteStreetByIdRequest deleteStreetByIdRequest){
        City existingCity=cityDao.findCityByCityId(cityId);
        Street existingStreet=streetDao.findStreetByStreetId(deleteStreetByIdRequest.streetId());
        if(existingCity.equals(null)){
            throw new EntityNotFoundException("This city by name has not been found");
        }
        else if(existingStreet.equals(null)){
            throw new EntityNotFoundException("This street you are trying to delete does not exist by name.");
        }
        else{
            streetDao.delete(existingStreet);
        }

    }








    @Override
    public City getCityByCityName(String cityName) {
        return cityDao.findCityByCityName(cityName);


    }
    public City getCityById(int cityId){
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
