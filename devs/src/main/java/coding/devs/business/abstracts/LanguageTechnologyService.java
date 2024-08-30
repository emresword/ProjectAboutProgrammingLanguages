package coding.devs.business.abstracts;

import java.util.List;

import coding.devs.business.requests.CreateLanguageTechnologyRequest;
import coding.devs.business.requests.UpdateLanguageTechnologyRequest;
import coding.devs.business.responses.GetAllLanguageTechnologyResponse;
import coding.devs.business.responses.GetByIdLanguageTechnologyResponse;

public interface LanguageTechnologyService {
	List<GetAllLanguageTechnologyResponse> getAll();

	GetByIdLanguageTechnologyResponse getById(int id);

	void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);

	void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest);

	void delete(int id);

}
