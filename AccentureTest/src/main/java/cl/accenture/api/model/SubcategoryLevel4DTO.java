package cl.accenture.api.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryLevel4DTO {

	private String id;
	private String name;
	private int relevance;
}
