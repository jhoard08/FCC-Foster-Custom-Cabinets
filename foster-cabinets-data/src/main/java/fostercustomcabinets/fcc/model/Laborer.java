package fostercustomcabinets.fcc.model;

import java.util.Set;

public class Laborer extends Person
{
    private Set<Specialty> specialties;
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
