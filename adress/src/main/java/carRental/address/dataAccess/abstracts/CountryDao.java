package carRental.address.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import carRental.address.entities.concretes.Country;

public interface CountryDao extends JpaRepository<Country,Integer> {
	
	
	Optional<Country> findCountryByCountryId(int countryId);

	Country findCountryByCountryName(String countryName);

	void deleteCountryByCountryName(String countryName);


	

	


}
