package fostercustomcabinets.fcc.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job extends Person {

    @Builder
    public Job(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Material> materials) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.materials = materials;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private Set<Material> materials = new HashSet<>();

}