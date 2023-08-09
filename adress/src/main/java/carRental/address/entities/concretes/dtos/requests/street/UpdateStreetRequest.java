package carRental.address.entities.concretes.dtos.requests.street;

import carRental.address.entities.concretes.City;

public record UpdateStreetRequest(String streetName, City city) {
}
