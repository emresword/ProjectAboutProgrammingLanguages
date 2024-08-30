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
import coding.devs.business.requests.CreateProgramingLanguageRequest;
import coding.devs.business.requests.UpdateProgramingLanguageRequest;
import coding.devs.business.responses.GetAllProgramingLanguageResponse;
import coding.devs.business.responses.GetByIdProgramingLanguageResponse;
import coding.devs.entities.concretes.ProgramingLanguage;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programingLanguages")
@AllArgsConstructor
public class ProgramingLanguageController {
	
	private ProgramingLanguageService programingLanguageService;
   
    @GetMapping()
	public List<GetAllProgramingLanguageResponse> getAll() {
		return programingLanguageService.getAll();

	}
    @GetMapping("/{id}")
   	public GetByIdProgramingLanguageResponse getById(@PathVariable int id) {
   		return programingLanguageService.getById(id);

   	}
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateProgramingLanguageRequest createProgramingLanguageRequest) {
    	this.programingLanguageService.add(createProgramingLanguageRequest);
    }
    
    @PutMapping
    public void update(@RequestBody @Valid UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
    	this.programingLanguageService.update(updateProgramingLanguageRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	this.programingLanguageService.delete(id);
    }
    
}
