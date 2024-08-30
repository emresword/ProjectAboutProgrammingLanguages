package coding.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import coding.devs.business.abstracts.LanguageTechnologyService;
import coding.devs.business.requests.CreateLanguageTechnologyRequest;
import coding.devs.business.requests.UpdateLanguageTechnologyRequest;
import coding.devs.business.responses.GetAllLanguageTechnologyResponse;
import coding.devs.business.responses.GetByIdLanguageTechnologyResponse;
import coding.devs.business.rules.LanguageTechnologyRules;
import coding.devs.core.utilities.mappers.ModelMapperService;
import coding.devs.dataAccess.abstracts.LanguageTechnologyRepository;
import coding.devs.entities.concretes.LanguageTechnology;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class LanguageTechnologyManager implements LanguageTechnologyService {
	private ModelMapperService modelMapperService;
	private LanguageTechnologyRepository languageTechnologyRepository;
	private LanguageTechnologyRules languageTechnologyRules; 
	
	@Override
	public List<GetAllLanguageTechnologyResponse> getAll() {
		List<LanguageTechnology> languageTechnologies = this.languageTechnologyRepository.findAll();
//		List<GetAllLanguageTechnologyResponse> getAllLanguageTechnologyResponses = new ArrayList<GetAllLanguageTechnologyResponse>();
//		for (LanguageTechnology languageTechnology : languageTechnologies) {
//			GetAllLanguageTechnologyResponse getAllLanguageTechnologyResponse = new GetAllLanguageTechnologyResponse();
//			
//			getAllLanguageTechnologyResponse.setId(languageTechnology.getId());
//			getAllLanguageTechnologyResponse.setName(languageTechnology.getName());
//			getAllLanguageTechnologyResponse.setVersion(languageTechnology.getVersion());
//			
//			getAllLanguageTechnologyResponses.add(getAllLanguageTechnologyResponse);
//		}
		List<GetAllLanguageTechnologyResponse> getAllLanguageTechnologyResponses=languageTechnologies.stream()
				.map(languageTechnology -> this.modelMapperService.forResponse()
				.map(languageTechnology, GetAllLanguageTechnologyResponse.class)).collect(Collectors.toList());
		return getAllLanguageTechnologyResponses;
	}

	@Override
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		this.languageTechnologyRules.existsByName(createLanguageTechnologyRequest.getName());
		LanguageTechnology languageTechnology =this.modelMapperService.forRequest().map(createLanguageTechnologyRequest,LanguageTechnology.class);
		
//		languageTechnology.setName(createLanguageTechnologyRequest.getName());
//		languageTechnology.setVersion(createLanguageTechnologyRequest.getVersion());
//		
		this.languageTechnologyRepository.save(languageTechnology);

	}

	@Override
	public GetByIdLanguageTechnologyResponse getById(int id) {
		LanguageTechnology languageTechnology=this.languageTechnologyRepository.findById(id).orElseThrow();
		GetByIdLanguageTechnologyResponse getByIdLanguageTechnoloyResponse=this.modelMapperService.forResponse().map(languageTechnology,GetByIdLanguageTechnologyResponse.class);
		return getByIdLanguageTechnoloyResponse;
	}

	@Override
	public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		LanguageTechnology languageTechnology=this.modelMapperService.forRequest().map(updateLanguageTechnologyRequest, LanguageTechnology.class);
		this.languageTechnologyRepository.save(languageTechnology);
		
	}

	@Override
	public void delete(int id) {
		this.languageTechnologyRepository.deleteById(id);
		
	}

}
