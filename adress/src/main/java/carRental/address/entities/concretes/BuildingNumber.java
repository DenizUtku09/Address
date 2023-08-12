package carRental.address.entities.concretes;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name="building_no")
@NoArgsConstructor
@AllArgsConstructor
public class BuildingNumber {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonProperty("id")
	private int buildingNumberId;
	@Column(name="no")
	@JsonProperty("building_number")

	private int buildingNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "street_id")
    private Street street;
}
