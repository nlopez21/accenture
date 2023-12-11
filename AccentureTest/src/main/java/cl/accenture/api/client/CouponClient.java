package cl.accenture.api.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.accenture.api.model.CouponDTO;

@Component
public class CouponClient {

	@Value("${coupons.get.uri}")
	private String uri;

    @Cacheable("CouponDTO")
	public List<CouponDTO> getCoupon() throws Exception {
		List<CouponDTO> listCoupon = new ArrayList<>();
		RestTemplate rclient = new RestTemplate();

		List<LinkedHashMap<String, String>> json = rclient.getForObject(uri, List.class);
		json.forEach(item -> {
			CouponDTO coupon = new CouponDTO();
			coupon.setId(item.get("id"));
			coupon.setDescription(item.get("description"));
			coupon.setSeller(item.get("seller"));
			coupon.setImage(item.get("image"));
			coupon.setExpiresAt(item.get("expiresAt"));
			listCoupon.add(coupon);
		});
		return listCoupon;

	}

}
