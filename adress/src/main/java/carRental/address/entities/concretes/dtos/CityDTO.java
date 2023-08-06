package carRental.address.entities.concretes.dtos;


import carRental.address.entities.concretes.Country;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Service;


import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class CityDTO {
    private String cityName;
    private int cityId;
    private String countryName;
    private int countryId;
    private List<String> streets;


    public <R> CityDTO(String cityName, int cityId, Country country, R collect) {
    }

}
