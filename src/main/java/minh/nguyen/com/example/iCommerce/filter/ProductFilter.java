package minh.nguyen.com.example.iCommerce.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minh.nguyen.com.example.iCommerce.entity.Branch;
import minh.nguyen.com.example.iCommerce.entity.Category;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFilter {
    private Long id;
    private String productName;
    private BigDecimal price;
    private String categoryName;
    private String branchName;
    private String color;
}
