package carRental.address.dataAccess.abstracts;

import carRental.address.entities.concretes.City;
import carRental.address.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Component
public interface StreetDao extends JpaRepository<Street,Integer> {

    List<Street> findByCityAndStreetId(City city,int streetId);

    List<Street> findStreetsByCityCityName(String cityName);
    List<Street> findStreetsByCityCityId(int cityId);


    Optional<Street> findStreetByStreetIdOrStreetName(int streetId, String streetName);

    void deleteStreetByStreetIdOrStreetName(int streetId,String streetName);
    Optional<Street> findStreetByStreetName(String streetName);
    Street findByStreetName(String streetName);
    Street findByStreetId(int streetId);
    boolean existsByStreetName(String streetName);
    boolean existsByStreetId(int streetId);
    Street findStreetByStreetId(int streetId);
    void deleteByStreetName(String streetName);
    void deleteByStreetId(int streetId);






}
