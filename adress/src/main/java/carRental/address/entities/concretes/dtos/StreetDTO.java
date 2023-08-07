package carRental.address.entities.concretes.dtos;

import carRental.address.entities.concretes.BuildingNumber;
import carRental.address.entities.concretes.City;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StreetDTO {
    private String streetName;
    private int streetId;

    private City city;

    private List<String> buildingNumbers;

}
