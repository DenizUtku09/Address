package carRental.address.business.abstracts;

import carRental.address.entities.concretes.dtos.requests.address.AddAddressRequest;

import carRental.address.entities.concretes.Address;

public interface AddressService {
	Address addAddress(AddAddressRequest addAddressRequest);
	Address getAddressById(int addressId);


	

		
	
	

}
