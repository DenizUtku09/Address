package carRental.address.dataAccess.abstracts;

import carRental.address.entities.concretes.dtos.CountryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import carRental.address.entities.concretes.Country;

import java.util.Optional;

public interface CountryDao extends JpaRepository<Country,Integer> {


	Optional<Country> findCountryByCountryId(int countryId);

	Optional<Country> findCountryByCountryName(String countryName);

	void deleteCountryByCountryName(String countryName);
	void deleteCountryByCountryId(int countryId);


	Optional<Country> existsCountryByCountryName(String countryName);
	Optional<Country> existsCountryByCountryId(int countryId);

}
