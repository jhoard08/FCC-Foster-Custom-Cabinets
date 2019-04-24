package fostercustomcabinets.fcc.model;

import javax.persistence.*;
import java.time.LocalDate;

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
}
