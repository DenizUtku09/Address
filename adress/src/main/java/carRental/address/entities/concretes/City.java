package carRental.address.entities.concretes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="city")

public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    @JsonProperty("id")
	private int cityId;

    @Column(name="name")
    @JsonProperty("cityname")
	private String cityName;


    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany
    @JoinColumn(name="street_id")
    private List<Street> streets;
}
