package fostercustomcabinets.fcc.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "materials")
public class Material extends BaseEntity
{
	@Builder
	public Material(Long id, String name, MaterialType materialType, Job job, LocalDate date, Set<Use> use) {
		super(id);
		this.name = name;
		this.materialType = materialType;
		this.job = job;
		this.date = date;

		if(use == null || use.size() > 0){
			this.use = use;
		}
	}

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private MaterialType materialType;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@Column(name = "job_date")
	private LocalDate date;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
	private Set<Use> use = new HashSet<>();


}
