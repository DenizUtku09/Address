package carRental.address.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import carRental.address.entities.concretes.Address;
import carRental.address.entities.concretes.Country;


public interface AddressDao extends JpaRepository<Address, Integer> {

	
	

}
