package carRental.address.business.abstracts;

import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;

public interface BuildingNumberService {

    BuildingNumberDTO addBuildingNumber(String streetName, AddBuildingNumberRequest addBuildingNumberRequest);
    void updateBuildingNumberByNo(int buildingNo,AddBuildingNumberRequest addBuildingNumberRequest);
    void updateBuildingNumberById(int buildingNumberId,AddBuildingNumberRequest addBuildingNumberRequest);

}
