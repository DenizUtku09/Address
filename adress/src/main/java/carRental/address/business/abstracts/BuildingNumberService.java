package carRental.address.business.abstracts;

import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.DeleteBuildingNumberByIdRequest;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.DeleteBuildingNumberByNameRequest;

public interface BuildingNumberService {

    BuildingNumberDTO addBuildingNumber(String streetName, AddBuildingNumberRequest addBuildingNumberRequest);
    void updateBuildingNumberByNo(int buildingNo,AddBuildingNumberRequest addBuildingNumberRequest);
    void updateBuildingNumberById(int buildingNumberId,AddBuildingNumberRequest addBuildingNumberRequest);
    void deleteBuildingNumberByNo(int buildingNo);
    void deleteBuildingNumberById(int buildingNumberId);

}
