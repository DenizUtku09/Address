package carRental.address.business.concretes;
import carRental.address.business.abstracts.StreetService;
import carRental.address.dataAccess.abstracts.BuildingNumberDao;
import carRental.address.dataAccess.abstracts.CityDao;
import carRental.address.dataAccess.abstracts.StreetDao;
import carRental.address.entities.concretes.BuildingNumber;
import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;
import carRental.address.entities.concretes.dtos.BuildingNumberDTO;
import carRental.address.entities.concretes.dtos.StreetDTO;
import carRental.address.entities.concretes.dtos.requests.buildingnumber.AddBuildingNumberRequest;
import carRental.address.entities.concretes.dtos.requests.street.AddStreetRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByIdRequest;
import carRental.address.entities.concretes.dtos.requests.street.DeleteStreetByNameRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetManager implements StreetService {
    private final CityDao cityDao;
    private final BuildingNumberDao buildingNumberDao;
    private final StreetDao streetDao;
    @Autowired
    public StreetManager(StreetDao streetDao,CityDao cityDao,BuildingNumberDao buildingNumberDao){
        super();
        this.cityDao=cityDao;
        this.streetDao=streetDao;
        this.buildingNumberDao=buildingNumberDao;
    }
    @Override
    public StreetDTO addStreet(String cityName, AddStreetRequest addStreetRequest) {
        City existingCity=cityDao.findByCityName(cityName)
                .orElseThrow(()-> new EntityNotFoundException("This city does not exist."));
        boolean existingStreet=streetDao.existsByStreetName(addStreetRequest.streetName());
        if(!existingStreet){
            Street addedStreet=new Street();
            addedStreet.setStreetName(addStreetRequest.streetName());
            addedStreet.setCity(existingCity);
            streetDao.save(addedStreet);
            StreetDTO addedStreetDTO=new StreetDTO();
            addedStreetDTO.setStreetId(addedStreet.getStreetId());
            addedStreetDTO.setStreetName(addedStreet.getStreetName());
            addedStreetDTO.setCity(addedStreet.getCity());
            return addedStreetDTO;
        }
        else{
            throw new IllegalStateException("This street you are trying to add already exists.");
        }}
    @Override
    public void updateStreetByName(String streetName, AddStreetRequest addStreetRequest) {
        Street existingStreet=streetDao.findByStreetName(streetName);
        if(addStreetRequest.streetName().equals(existingStreet.getStreetName())){
            throw new RuntimeException("This street name is same as before.");
        }

        else{
            existingStreet.setStreetName(addStreetRequest.streetName());

            StreetDTO updatedStreetDTO=new StreetDTO();
            updatedStreetDTO.setCity(existingStreet.getCity());
            updatedStreetDTO.setStreetId(existingStreet.getStreetId());
            updatedStreetDTO.setStreetName(existingStreet.getStreetName());
            updatedStreetDTO.setBuildingNumbers(existingStreet.getBuildingNumbers());
        }}
    @Override
    public void updateStreetById(int streetId, AddStreetRequest addStreetRequest) {
        Street existingStreet=streetDao.findByStreetId(streetId);
        if(addStreetRequest.streetName().equals(existingStreet.getStreetName())){
            throw new RuntimeException("This street name is same as before.");
        }
        else{
            existingStreet.setStreetName(addStreetRequest.streetName());

            StreetDTO updatedStreetDTO=new StreetDTO();
            updatedStreetDTO.setCity(existingStreet.getCity());
            updatedStreetDTO.setStreetId(existingStreet.getStreetId());
            updatedStreetDTO.setStreetName(existingStreet.getStreetName());
            updatedStreetDTO.setBuildingNumbers(existingStreet.getBuildingNumbers());
        }}
    @Override
    public void deleteStreetByName(DeleteStreetByNameRequest deleteStreetByNameRequest) {
        if(streetDao.existsByStreetName(deleteStreetByNameRequest.streetName())){
            streetDao.deleteByStreetName(deleteStreetByNameRequest.streetName());
        }
        else{
            throw new RuntimeException("This street does not exist by name.");
        }}
    @Override
    public void deleteStreetById(DeleteStreetByIdRequest deleteStreetByIdRequest) {
        if(streetDao.existsByStreetId(deleteStreetByIdRequest.streetId())){
            streetDao.deleteByStreetId(deleteStreetByIdRequest.streetId());
        }
        else{
            throw new RuntimeException("This street does not exist by ID.");
        }}

    @Override
    public BuildingNumberDTO addBuildingNumberToStreetByName(String streetName, AddBuildingNumberRequest addBuildingNumberRequest) {
        Street existingStreet=streetDao.findByStreetName(streetName);
        Optional<BuildingNumber> existingBuildingNumber=buildingNumberDao.findBuildingNumberByBuildingNo(addBuildingNumberRequest.buildingNo());

        if(existingStreet==null){throw new EntityNotFoundException("This street does not exist.");}
        if(existingBuildingNumber.isPresent()){throw new RuntimeException("This building number already exists.");}
        BuildingNumber addedBuildingNumber=new BuildingNumber();
        addedBuildingNumber.setBuildingNo(addBuildingNumberRequest.buildingNo());
        addedBuildingNumber.setStreet(existingStreet);
        buildingNumberDao.save(addedBuildingNumber);
        BuildingNumberDTO addedBuildingNumberDTO=new BuildingNumberDTO();
        addedBuildingNumberDTO.setBuildingNumberId(addedBuildingNumber.getBuildingNumberId());
        addedBuildingNumberDTO.setBuildingNo(addedBuildingNumber.getBuildingNo());
        addedBuildingNumber.setStreet(addedBuildingNumber.getStreet());
        return addedBuildingNumberDTO;}

    @Override
    public BuildingNumberDTO addBuildingNumberToStreetById(int streetId, AddBuildingNumberRequest addBuildingNumberRequest) {
        Street existingStreet=streetDao.findByStreetId(streetId);
        Optional<BuildingNumber> existingBuildingNumber=buildingNumberDao.findBuildingNumberByBuildingNo(addBuildingNumberRequest.buildingNo());
        if(existingStreet==null){throw new EntityNotFoundException("This street does not exist.");}
        if(existingBuildingNumber.isPresent()){throw new RuntimeException("This building number already exists.");}
        BuildingNumber addedBuildingNumber=new BuildingNumber();
        addedBuildingNumber.setBuildingNo(addBuildingNumberRequest.buildingNo());
        addedBuildingNumber.setStreet(existingStreet);
        buildingNumberDao.save(addedBuildingNumber);
        BuildingNumberDTO addedBuildingNumberDTO=new BuildingNumberDTO();
        addedBuildingNumberDTO.setBuildingNumberId(addedBuildingNumber.getBuildingNumberId());
        addedBuildingNumberDTO.setBuildingNo(addedBuildingNumber.getBuildingNo());
        addedBuildingNumber.setStreet(addedBuildingNumber.getStreet());
        return addedBuildingNumberDTO;
    }
}

