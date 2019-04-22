package fostercustomcabinets.fcc.model;

import java.util.Set;

public class Job extends Person {
    private Set<Material> materials;

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
}
