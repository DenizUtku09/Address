package carRental.address.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryWithCityDto {
	private int id;
	private String countryName;
	private String cityName;

	
}
