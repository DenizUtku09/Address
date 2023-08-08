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
import java.util.Optional;

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
    public CityDTO addCity(String countryName,AddCityRequest addCityRequest) {
        Optional<Country> existingCountry = countryDao.findCountryByCountryName(countryName);
        City existingCity = cityDao.findCityByCityName(addCityRequest.cityName());

        if (existingCountry.isEmpty()) {
            throw new EntityNotFoundException("This country does not exist.");
        }
        if (existingCity!=null) {
            throw new IllegalStateException("This city already exists.");


        }

            City addedCity = new City();
            addedCity.setCityName(addCityRequest.cityName());
            addedCity.setCountry(existingCountry.get());
            cityDao.save(addedCity);

            CityDTO addedCityDTO = new CityDTO();
            addedCityDTO.setCityName(addedCity.getCityName());
            addedCityDTO.setCityId(addedCity.getCityId());
            addedCityDTO.setCountry(addedCity.getCountry());
            return addedCityDTO;



    }
    @Override
    public void updateCityByName(String cityName, UpdateCityRequest updateCityRequest) {
        City existingCity = cityDao.findCityByCityName(cityName);
        if (updateCityRequest.cityName().equals(existingCity.getCityName())) {
            throw new IllegalStateException("This city name is same as before.");
        }
        if(existingCity.equals(null)){
            throw new EntityNotFoundException("This city is not found");
        }
            existingCity.setCityName(updateCityRequest.cityName());
            cityDao.save(existingCity);

            CityDTO updatedCityDTO = new CityDTO();
            updatedCityDTO.setCityId(existingCity.getCityId());
            updatedCityDTO.setCityName(existingCity.getCityName());
        }

    @Override
    public void updateCityById(int cityId,UpdateCityRequest updateCityRequest){
        City existingCity=cityDao.findCityByCityId(cityId);
        if(existingCity.getCityName().equals(updateCityRequest.cityName())){
            throw new EntityNotFoundException("This city name is same as before.");
        }
        existingCity.setCityName(updateCityRequest.cityName());
        cityDao.save(existingCity);

        CityDTO updatedCityDTO= new CityDTO();
        updatedCityDTO.setCityId(existingCity.getCityId());
        updatedCityDTO.setCityName(existingCity.getCityName());
    }



    @Override
    public void deleteCityByName(DeleteCityByNameRequest deleteCityByNameRequest){
        City existingCity=cityDao.findCityByCityName(deleteCityByNameRequest.cityName());
        if(existingCity.getCityName().equals(deleteCityByNameRequest.cityName())){
            cityDao.delete(existingCity);
        }
        else{
            throw new RuntimeException("This city does not exist.");
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
