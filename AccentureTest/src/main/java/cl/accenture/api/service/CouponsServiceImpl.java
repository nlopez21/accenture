package cl.accenture.api.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.accenture.api.client.CouponClient;
import cl.accenture.api.model.CouponDTO;


@Service
public class CouponsServiceImpl implements CouponsService{

	@Autowired
	CouponClient couponClient;

	public List<CouponDTO> getCoupons() throws Exception {
		return validateDate(couponClient.getCoupon());
	}
	
	private List<CouponDTO> validateDate(List<CouponDTO> lCoupon) {
		List<CouponDTO> listCoupon = new ArrayList<CouponDTO>();
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		lCoupon.forEach(item -> {
			try {	
				Date dateExpire = sdf.parse(item.getExpiresAt());
				if (dateExpire.compareTo(now) >= 0) {								
					listCoupon.add(item);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		return listCoupon;
	}

}
