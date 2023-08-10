package carRental.address.business.abstracts;

import carRental.address.entities.concretes.BuildingNumber;
import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;

import java.util.List;

public interface BuildingNumberService {

    BuildingNumberDTO addBuildingNumber(String streetName, AddBuildingNumberRequest addBuildingNumberRequest);
    void updateBuildingNumberByNo(int buildingNo,AddBuildingNumberRequest addBuildingNumberRequest);
    void updateBuildingNumberById(int buildingNumberId,AddBuildingNumberRequest addBuildingNumberRequest);
    void deleteBuildingNumberByNo(int buildingNo);
    void deleteBuildingNumberById(int buildingNumberId);
    List<BuildingNumber> getAllBuildingNumbers();
    BuildingNumber getBuildingNumberByNo(int buildingNo);
    BuildingNumber getBuildingNumberById(int buildingNumberId);


}
