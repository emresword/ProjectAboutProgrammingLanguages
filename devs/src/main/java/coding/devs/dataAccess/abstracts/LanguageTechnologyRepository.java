package coding.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.devs.entities.concretes.LanguageTechnology;

public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology,Integer> {
	boolean existsByName(String name);
}
