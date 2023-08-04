package carRental.address.entities.concretes;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@JsonProperty("id")
	private int streetId;
	
	@Column(name="name")
	@JsonProperty("streetName")
	private String streetName;
  
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id")
	@OnDelete(action= OnDeleteAction.CASCADE)
    private City city;

    //@OneToMany()
	//@JoinColumn(name = "buildingNo_id")
    //private List<BuildingNumber> buildingNumbers;
}
