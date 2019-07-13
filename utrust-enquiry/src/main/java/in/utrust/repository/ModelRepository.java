package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.utrust.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	public Model findByModelId(Integer modelId);
}