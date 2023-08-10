package carRental.address.api.controllers;

import carRental.address.business.abstracts.StreetService;
import carRental.address.entities.concretes.BuildingNumber;
import carRental.address.entities.concretes.Street;
import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.StreetDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.DeleteBuildingNumberByIdRequest;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.DeleteBuildingNumberByNameRequest;
import carRental.address.entities.concretes.dtos.requests.street.AddStreetRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByIdRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByNameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Street")
public class StreetController {

    private final StreetService streetService;
    @Autowired
    public StreetController(StreetService streetService){
        super();
        this.streetService=streetService;
    }
    @PostMapping("/AddStreet/{cityName}")
    public ResponseEntity<StreetDTO> AddStreet(@PathVariable String cityName, AddStreetRequest addStreetRequest){return ResponseEntity.ok(streetService.addStreet(cityName,addStreetRequest));}
    @PutMapping("/UpdateStreetByName/{streetName}")
    public void updateStreetByName(@PathVariable String streetName, AddStreetRequest addStreetRequest){streetService.updateStreetByName(streetName,addStreetRequest);}
    @PutMapping("/UpdateStreetById/{streetId}")
    public void updateStreetById(@PathVariable int streetId,AddStreetRequest addStreetRequest){streetService.updateStreetById(streetId,addStreetRequest);}
    @DeleteMapping("/DeleteStreetById")
    public void deleteStreetById(DeleteStreetByIdRequest deleteStreetByIdRequest){streetService.deleteStreetById(deleteStreetByIdRequest);}
    @DeleteMapping("/DeleteStreetByName")
    public void deleteStreetByName(DeleteStreetByNameRequest deleteStreetByNameRequest){streetService.deleteStreetByName(deleteStreetByNameRequest);}
    @PostMapping("/AddBuildingNumberToStreetByName/{streetName}")
    public ResponseEntity<BuildingNumberDTO> addBuildingNumberToStreetByName(@PathVariable String streetName, AddBuildingNumberRequest addBuildingNumberRequest){return ResponseEntity.ok(streetService.addBuildingNumberToStreetByName(streetName,addBuildingNumberRequest));}
    @PostMapping("/AddBuildingNumberToStreetById/{streetId}")
    public ResponseEntity<BuildingNumberDTO> addBuildingNumberToStreetById(@PathVariable int streetId,AddBuildingNumberRequest addBuildingNumberRequest){return ResponseEntity.ok(streetService.addBuildingNumberToStreetById(streetId,addBuildingNumberRequest));}
    @PutMapping("/UpdateBuildingNumberInStreetByName/{streetName}/building-number/{buildingNo}")
    public ResponseEntity<BuildingNumberDTO> updateBuildingNumberInStreetByName(@PathVariable String streetName,@PathVariable int buildingNo,AddBuildingNumberRequest addBuildingNumberRequest){return ResponseEntity.ok(streetService.updateBuildingNumberInStreetByName(streetName,buildingNo,addBuildingNumberRequest));}
    @PutMapping("/UpdateBuildingNumberInStreetById/{streetId}/building-number/{buildingNumberId}")
    public ResponseEntity<BuildingNumberDTO> updateBuildingNumberInStreetByName(@PathVariable int streetId,@PathVariable int buildingNumberId,AddBuildingNumberRequest addBuildingNumberRequest){return ResponseEntity.ok(streetService.updateBuildingNumberInStreetById(streetId,buildingNumberId,addBuildingNumberRequest));}
    @DeleteMapping("/DeleteBuildingNumberInStreetByName/{streetName}")
    public void deleteBuildingNumberInStreetByName(@PathVariable String streetName, DeleteBuildingNumberByNameRequest deleteBuildingNumberByNameRequest){streetService.deleteBuildingNumberInStreetByName(streetName,deleteBuildingNumberByNameRequest);}
    @DeleteMapping("/DeleteBuildingNumberInStreetById/{streetId}")
    public void deleteBuildingNumberInStreetById(@PathVariable int streetId, DeleteBuildingNumberByIdRequest deleteBuildingNumberByIdRequest){streetService.deleteBuildingNumberInStreetById(streetId,deleteBuildingNumberByIdRequest);}
    @GetMapping("/GetAllStreets")
    public List<StreetDTO> getAllStreets(){return streetService.getAllStreets();}
    @GetMapping("/GetStreetByName/{streetName}")
    public Street getStreetByName(@PathVariable String streetName){return streetService.getStreetByName(streetName);}
    @GetMapping("/GetStreetById/{streetId}")
    public Street getStreetById(@PathVariable int streetId){return streetService.getStreetById(streetId);}
    @GetMapping("/GetBuildingNumbersInStreetByName/{streetName}")
    public List<BuildingNumber> getBuildingNumbersInStreetByName(@PathVariable String streetName){return streetService.getBuildingNumbersInStreetByName(streetName);}
    @GetMapping("/GetBuildingNumbersInStreetById/{streetId}")
    public List<BuildingNumber> getBuildingNumbersInStreetById(@PathVariable int streetId){return streetService.getBuildingNumbersInStreetById(streetId);}
}
