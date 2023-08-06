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
	void updateCountryByName(String countryName,CountryUpdateRequest updateRequest,CountryDTO countryDTO);
	void updateCountryById(int countryId, CountryUpdateRequest updateRequest,CountryDTO countryDTO);
	void deleteCountryByName(DeleteCountryByNameRequest deleteCountryByNameRequest);
	void deleteCountryById(DeleteCountryByIdRequest deleteCountryByIdRequest);
	CityDTO addCityToCountryByName(String countryName,CityDTO cityDTO, AddCityToCountryRequest addCityToCountryRequest);
	CityDTO addCityToCountryById(int countryId,CityDTO cityDTO,AddCityToCountryRequest addCityToCountryRequest);



	CityDTO updateCitiesInCountryById(int countryId,String cityName, UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO);
	CityDTO updateCitiesInCountryByName(String countryName,UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO,String cityName);

	void deleteCityInCountryByName(String countryName, DeleteCityInCountryRequest deleteCityInCountryRequest);
	void deleteCityInCountryById(int countryId,DeleteCityInCountryRequest deleteCityInCountryRequest);


	List<CountryDTO> getAllCountries();


	Optional<Country> getCountryById(int countryId);
	Optional<Country> getCountryByName(String countryName);


	List<City> getCitiesInCountryByName(String countryName);
	List<City> getCitiesInCountryById(int countryId);






	
	
	
	

	
	

}
