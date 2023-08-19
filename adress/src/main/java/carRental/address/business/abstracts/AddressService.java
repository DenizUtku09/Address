package carRental.address.business.abstracts;

import carRental.address.entities.concretes.dtos.requests.address.AddAddressRequest;

import carRental.address.entities.concretes.Address;
import carRental.address.entities.concretes.dtos.requests.address.DeleteAddressByIdRequest;

public interface AddressService {
	Address addAddress(AddAddressRequest addAddressRequest);
	Address getAddressById(int addressId);
	void deleteAddress(DeleteAddressByIdRequest deleteAddressByIdRequest);



	

		
	
	

}
