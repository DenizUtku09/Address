package carRental.address.api.controllers;
import carRental.address.business.abstracts.AddressService;
import carRental.address.entities.concretes.dtos.requests.address.AddAddressRequest;
import carRental.address.entities.concretes.dtos.requests.address.DeleteAddressByIdRequest;
import org.springframework.web.bind.annotation.*;
import carRental.address.entities.concretes.Address;
@RestController
@RequestMapping(name="/api/address")
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService){
        super();
        this.addressService=addressService;
    }
    @PostMapping("/AddAddress")
    public Address addAddress(@RequestBody AddAddressRequest addAddressRequest){
        return addressService.addAddress(addAddressRequest);

    }
    @GetMapping("/GetAddressById/{addressId}")
    public Address getAddressById(@PathVariable int addressId){return addressService.getAddressById(addressId);}

    @DeleteMapping("/DeleteAddress")
    public void deleteAddress(DeleteAddressByIdRequest deleteAddressByIdRequest){addressService.deleteAddress(deleteAddressByIdRequest);}


	
	

}
