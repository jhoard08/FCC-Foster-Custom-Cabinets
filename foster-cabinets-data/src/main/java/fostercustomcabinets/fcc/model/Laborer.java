package fostercustomcabinets.fcc.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "laborers")
public class Laborer extends Person
{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "labor_specialities", joinColumns = @JoinColumn(name = "labor_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Specialty> specialties = new HashSet<>();

    @Column(name = "pay")
    private long pay;

}
