package carRental.address.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="building_no")
public class BuildingNumber {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int buildingNumberId;
	@Column(name="no")
	private int buildingNo;
    @ManyToOne()
	@JoinColumn(name = "street_id")
    private Street street;
}
