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
@Builder
@Entity
@Table(name = "materials")
public class Material extends BaseEntity
{

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
