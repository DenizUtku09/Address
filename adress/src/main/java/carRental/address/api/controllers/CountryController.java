package carRental.address.api.controllers;

import java.util.List;
import java.util.Optional;


import carRental.address.entities.concretes.Country;
import carRental.address.entities.concretes.dtos.CityDTO;
import carRental.address.entities.concretes.dtos.CountryDTO;
import carRental.address.entities.concretes.dtos.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import carRental.address.business.abstracts.CountryService;
import carRental.address.entities.concretes.City;



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
	@GetMapping("/getCountryByName/{countryName}")
	public Optional<Country> getCountryByName(String countryName){
		return countryService.getCountryByName(countryName);
	}

	@GetMapping("/getCountryById/{countryId}")
	public Optional<Country> getCountryById(int countryId){
		return countryService.getCountryById(countryId);
	}


	@GetMapping("/GetCitiesInCountryByName/{countryName}")
	@ResponseBody
	public List<City> getCitiesInCountryByName(@PathVariable String countryName){
		return countryService.getCitiesInCountryByName(countryName);
		
	}
	@GetMapping("/GetCitiesInCountryById/{countryId}")
	@ResponseBody
	public List<City> getCitiesInCountryById(@PathVariable int countryId){
		return countryService.getCitiesInCountryById(countryId);
	}
	

	
	@PostMapping("/AddCountry")
	public ResponseEntity<CountryDTO> addCountry(@RequestBody AddCountryRequest addCountryRequest,CountryDTO countryDTO) {
		CountryDTO addedCountry=countryService.addCountry(addCountryRequest,countryDTO);
		return ResponseEntity.ok(addedCountry);
		
	}
	@PostMapping("/AddCitiesToCountryById/{countryId}")
	public ResponseEntity<CityDTO> addCityToCountryById(@PathVariable int countryId,CityDTO cityDTO,@RequestBody AddCityToCountryRequest addCityToCountryRequest){
		CityDTO addedCity=countryService.addCityToCountryById(countryId,cityDTO,addCityToCountryRequest);
		return ResponseEntity.ok(addedCity);
	}
	@PostMapping("/AddCitiesToCountryByName/{countryName}")
	public ResponseEntity<CityDTO> addCityToCountryByName(@PathVariable String countryName,CityDTO cityDTO,@RequestBody AddCityToCountryRequest addCityToCountryRequest){
		CityDTO addedCity=countryService.addCityToCountryByName(countryName,cityDTO,addCityToCountryRequest);
		return ResponseEntity.ok(addedCity);
	}
	@PutMapping("/UpdateCountryByName/{countryName}")
	@ResponseBody
	public void updateCountryByName(@PathVariable String countryName,@RequestBody CountryUpdateRequest updateRequest,CountryDTO countryDTO){
		countryService.updateCountryByName(countryName, updateRequest,countryDTO);

	}
	@PutMapping("/updateCountryById/{countryId}")
	public void updateCountryById(@PathVariable int countryId,@RequestBody CountryUpdateRequest updateRequest,CountryDTO countryDTO){
		countryService.updateCountryById(countryId,updateRequest,countryDTO);
	}
    @PutMapping("/UpdateCitiesInCountryById/{countryId}/city/{cityName}")
	public CityDTO updateCitiesInCountryById(@PathVariable int countryId,@PathVariable String cityName,@RequestBody UpdateCityInCountryRequest updateCityInCountryRequest, CityDTO cityDTO) {
		return countryService.updateCitiesInCountryById(countryId,cityName,updateCityInCountryRequest,cityDTO);
	}

	@PutMapping("/UpdateCitiesInCountryByName/{countryName}/city/{cityName}")
	public CityDTO updateCitiesInCountryByName (@PathVariable String countryName, @RequestBody UpdateCityInCountryRequest updateCityInCountryRequest, CityDTO
		cityDTO, @PathVariable String cityName){
			return countryService.updateCitiesInCountryByName(countryName, updateCityInCountryRequest, cityDTO, cityName);

		}


    @DeleteMapping("/DeleteCountryById")
	public void deleteCountryById(@RequestBody DeleteCountryByIdRequest deleteCountryByIdRequest){
		countryService.deleteCountryById(deleteCountryByIdRequest);
	}

	@DeleteMapping("/DeleteCountryByName")
	public void DeleteCountryByName(@RequestBody DeleteCountryByNameRequest deleteCountryByNameRequest){
		countryService.deleteCountryByName(deleteCountryByNameRequest);
	}
	@DeleteMapping("/DeleteCityInCountryByName/{countryName}")
	public void DeleteCityInCountryByName(@PathVariable String countryName,@RequestBody DeleteCityInCountryRequest deleteCityInCountryRequest){
		countryService.deleteCityInCountryByName(countryName,deleteCityInCountryRequest);
	}

	@DeleteMapping("/DeleteCityInCountryById/{countryId}")
	public void DeleteCityInCountryById(@PathVariable int countryId,@RequestBody DeleteCityInCountryRequest deleteCityInCountryRequest){
		countryService.deleteCityInCountryById(countryId,deleteCityInCountryRequest);
	}






	

}
