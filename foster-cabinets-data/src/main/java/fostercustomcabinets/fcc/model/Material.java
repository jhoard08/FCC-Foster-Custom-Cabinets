package fostercustomcabinets.fcc.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MaterialType getMaterialType()
	{
		return materialType;
	}

	public void setMaterialType(MaterialType materialType)
	{
		this.materialType = materialType;
	}

	public Job getJob()
	{
		return job;
	}

	public void setJob(Job job)
	{
		this.job = job;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public Set<Use> getUse() {
		return use;
	}

	public void setUse(Set<Use> use) {
		this.use = use;
	}
}
