package coding.devs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "programingLanguages")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProgramingLanguage {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "version")
	private String version;
	
	@OneToMany(mappedBy = "programingLanguage", cascade = CascadeType.ALL)
	private List<LanguageTechnology> languageTechnologies;

}
