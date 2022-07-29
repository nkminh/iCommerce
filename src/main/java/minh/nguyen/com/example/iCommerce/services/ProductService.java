package minh.nguyen.com.example.iCommerce.services;


import minh.nguyen.com.example.iCommerce.dto.ProductDto;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
import minh.nguyen.com.example.iCommerce.util.CustomException;

import java.util.List;

public interface ProductService {
    List<ProductDto> search(ProductFilter productFilter);
    List<ProductDto> findAll();
}
