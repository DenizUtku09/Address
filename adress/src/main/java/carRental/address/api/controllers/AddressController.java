package carRental.address.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carRental.address.business.abstracts.AddressService;
import carRental.address.entities.concretes.Address;

@RestController
@RequestMapping(name="/api/address")
public class AddressController {
	
	private AddressService addressService;
	@Autowired
	public AddressController(AddressService addressService) {
		super();
		this.addressService=addressService;
	
	}
	@PostMapping("/addAddress")
	
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		Address savedAddress=addressService.addAddress(address);
		
		return new ResponseEntity<Address>(savedAddress, HttpStatus.OK);
		
		 
	}
	
	
	
	
	

}
