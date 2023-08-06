package carRental.address.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.CountryDTO;
import carRental.address.entities.concretes.dtos.mappers.CityDTOMapper;
import carRental.address.entities.concretes.dtos.mappers.CountryDTOMapper;
import carRental.address.entities.concretes.dtos.requests.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carRental.address.business.abstracts.CountryService;
import carRental.address.dataAccess.abstracts.CityDao;
import carRental.address.dataAccess.abstracts.CountryDao;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
@Service
@Transactional
public class CountryManager implements CountryService {

	private final CountryDTOMapper countryDTOMapper;
	private final CityDTOMapper cityDTOMapper;
	private final CountryDao countryDao;
	private final CityDao cityDao;

	@Autowired
	public CountryManager(CityDao cityDao,CountryDao countryDao,CountryDTOMapper countryDTOMapper,CityDTOMapper cityDTOMapper) {
		super();
		this.countryDao=countryDao;
		this.cityDao=cityDao;
		this.countryDTOMapper=countryDTOMapper;
		this.cityDTOMapper=cityDTOMapper;


	}




	@Override
	public CountryDTO addCountry(AddCountryRequest addCountryRequest, CountryDTO countryDTO) {
		Optional<Country> existingCountry=countryDao.findCountryByCountryName(addCountryRequest.countryName());
		if(existingCountry.isEmpty()){
			Country newCountry=new Country();
			newCountry.setCountryName(addCountryRequest.countryName());
			countryDao.save(newCountry);

			CountryDTO newCountryDTO=new CountryDTO();
			newCountryDTO.setCountryName(newCountry.getCountryName());
			newCountryDTO.setCountryId(newCountry.getCountryId());
		}
		else{
			throw new RuntimeException("This country already exists.");
		}

		return countryDTO;
	}

	@Override
	public void updateCountryByName(String countryName,CountryUpdateRequest updateRequest,CountryDTO countryDTO) {
		Country country=countryDao.findCountryByCountryName(countryName)
				.orElseThrow(() ->new RuntimeException("Country with this name is not found")
				);

		if (updateRequest.countryName() !=null && !updateRequest.countryName().equals(country.getCountryName())){

			country.setCountryName(updateRequest.countryName());
			country=countryDao.save(country);

			CountryDTO updatedCountryDTO=new CountryDTO();
			updatedCountryDTO.setCountryId(country.getCountryId());
			updatedCountryDTO.setCountryName(country.getCountryName());


		}
		else if (updateRequest.countryName() !=null && updateRequest.countryName().equals(country.getCountryName())) {
			throw new RuntimeException("This country name update is same as before.");

		}
		else{
			throw new RuntimeException("ERROR");
		}

	}

	@Override
	public void updateCountryById(int countryId, CountryUpdateRequest updateRequest,CountryDTO countryDTO) {
		Country country = countryDao.findCountryByCountryId(countryId)
				.orElseThrow(() -> new RuntimeException("Country with this id is not found")
				);

		if (updateRequest.countryName() !=null && !updateRequest.countryName().equals(country.getCountryName())) {
			country.setCountryName(updateRequest.countryName());
			country=countryDao.save(country);

			CountryDTO updatedCountryDTO=new CountryDTO();
			updatedCountryDTO.setCountryName(country.getCountryName());
			updatedCountryDTO.setCountryId(country.getCountryId());

		}
		else if (updateRequest.countryName() !=null && updateRequest.countryName().equals(country.getCountryName())) {
			throw new RuntimeException("This country name update is same as before.");


		}


	}


	@Override
	public void deleteCountryByName(DeleteCountryByNameRequest deleteCountryByNameRequest) {
		if(countryDao.existsCountryByCountryName(deleteCountryByNameRequest.countryName()).isEmpty()){
			throw new EntityNotFoundException("Country with this name is not found.");
		}

		countryDao.deleteCountryByCountryName(deleteCountryByNameRequest.countryName());

	}
	@Override
	public void deleteCountryById(DeleteCountryByIdRequest deleteCountryByIdRequest) {
		if(countryDao.existsCountryByCountryId(deleteCountryByIdRequest.countryId()).isEmpty()){
			throw new EntityNotFoundException("Country with this id [%s] not found".formatted(deleteCountryByIdRequest.countryId())
			);
		}

		countryDao.deleteCountryByCountryId(deleteCountryByIdRequest.countryId());
		}



	
	
	@Override
	public CityDTO addCityToCountryByName(String countryName,CityDTO cityDTO, AddCityToCountryRequest addCityToCountryRequest) {
		Country country=countryDao.findCountryByCountryName(countryName)
				.orElseThrow(() -> new RuntimeException("This country by name is not found"));


		City city=new City();
		city.setCityName(addCityToCountryRequest.cityName());
		city.setCountry(country);

		city=cityDao.save(city);

		CityDTO addedCityDTO=new CityDTO();
		addedCityDTO.setCityName(city.getCityName());
		addedCityDTO.setCountryId(city.getCountry().getCountryId());

		return addedCityDTO;






	}

