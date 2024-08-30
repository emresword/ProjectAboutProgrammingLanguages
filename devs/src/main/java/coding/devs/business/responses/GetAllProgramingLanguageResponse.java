package coding.devs.business.responses;

import coding.devs.business.requests.CreateProgramingLanguageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgramingLanguageResponse {
private int id;
private String name;
private String version;
}
