package carRental.address.entities.concretes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Table(name="city")
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor

public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    @JsonProperty("id")
	private int cityId;

    @Column(name="name")
    @JsonProperty("cityname")
	private String cityName;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;



    @JsonManagedReference
    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Street> streets=new ArrayList<>();



}
