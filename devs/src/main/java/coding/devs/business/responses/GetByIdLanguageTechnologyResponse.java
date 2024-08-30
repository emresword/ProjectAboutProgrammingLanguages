package coding.devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageTechnologyResponse {
	private int id;
	private String name;
	private String version;
	private String programingLanguageName;
	private String programingLanguageVersion;

}
