package carRental.address.business.abstracts;
import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.StreetDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;
import carRental.address.entities.concretes.dtos.requests.street.AddStreetRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByIdRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByNameRequest;
public interface StreetService {
    StreetDTO addStreet(String cityName, AddStreetRequest addStreetRequest);
    void updateStreetByName(String streetName, AddStreetRequest addStreetRequest);
    void updateStreetById(int streetId,AddStreetRequest addStreetRequest);
    void deleteStreetByName(DeleteStreetByNameRequest deleteStreetByNameRequest);
    void deleteStreetById(DeleteStreetByIdRequest deleteStreetByIdRequest);
    BuildingNumberDTO addBuildingNumberToStreetByName(String streetName, AddBuildingNumberRequest addBuildingNumberRequest);

    BuildingNumberDTO addBuildingNumberToStreetById(int streetId,AddBuildingNumberRequest addBuildingNumberRequest);





}
