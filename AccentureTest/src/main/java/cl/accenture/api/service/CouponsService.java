package cl.accenture.api.service;

import java.util.List;

import cl.accenture.api.model.CouponDTO;

public interface CouponsService {

	public List<CouponDTO> getCoupons() throws Exception ;
}
