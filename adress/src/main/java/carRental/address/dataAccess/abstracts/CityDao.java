package carRental.address.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;

public interface CityDao extends JpaRepository<City, Integer>{

	List<City> findAllByCountry(Country country);
;

	Optional<City> findCityByCityId(int cityId);

	List<City> findCitiesByCountryCountryName(String countryName);
	List<City> findCitiesByCountryCountryId(int countryId);
	Optional<City> findCityByCityIdOrCityName(int cityId, String cityName);
	Optional<City> findCityByCityName(String cityName);




	void deleteCityByCityNameOrCityId(String cityName,int cityId);
	void deleteCityByCityName(String cityName);
	void deleteCityByCityId(int cityId);












	
}
