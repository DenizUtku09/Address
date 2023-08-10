package carRental.address.api.controllers;

import carRental.address.business.abstracts.BuildingNumberService;
import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/BuildingNumber")
public class BuildingNumberController {
    private final BuildingNumberService buildingNumberService;
    public BuildingNumberController(BuildingNumberService buildingNumberService){
        super();
        this.buildingNumberService=buildingNumberService;
    }
    @PostMapping("/AddBuildingNumber/{streetName}")
    public BuildingNumberDTO addBuildingNumber(@PathVariable String streetName, AddBuildingNumberRequest addBuildingNumberRequest){return buildingNumberService.addBuildingNumber(streetName,addBuildingNumberRequest);}
    @PutMapping("/UpdateBuildingNumberByNo/{buildingNo}")
    public void updateBuildingNumberByNo(@PathVariable int buildingNo,AddBuildingNumberRequest addBuildingNumberRequest){buildingNumberService.updateBuildingNumberByNo(buildingNo,addBuildingNumberRequest);}
    @PutMapping("/UpdateBuildingNumberById/{buildingNumberId}")
    public void updateBuildingNumberById(@PathVariable int buildingNumberId,AddBuildingNumberRequest addBuildingNumberRequest){buildingNumberService.updateBuildingNumberById(buildingNumberId,addBuildingNumberRequest);}
    @DeleteMapping("/DeleteBuildingNumberByName")
    public void deleteBuildingNumberByNo(int buildingNo){buildingNumberService.deleteBuildingNumberByNo(buildingNo);}
    @DeleteMapping("/DeleteBuildingNumberById")
    public void deleteBuildingNumberById(int buildingNumberId){buildingNumberService.deleteBuildingNumberById(buildingNumberId);}

}
