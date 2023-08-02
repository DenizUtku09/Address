package carRental.address.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carRental.address.dataAccess.abstracts.AddressDao;
import carRental.address.entities.concretes.Address;

public interface AddressService {
	Address addAddress(Address address);
	Address updateAddress(Address address);
	void deleteAddressById(int id);
	List<Address> getAll();
	Optional<Address> findById(int id);
	

	

		
	
	

}
