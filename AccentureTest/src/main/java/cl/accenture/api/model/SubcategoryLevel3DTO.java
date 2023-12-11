package cl.accenture.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryLevel3DTO {
	private String id;
	private String name;
	private int relevance;
	
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	private List<SubcategoryLevel4DTO> subcategories;
}
