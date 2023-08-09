package carRental.address.dataAccess.abstracts;

import carRental.address.entities.concretes.BuildingNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildingNumberDao extends JpaRepository<BuildingNumber,Integer> {
    boolean existsByBuildingNo(int buildingNo);
    boolean existsByBuildingNumberId(int buildingNumberId);
    BuildingNumber findByBuildingNo(int buildingNo);
    BuildingNumber findByBuildingNumberId(int buildingNumberId);
    Optional<BuildingNumber> findBuildingNumberByBuildingNumberId(int buildingNumberId);
    Optional<BuildingNumber> findBuildingNumberByBuildingNo(int buildingNo);

}
