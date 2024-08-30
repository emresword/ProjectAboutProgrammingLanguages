package coding.devs.business.abstracts;

import java.util.List;

import coding.devs.business.requests.CreateProgramingLanguageRequest;
import coding.devs.business.requests.UpdateProgramingLanguageRequest;
import coding.devs.business.responses.GetAllProgramingLanguageResponse;
import coding.devs.business.responses.GetByIdProgramingLanguageResponse;
import coding.devs.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageService {
	List<GetAllProgramingLanguageResponse> getAll();

	GetByIdProgramingLanguageResponse getById(int id);

	void add(CreateProgramingLanguageRequest createProgramingLanguageRequest);

	void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest);
	
	void delete(int id);
}
