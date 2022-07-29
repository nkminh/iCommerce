package minh.nguyen.com.example.iCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minh.nguyen.com.example.iCommerce.entity.Cart;
import minh.nguyen.com.example.iCommerce.entity.Product;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailCartDto {
    private Long id;
    private String productName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal amount;
//    private Long cartId;
}
