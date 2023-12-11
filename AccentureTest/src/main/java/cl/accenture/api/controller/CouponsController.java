package cl.accenture.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.api.model.CouponDTO;
import cl.accenture.api.service.CouponsServiceImpl;

@RestController
@RequestMapping("/accenture/api")
public class CouponsController {
	
	@Autowired
	CouponsServiceImpl couponsService;
	
	
	@GetMapping(path="/coupons", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CouponDTO>> getAll() throws Exception{
		return new ResponseEntity<>(couponsService.getCoupons(), HttpStatus.OK); 
	}

}
