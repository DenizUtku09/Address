package carRental.address.business.abstracts;

import java.util.List;
import java.util.Optional;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.CountryDTO;
import carRental.address.entities.concretes.dtos.requests.*;


public interface CountryService {
	CountryDTO addCountry(AddCountryRequest addCountryRequest, CountryDTO countryDTO);
	void updateCountryByName(String countryName,CountryUpdateRequest updateRequest);
	void updateCountryById(int countryId, CountryUpdateRequest updateRequest);
	void deleteCountryByName(String countryName);
	void deleteCountryById(int countryId);
	CityDTO addCityToCountryByName(String countryName,CityDTO cityDTO, AddCityToCountryRequest addCityToCountryRequest);
	CityDTO addCityToCountryById(int countryId,CityDTO cityDTO,AddCityToCountryRequest addCityToCountryRequest);



	CityDTO updateCitiesInCountryById(int countryId, City city, UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO);
	CityDTO updateCitiesInCountryByName(String countryName,UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO,String cityName);

	void deleteCityInCountryByName(String countryName, City city, DeleteCityInCountryRequest deleteCityInCountryRequest,CityDTO cityDTO);
	void deleteCityInCountryById(int countryId,City city,DeleteCityInCountryRequest deleteCityInCountryRequest,CityDTO cityDTO);


	List<CountryDTO> getAllCountries();


	Optional<Country> getCountryById(int countryId);
	Optional<CountryDTO> getCountryByName(int countryName);


	List<CountryDTO> getCitiesInCountryByName(String countryName);
	Optional<City> getCitiesInCountryById(int countryId);






	
	
	
	

	
	

}
