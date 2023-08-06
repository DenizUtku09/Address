package carRental.address.dataAccess.abstracts;

import java.util.Optional;

import carRental.address.entities.concretes.dtos.CityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import carRental.address.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{


	Optional<City> findCityByCityId(int cityId);

	Optional<CityDTO> findCitiesByCountryCountryName(String countryName);
	Optional<City> findCitiesByCountryCountryId (int countryId);

	Optional<City> findCityByCityIdOrCityName(int cityId, String cityName);
	Optional<City> findCityByCityName(String cityName);




	void deleteCityByCityNameOrCityId(String cityName,int cityId);
	void deleteCityByCityName(String cityName);
	void deleteCityByCityId(int cityId);


}
