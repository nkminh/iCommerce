package minh.nguyen.com.example.iCommerce.repository.product;

import minh.nguyen.com.example.iCommerce.entity.Product;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> filterProduct(ProductFilter productFilter);
}
