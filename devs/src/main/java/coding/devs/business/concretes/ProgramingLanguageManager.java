package coding.devs.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.devs.business.abstracts.ProgramingLanguageService;
import coding.devs.business.requests.CreateProgramingLanguageRequest;
import coding.devs.business.requests.UpdateProgramingLanguageRequest;
import coding.devs.business.responses.GetAllProgramingLanguageResponse;
import coding.devs.business.responses.GetByIdProgramingLanguageResponse;
import coding.devs.business.rules.ProgramingLanguageRules;
import coding.devs.core.utilities.mappers.ModelMapperService;
import coding.devs.dataAccess.abstracts.LanguageTechnologyRepository;
import coding.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import coding.devs.entities.concretes.ProgramingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgramingLanguageManager implements ProgramingLanguageService {
	
	private ProgramingLanguageRepository programingLanguageRepository;
	private ModelMapperService modelMapperService;
	private ProgramingLanguageRules programingLanguageRules;
	@Override
	public List<GetAllProgramingLanguageResponse> getAll() {
		List<ProgramingLanguage> programingLanguages = programingLanguageRepository.findAll();
//		List<GetAllProgramingLanguageResponse> programingLanguageResponses = new ArrayList<GetAllProgramingLanguageResponse>();
//		for (ProgramingLanguage programingLanguage : programingLanguages) {
//			GetAllProgramingLanguageResponse responseItem = new GetAllProgramingLanguageResponse();
//			// object will be added List<GetAllProgramingLanguageResponse> this list
//																									
//			responseItem.setId(programingLanguage.getId());
//			responseItem.setName(programingLanguage.getName());
//			responseItem.setVersion(programingLanguage.getVersion());
//			
//			programingLanguageResponses.add(responseItem);
//		}
		List<GetAllProgramingLanguageResponse> getAllProgramingLanguageResponses=programingLanguages.stream()
				.map(programingLanguage -> this.modelMapperService.forResponse()
				.map(programingLanguage,GetAllProgramingLanguageResponse.class)).collect(Collectors.toList());
		
		return getAllProgramingLanguageResponses;
	}
	
	@Override
	public GetByIdProgramingLanguageResponse getById(int id) {
		ProgramingLanguage programingLanguage=this.programingLanguageRepository.findById(id).orElseThrow();
		GetByIdProgramingLanguageResponse getByIdProgramingLanguageResponse
		=this.modelMapperService.forResponse().map(programingLanguage, GetByIdProgramingLanguageResponse.class);
		return getByIdProgramingLanguageResponse;
	}

	@Override
	public void add(CreateProgramingLanguageRequest createProgramingLanguageRequest) {
		this.programingLanguageRules.existsByName(createProgramingLanguageRequest.getName());
		ProgramingLanguage programingLanguage = this.modelMapperService.forRequest().map(createProgramingLanguageRequest,ProgramingLanguage.class);
		this.programingLanguageRepository.save(programingLanguage);
	}


	@Override
	public void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
		ProgramingLanguage programingLanguage = this.modelMapperService.forRequest().map(updateProgramingLanguageRequest,ProgramingLanguage.class);
		this.programingLanguageRepository.save(programingLanguage);//save in here make update because of id
		
	}

	@Override
	public void delete(int id) {
		programingLanguageRepository.deleteById(id);
		
	}



}
