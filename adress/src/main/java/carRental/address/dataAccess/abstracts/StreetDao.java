package carRental.address.dataAccess.abstracts;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StreetDao extends JpaRepository<Street,Integer> {

    List<Street> findByCityAndStreetId(City city,int streetId);

    List<Street> findStreetsByCityCityName(String cityName);
    List<Street> findStreetsByCityCityId(int cityId);


    Optional<Street> findStreetByStreetIdOrStreetName(int streetId, String streetName);

    void deleteStreetByStreetIdOrStreetName(int streetId,String streetName);




}
