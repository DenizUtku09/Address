package carRental.address.entities.concretes.dtos.mappers;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;
import carRental.address.entities.concretes.dtos.CityDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class CityDTOMapper implements Function<City, CityDTO> {
    @Override
    public CityDTO apply(City city) {
        return new CityDTO(
                city.getCityName(),
                city.getCityId(),
                city.getStreets()
                        .stream()
                        .map(Street::getStreetName)
                        .collect(Collectors.toList()
                        ));
    }
}
