package carRental.address.dataAccess.abstracts;

import java.util.Optional;

import carRental.address.entities.concretes.dtos.CityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import carRental.address.entities.concretes.City;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CityDao extends JpaRepository<City, Integer>{


	City findCityByCityId(int cityId);

	Optional<CityDTO> findCitiesByCountryCountryName(String countryName);
	Optional<City> findCitiesByCountryCountryId (int countryId);


	Optional<City> findCityByCityIdOrCityName(int cityId, String cityName);
	City findCityByCityName(String cityName);





	void deleteCityByCityNameOrCityId(String cityName,int cityId);
	void deleteCityByCityName(String cityName);
	void deleteCityByCityId(int cityId);


}
