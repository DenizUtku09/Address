package carRental.address.api.controllers;

import java.util.List;
import java.util.Optional;

import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.CountryDTO;
import carRental.address.entities.concretes.dtos.requests.AddCountryRequest;
import carRental.address.entities.concretes.dtos.requests.CountryUpdateRequest;
import carRental.address.entities.concretes.dtos.requests.UpdateCityInCountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import carRental.address.business.abstracts.CountryService;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;

@RestController
@RequestMapping("/api/Country")

public class CountryController {
	private final CountryService countryService;
	
	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService=countryService;
		
		
	}
	
	@GetMapping("/getAll")
	public List<CountryDTO>  getAllCountries() {
		return countryService.getAllCountries();
		
		
	}


	//@GetMapping("/GetCitiesInCountryByName/{countryName}")
	//public List<City> getCitiesInCountryByName(@PathVariable String countryName){
		//return countryService.getCitiesInCountryByName(countryName);
		
	//}
	@GetMapping("/GetCitiesInCountryById/{countryId}")
	public Optional<City> getCitiesInCountryById(@PathVariable int countryId){
		return countryService.getCitiesInCountryById(countryId);
	}
	

	
	@PostMapping("/AddCountry")
	public ResponseEntity<CountryDTO> addCountry(@RequestBody AddCountryRequest addCountryRequest,CountryDTO countryDTO) {
		CountryDTO addedCountry=countryService.addCountry(addCountryRequest,countryDTO);
		return ResponseEntity.ok(addedCountry);
		
	}
	@PutMapping("/UpdateCountryByName/{countryName}")
	public void updateCountryByName(@PathVariable String countryName,@RequestBody CountryUpdateRequest updateRequest){
		countryService.updateCountryByName(countryName, updateRequest);

	}
	/*@PutMapping("/updateCountryById/{countryId}")
	public void updateCountryById(@PathVariable int countryId, CountryUpdateRequest updateRequest){
		countryService.updateCountryById(countryId,updateRequest);
	}
	@PutMapping("/UpdateCitiesInCountryById/{countryId}")
	public CountryDTO updateCitiesInCountryById(@PathVariable int countryId,City city){
		return countryService.updateCitiesInCountryById(countryId,city);
*/

	@PutMapping("/UpdateCitiesInCountryByName/{countryName}/city/{cityName}")
	public CityDTO updateCitiesInCountryByName(@PathVariable String countryName, @RequestBody UpdateCityInCountryRequest updateCityInCountryRequest,CityDTO cityDTO,@PathVariable String cityName){
		return countryService.updateCitiesInCountryByName(countryName,updateCityInCountryRequest,cityDTO,cityName);

	}


/*	@DeleteMapping("/DeleteCountryById/{countryId}")
	public void deleteCountryById(int countryId){
		countryService.deleteCountryById(countryId);
	}

	@DeleteMapping("/DeleteCountryByName/{countryName}")
	public void DeleteCountryByName(@PathVariable String countryName){
		countryService.deleteCountryByName(countryName);
	}
	@DeleteMapping("/DeleteCityInCountryByName/{countryName}")
	public void DeleteCityInCountryByName(@PathVariable String countryName,@RequestBody City city){
		countryService.deleteCityInCountryByName(countryName,city);
	}

	@DeleteMapping("/DeleteCityInCountryById/{countryId}")
	public void DeleteCityInCountryById(@PathVariable int countryId,City city){
		countryService.deleteCityInCountryById(countryId,city);
	}*/





	

}
