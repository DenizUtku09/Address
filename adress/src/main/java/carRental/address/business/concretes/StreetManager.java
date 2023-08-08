package carRental.address.business.concretes;

import carRental.address.business.abstracts.StreetService;
import carRental.address.dataAccess.abstracts.StreetDao;
import carRental.address.entities.concretes.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetManager implements StreetService {
    private final StreetDao streetDao;
    @Autowired
    public StreetManager(StreetDao streetDao){
        super();
        this.streetDao=streetDao;

    }


    @Override
    public Street addStreet(Street street) {
        return streetDao.save(street);

    }

    @Override
    public List<Street> getAllStreets() {
        return streetDao.findAll();
    }
}

