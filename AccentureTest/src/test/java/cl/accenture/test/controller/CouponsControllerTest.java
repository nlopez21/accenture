package cl.accenture.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cl.accenture.api.controller.CouponsController;
import cl.accenture.api.model.CouponDTO;
import cl.accenture.api.service.CouponsServiceImpl;

public class CouponsControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	CouponsController controller;
	
	@Mock
	private CouponsServiceImpl service;
	
	@BeforeEach
	  public void setUp() throws Exception {
	    MockitoAnnotations.openMocks(this);
	    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	  }
	
	
	@Test
	void testController() throws Exception {
		CouponDTO dto = 
				new CouponDTO("COUPON_1","50% Discount","Crazy Seller","https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg","2045-12-01");
		List<CouponDTO> list = new ArrayList<>();
		list.add(dto);
		
		Mockito.when(service.getCoupons()).thenReturn(list);
		
		this.mockMvc.perform(get("/accenture/api/coupons"))
		.andExpect(status().isOk()).andDo(print())
		.andReturn().getResponse().getContentAsString();
	}
	
	
	
}
