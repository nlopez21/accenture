package cl.accenture.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDTO {

 private String id;
 private String description;
 private String seller;
 private String image;
 private String expiresAt;
}
