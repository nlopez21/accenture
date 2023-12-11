package cl.accenture.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDTO {
	
	
	private String id;
	private String name;
	private int relevance;
	
	private List<SubcategoryLevel2DTO> subcategories;
}
