package carRental.address.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import carRental.address.business.abstracts.CountryService;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;

@RestController
@RequestMapping("/api/Country")

public class CountryController {
	private CountryService countryService;
	
	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService=countryService;
		
		
	}
	
	@GetMapping("/getAll")
	public List<Country>  getAllCountries() {
		return countryService.getAllCountries();
		
		
	}
	@GetMapping("/FindCountryByName/{countryName}")
	public Country findCountryByName(@PathVariable String countryName){
		return countryService.findCountryByCountryName(countryName);
		
	}
	@GetMapping("/GetCitiesInCountryByName/{countryName}")
	public List<City> getCitiesInCountryByName(@PathVariable String countryName){
		return countryService.getCitiesInCountryByName(countryName);
		
	}
	@GetMapping("/GetCitiesInCountryById/{countryId}")
	public List<City> getCitiesInCountryById(@PathVariable int countryId){
		return countryService.getCitiesInCountryById(countryId);
	}
	
	@GetMapping("/FindCountryById/{id}")
	public Optional<Country> findCountryById(@PathVariable int id){
		return countryService.findCountryByCountryId(id);
	}
	
	@PostMapping("/AddCountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
		
	}
	@PutMapping("/UpdateCountryByName/{countryName}")
	public Country updateCountryByName(@PathVariable String countryName,@RequestBody Country country){
		return countryService.updateCountryByName(countryName,country);

	}
	@PutMapping("/updateCountryById/{countryId}")
	public Country updateCountryById(@PathVariable int countryId,Country country){
		return countryService.updateCountryById(countryId,country);
	}
	@PutMapping("/UpdateCitiesInCountryById/{countryId}")
	public City updateCitiesInCountryById(@PathVariable int countryId,City city){
		return countryService.updateCitiesInCountryById(countryId,city);

	}
	@PutMapping("/UpdateCitiesInCountryByName/{countryName}")
	public City updateCitiesInCountryByName(@PathVariable String countryName,City city){
		return countryService.updateCitiesInCountryByName(countryName,city);

	}


	@DeleteMapping("/DeleteCountryById/{countryId}")
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
	}





	

}
