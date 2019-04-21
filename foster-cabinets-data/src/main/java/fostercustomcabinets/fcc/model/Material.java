package fostercustomcabinets.fcc.model;

import java.time.LocalDate;

public class Material extends BaseEntity
{
	private MaterialType materialType;
	private Job job;
	private LocalDate date;

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
