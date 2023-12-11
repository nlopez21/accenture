package cl.accenture.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import cl.accenture.api.client.CouponClient;
import cl.accenture.api.model.CouponDTO;
import cl.accenture.api.service.CouponsServiceImpl;

public class CouponsServiceTest {

	@InjectMocks
	private CouponsServiceImpl service;

	@Mock
	private CouponClient client;
	
	List<CouponDTO> list;
	
	
	@Test
	void testGetCoupons() throws Exception {
		CouponDTO dto = 
				new CouponDTO("COUPON_1","50% Discount","Crazy Seller","https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg","2045-12-01");
		list = new ArrayList<>();
		list.add(dto);
		Mockito.when(client.getCoupon()).thenReturn(list);

	}
	
}
