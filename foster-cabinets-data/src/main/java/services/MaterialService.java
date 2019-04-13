package services;

import model.Material;

import java.util.Set;

public interface MaterialService
{

	Material findById(Long id);

	Material save(Material material);

	Set<Material> findAll();
}
