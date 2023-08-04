package carRental.address.business.abstracts;

import java.util.List;
import java.util.Optional;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;


public interface CountryService {
	Country addCountry(Country country);
	Country updateCountryByName(String countryName,Country country);
	Country updateCountryById(int countryId,Country country);
	void deleteCountryByName(String countryName);
	void deleteCountryById(int countryId);
	City addCityToCountryByName(String countryName,City city);
	City addCityToCountryById(int countryId, City city);

	City updateCitiesInCountryById(int countryId, City city);
	City updateCitiesInCountryByName(String countryName,City city);

	void deleteCityInCountryByName(String countryName,City city);
	void deleteCityInCountryById(int countryId,City city);


	List<Country> getAllCountries();


	Country findCountryByName(String countryName);

	List<City> getCitiesInCountryByName(String countryName);
	List<City> getCitiesInCountryById(int countryId);

	Optional<Country> findCountryByCountryId(int countryId);

	Country findCountryByCountryName(String countryName);




	
	
	
	

	
	

}
