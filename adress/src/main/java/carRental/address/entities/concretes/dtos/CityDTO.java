package carRental.address.entities.concretes.dtos;
import carRental.address.entities.concretes.Country;
import lombok.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CityDTO {
    private String cityName;
    private int cityId;
    private Country country;
    private List<String> streets;
}
