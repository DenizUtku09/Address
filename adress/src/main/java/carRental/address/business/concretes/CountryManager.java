package carRental.address.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carRental.address.business.abstracts.CountryService;
import carRental.address.dataAccess.abstracts.CityDao;
import carRental.address.dataAccess.abstracts.CountryDao;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
@Service
public class CountryManager implements CountryService {
	
	private CountryDao countryDao;
	@Autowired
	private CityDao cityDao;
	public CountryManager(CityDao cityDao,CountryDao countryDao) {
		super();
		this.countryDao=countryDao;
		this.cityDao=cityDao;
		
		
	}



	@Override
	public Country addCountry(Country country) {
		Country addedcountry=countryDao.save(country);
		
		return addedcountry;
	}

	@Override
	public Country updateCountryByName(String countryName,Country country) {
		Country existingCountry = countryDao.findCountryByCountryName(countryName);
		if (existingCountry==null) {
			throw new RuntimeException("This country name does not exist.");


		} else {
			existingCountry.setCountryName(country.getCountryName());
			Country updatedCountry=countryDao.save(existingCountry);
			return updatedCountry;
		}
	}

	@Override
	public Country updateCountryById(int countryId,Country country) {
		Optional<Country> existingCountry=countryDao.findCountryByCountryId(countryId);
		if(existingCountry.isPresent()){

			Country updatedCountry=countryDao.save(country);
			return updatedCountry;


		}
		else{
			throw new RuntimeException("This country ID does not exist.");
		}
	}


	@Override
	public void deleteCountryByName(String countryName) {

		Country existingCountry=countryDao.findCountryByCountryName(countryName);
		if(existingCountry==null){
			throw new RuntimeException("This country already does not exist");
		}
		else{
			countryDao.delete(existingCountry);
		}
		
		
	}
	@Override
	public void deleteCountryById(int countryId) {
		Optional<Country> existingCountry=countryDao.findCountryByCountryId(countryId);
		if(existingCountry.isEmpty()){
			throw new RuntimeException("This country already does not exist");
		}
		else{
			countryDao.delete(existingCountry.get());
		}


	}
	
	
	@Override
	public City addCityToCountryByName(String countryName, City city) {
		Country existingCountry=countryDao.findCountryByCountryName(countryName);

		if(existingCountry==null) {

			throw new RuntimeException("This country is not found");

			
			
		}
		else {
			City addedCity=cityDao.save(city);
			return addedCity;
			
		}
	}

	@Override
	public City addCityToCountryById(int countryId, City city) {
		Optional<Country> existingCountry=countryDao.findCountryByCountryId(countryId);
		if(existingCountry.isPresent()) {
			City addedCity=cityDao.save(city);
			return addedCity;


		}
		else {
			throw new RuntimeException("This country is not found");

		}
	}


	@Override
	public City updateCitiesInCountryById(int countryId, City city) {
		Optional<Country> existingCountry=countryDao.findCountryByCountryId(countryId);
		Optional<City> existingCity=cityDao.findCityByCityIdOrCityName(city.getCityId(),city.getCityName());
		if(existingCountry.isPresent() && existingCity.isPresent()) {
			
			City updatedCity=cityDao.save(city);
			return updatedCity;
			
		
			
			
		}
		else if(existingCountry.isEmpty()){
			throw new RuntimeException("This country is not found");
			
		}
		else if(existingCity.isEmpty()) {
			throw new RuntimeException("This city is not found");
		}
		else if(existingCountry.isEmpty() && existingCity.isEmpty()) {
			throw new RuntimeException("This city and country is not found");
		}
		return null;
		
	}

	@Override
	public City updateCitiesInCountryByName(String countryName, City city) {
		Country existingCountry=countryDao.findCountryByCountryName(countryName);
		Optional<City> existingCity=cityDao.findCityByCityIdOrCityName(city.getCityId(),city.getCityName());
		if(existingCountry!=null && existingCity.isPresent()) {

			City updatedCity=cityDao.save(city);
			return updatedCity;




		}
		else if(existingCountry==null){
			throw new RuntimeException("This country is not found");

		}
		else if(existingCity.isEmpty()) {
			throw new RuntimeException("This city is not found");
		}
		else if(existingCountry==null && existingCity.isEmpty()) {
			throw new RuntimeException("This city and country is not found");
		}
		return null;

	}

	@Override
	public void deleteCityInCountryByName(String countryName, City city) {
		Country existingCountry=countryDao.findCountryByCountryName(countryName);
		Optional<City> existingCity=cityDao.findCityByCityIdOrCityName(city.getCityId(),city.getCityName());

		if(existingCountry!=null && existingCity.isPresent()) {

			cityDao.delete(existingCity.get());






		}
		else if(existingCountry==null){
			throw new RuntimeException("This country is not found");

		}
		else if(existingCity.isEmpty()) {
			throw new RuntimeException("This city is not found");
		}
		else if(existingCountry==null && existingCity.isEmpty()) {
			throw new RuntimeException("This city and country is not found");
		}



	}

	@Override
	public void deleteCityInCountryById(int countryId, City city) {
		Optional<Country> existingCountry=countryDao.findCountryByCountryId(countryId);
		Optional<City> existingCity=cityDao.findCityByCityIdOrCityName(city.getCityId(),city.getCityName());

		if(existingCountry.isPresent() && existingCity.isPresent()) {

			cityDao.delete(existingCity.get());

		}
		else if(existingCountry.isEmpty()){
			throw new RuntimeException("This country is not found");

		}
		else if(existingCity.isEmpty()) {
			throw new RuntimeException("This city is not found");
		}
		else if(existingCountry.isEmpty() && existingCity.isEmpty()) {
			throw new RuntimeException("This city and country is not found");
		}


	}


	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return countryDao.findAll();
		
	}






	@Override
	public Country findCountryByName(String countryName) {

		return countryDao.findCountryByCountryName(countryName);
	}



	@Override
	public List<City> getCitiesInCountryByName(String countryName) {
		return cityDao.findCitiesByCountryCountryName(countryName);



		
	}

	@Override
	public List<City> getCitiesInCountryById(int countryId) {
		return cityDao.findCitiesByCountryCountryId(countryId);
	}

	@Override
	public Optional<Country> findCountryByCountryId(int countryId) {
		return countryDao.findCountryByCountryId(countryId);
	}

	@Override
	public  Country findCountryByCountryName(String countryName) {
		return countryDao.findCountryByCountryName(countryName);
	}




}
