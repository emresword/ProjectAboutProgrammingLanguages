package coding.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.devs.entities.concretes.ProgramingLanguage;
//interface can be extended by interface
public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage,Integer> {
	boolean existsByName(String name);
}
