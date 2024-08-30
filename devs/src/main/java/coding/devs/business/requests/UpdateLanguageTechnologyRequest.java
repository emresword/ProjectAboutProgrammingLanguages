package coding.devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageTechnologyRequest {
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	@Size(min=3,max=20)
	private String name;
	@NotNull
	@NotBlank
	private String version;
	@NotNull
	private int programingLanguageId;

}
