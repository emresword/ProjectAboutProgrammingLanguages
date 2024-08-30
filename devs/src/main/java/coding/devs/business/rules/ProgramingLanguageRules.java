package coding.devs.business.rules;

import coding.devs.dataAccess.abstracts.LanguageTechnologyRepository;
import coding.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import coding.devs.core.utilities.exceptions.BusinessException;
@Service
@AllArgsConstructor
public class ProgramingLanguageRules {
	private ProgramingLanguageRepository programingLanguageRepository;
	
	public void existsByName(String name) {
		if(this.programingLanguageRepository.existsByName(name)) {
			throw new BusinessException("ProgramingLanguage already exists");
		}
	}
}
