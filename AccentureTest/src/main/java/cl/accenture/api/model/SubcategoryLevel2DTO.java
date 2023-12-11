package cl.accenture.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryLevel2DTO {

	private String id;
	private String name;
	private int relevance;
	
	private String iconImageUrl;
	private List<SubcategoryLevel3DTO> subcategories;
	
}
