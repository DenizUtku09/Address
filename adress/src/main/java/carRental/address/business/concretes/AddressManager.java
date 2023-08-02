package carRental.address.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carRental.address.business.abstracts.AddressService;
import carRental.address.dataAccess.abstracts.AddressDao;
import carRental.address.entities.concretes.Address;
@Service
public class AddressManager implements AddressService {
	private AddressDao addressDao;
	@Autowired
	
	public AddressManager (AddressDao addressDao) {
		super();
		this.addressDao=addressDao;
	}
	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return addressDao.save(address);
	}
	@Override
	public Address updateAddress(Address address) {
		Optional<Address> existingJob=addressDao.findById(address.getAddressId());
		
		if(existingJob.isPresent()) {
			Address updatedJob=addressDao.save(address);
			return updatedJob;
		}
		else {
			throw new RuntimeException("This address is not found.");
		}
		
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return addressDao.findAll();
	}
	@Override
	public void deleteAddressById(int id) {
		
		addressDao.deleteById(id);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Address> findById(int id) {
		// TODO Auto-generated method stub
		return addressDao.findById(id);
		
	}

}
