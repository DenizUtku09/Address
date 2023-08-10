package carRental.address.entities.concretes.dtos;

import carRental.address.entities.concretes.Street;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingNumberDTO {
    private int buildingNo;
    private int buildingNumberId;
    private Street street;

}
