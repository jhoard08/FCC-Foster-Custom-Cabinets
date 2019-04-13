package services;

import model.Laborer;

import java.util.Set;

public interface LaborerService
{
	Laborer findById(Long id);

	Laborer save(Laborer laborer);

	Set<Laborer> findAll();
}
