package fostercustomcabinets.fcc.model;

import java.time.LocalDate;

public class Use extends BaseEntity {

    private LocalDate date;
    private String description;
    private Material material;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
