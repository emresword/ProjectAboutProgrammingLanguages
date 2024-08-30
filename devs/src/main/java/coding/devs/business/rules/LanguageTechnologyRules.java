package coding.devs.business.rules;

import org.springframework.stereotype.Service;

import coding.devs.core.utilities.exceptions.BusinessException;
import coding.devs.core.utilities.mappers.ModelMapperService;
import coding.devs.dataAccess.abstracts.LanguageTechnologyRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageTechnologyRules {
	private LanguageTechnologyRepository languageTechnologyRepository;
	
	public void existsByName(String name) {
		if(languageTechnologyRepository.existsByName(name)) {
			throw new BusinessException("Language Technology already exists");
		}
		
	}
	
}
