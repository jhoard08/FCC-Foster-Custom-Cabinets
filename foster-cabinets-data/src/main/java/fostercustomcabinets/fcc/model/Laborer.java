package fostercustomcabinets.fcc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
        this.pay = pay;
    }
}
