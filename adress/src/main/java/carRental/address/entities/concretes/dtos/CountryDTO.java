package carRental.address.entities.concretes.dtos;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    private String countryName;
    private int countryId;
    private List<String> cities;

}
