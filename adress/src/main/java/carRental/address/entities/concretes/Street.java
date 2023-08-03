package carRental.address.entities.concretes;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Entity
@Table(name="street")
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class Street {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int streetId;
	
	@Column(name="name")
	private String streetName;
  
    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    //@OneToMany()
	//@JoinColumn(name = "buildingNo_id")
    //private List<BuildingNumber> buildingNumbers;
}
