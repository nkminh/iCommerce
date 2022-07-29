package minh.nguyen.com.example.iCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minh.nguyen.com.example.iCommerce.entity.Branch;
import minh.nguyen.com.example.iCommerce.entity.Category;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String productName;
    private BigDecimal price;
    private String categoryName;
    private String branchName;
    private Set<String> colors;
}
