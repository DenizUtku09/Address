package carRental.address.entities.concretes.dtos;

import java.util.List;

public record CityWithStreetsDTO(int cityId,
                      String cityName,
                      List<String> streets){
}
