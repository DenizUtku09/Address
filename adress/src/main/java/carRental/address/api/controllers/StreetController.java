package carRental.address.api.controllers;

import carRental.address.business.abstracts.StreetService;
import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.StreetDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;
import carRental.address.entities.concretes.dtos.requests.street.AddStreetRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByIdRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByNameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    }
