package carRental.address.entities.concretes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Entity
@Table(name="country")
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	@JsonProperty("id")
	private int countryId;
	@Column(name="name")
	@JsonProperty("countryName")
	private String countryName;
	

    //@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "city_id")
    //private List<City> cities=new ArrayList<>();
 
}