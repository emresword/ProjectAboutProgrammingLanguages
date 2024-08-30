package coding.devs.wepApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coding.devs.business.abstracts.LanguageTechnologyService;
import coding.devs.business.abstracts.ProgramingLanguageService;
import coding.devs.business.requests.CreateLanguageTechnologyRequest;
import coding.devs.business.requests.CreateProgramingLanguageRequest;
import coding.devs.business.requests.UpdateLanguageTechnologyRequest;
import coding.devs.business.responses.GetAllLanguageTechnologyResponse;
import coding.devs.business.responses.GetAllProgramingLanguageResponse;
import coding.devs.business.responses.GetByIdLanguageTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/languageTechnologies")
@AllArgsConstructor
public class LanguageTechnologyController {
	
	private LanguageTechnologyService languageTechnologyService;
    
    @GetMapping()
	public List<GetAllLanguageTechnologyResponse> getAll() {
		return languageTechnologyService.getAll();

	}
    
    @GetMapping("/{id}")
	public GetByIdLanguageTechnologyResponse getById(@PathVariable int id) {
		return languageTechnologyService.getById(id);

	}
    
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
    	this.languageTechnologyService.add(createLanguageTechnologyRequest);
    }
    
    @PutMapping
    public void update(@RequestBody @Valid UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
    	this.languageTechnologyService.update(updateLanguageTechnologyRequest);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	this.languageTechnologyService.delete(id);
    }
    
}