	@Override
	public CityDTO addCityToCountryById(int countryId,CityDTO cityDTO,AddCityToCountryRequest addCityToCountryRequest) {
		Country country=countryDao.findCountryByCountryId(countryId)
				.orElseThrow(()-> new EntityNotFoundException("This country is not found by id."));

		City city= new City();
		city.setCityName(addCityToCountryRequest.cityName());
		city.setCountry(country);

		city= cityDao.save(city);

		CityDTO addedCityDTO=new CityDTO();
		addedCityDTO.setCityName(city.getCityName());
		addedCityDTO.setCountryId(city.getCountry().getCountryId());

		return addedCityDTO;



		}






	@Override
	public CityDTO updateCitiesInCountryById(int countryId,String cityName,UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO) {
		Country country=countryDao.findCountryByCountryId(countryId)
				.orElseThrow(()-> new RuntimeException("This country by Id does not exist."));

		City cityToUpdate=cityDao.findCityByCityName(cityName)
				.orElseThrow(()->new RuntimeException("This city does not exist."));

		if(!cityToUpdate.getCountry().equals(country)){
			throw new IllegalStateException("City is not in the specified country");
		}
		cityToUpdate.setCityName(updateCityInCountryRequest.cityName());
		cityToUpdate=cityDao.save(cityToUpdate);
		CityDTO updatedCityDTO=new CityDTO();
		updatedCityDTO.setCityName(cityToUpdate.getCityName());
		updatedCityDTO.setCountryId(cityToUpdate.getCityId());

		return updatedCityDTO;

		
	}

	@Override
	public CityDTO updateCitiesInCountryByName(String countryName,UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO,String cityName) {
		Country country=countryDao.findCountryByCountryName(countryName)
				.orElseThrow(()-> new RuntimeException("This country by Id does not exist."));

		City cityToUpdate=cityDao.findCityByCityName(cityName)
				.orElseThrow(()-> new RuntimeException("This city does not exist."));

		if(!cityToUpdate.getCountry().equals(country)){
			throw new IllegalStateException("City is not in the specified country");
		}
		cityToUpdate.setCityName(updateCityInCountryRequest.cityName());
		cityToUpdate=cityDao.save(cityToUpdate);
		CityDTO updatedCityDTO=new CityDTO();
		updatedCityDTO.setCityName(cityToUpdate.getCityName());
		updatedCityDTO.setCountryId(cityToUpdate.getCityId());

		return updatedCityDTO;


	}

	@Override
	public void deleteCityInCountryByName(String countryName, City city,DeleteCityInCountryRequest deleteCityInCountryRequest,CityDTO cityDTO) {
		Country country=countryDao.findCountryByCountryName(countryName)
				.orElseThrow(()->new RuntimeException("This country does not exist."));
		City existingCity=cityDao.findCityByCityIdOrCityName(city.getCityId(),city.getCityName())
				.orElseThrow(()->new RuntimeException("This city does not exist."));

		cityDao.deleteCityByCityNameOrCityId(city.getCityName(),city.getCityId());


	}

	@Override
	public void deleteCityInCountryById(int countryId, City city, DeleteCityInCountryRequest deleteCityInCountryRequest,CityDTO cityDTO) {
		Country country=countryDao.findCountryByCountryId(countryId)
				.orElseThrow(()->new RuntimeException("This country does not exist."));
		City existingCity=cityDao.findCityByCityIdOrCityName(city.getCityId(),city.getCityName())
				.orElseThrow(()->new RuntimeException("This city does not exist."));

		cityDao.deleteCityByCityNameOrCityId(city.getCityName(),city.getCityId());


	}


	@Override
	public List<CountryDTO> getAllCountries() {

		return countryDao.findAll()
				.stream()
				.map(countryDTOMapper)
				.collect(Collectors.toList());
		
	}










	@Override
	public Optional<Country> getCountryById(int countryId) {
		return countryDao.findCountryByCountryId(countryId);


	}

	@Override
	public Optional<CountryDTO> getCountryByName(int countryName) {
		return null;
	}

	@Override
	public List<City> getCitiesInCountryByName(String countryName) {
		Country existingCountry=countryDao.findCountryByCountryName(countryName)
				.orElseThrow(()->new RuntimeException("This country by name is not found"));

		return cityDao.findAll();


	}








	@Override
	public List<City> getCitiesInCountryById(int countryId) {
		Country existingCountry=countryDao.findCountryByCountryId(countryId)
				.orElseThrow(() -> new RuntimeException("This country by id does not exist."));
		return cityDao.findAll();


	}







}
