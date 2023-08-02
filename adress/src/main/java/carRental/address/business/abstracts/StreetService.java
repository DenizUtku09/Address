package carRental.address.business.abstracts;

import carRental.address.entities.concretes.Street;

import java.util.List;

public interface StreetService {
    Street addStreet(Street street);
    List<Street> getAllStreets();

}
