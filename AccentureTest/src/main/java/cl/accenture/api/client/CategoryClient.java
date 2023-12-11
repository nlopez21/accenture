package cl.accenture.api.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.accenture.api.model.CategoryThreeDTO;


@Component
public class CategoryClient {
	RestTemplate rclient ;
	
	@Value("category.get.uri")
	private String uri;
	
		public CategoryThreeDTO getCoupon () {
			
			ResponseEntity<CategoryThreeDTO> categories = rclient.getForEntity(uri,CategoryThreeDTO.class);			
			
			return  categories.getBody();
					
		}
	
}
