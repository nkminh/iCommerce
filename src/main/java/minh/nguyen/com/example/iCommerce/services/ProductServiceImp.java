package minh.nguyen.com.example.iCommerce.services;

import minh.nguyen.com.example.iCommerce.dto.ProductDto;
import minh.nguyen.com.example.iCommerce.entity.Color;
import minh.nguyen.com.example.iCommerce.entity.Product;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
//import minh.nguyen.com.example.iCommerce.mapper.ProductMapper;
import minh.nguyen.com.example.iCommerce.repository.product.ProductRepository;
import minh.nguyen.com.example.iCommerce.util.CustomException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

//    @Autowired
    private ProductRepository productRepository;

    ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> search(ProductFilter productFilter){
        List<ProductDto> productDtos = productRepository.filterProduct(productFilter)
                .stream().map(i -> productEntityToDto(i)).collect(Collectors.toList());

        if (productFilter.getColor() != null) {
            productDtos = productDtos.stream().filter(productDto ->
                    productDto.getColors().stream()
                            .filter(i -> i.toLowerCase().contains(productFilter.getColor().toLowerCase()))
                            .findAny().orElse(null) != null
            ).collect(Collectors.toList());
        }


        return productDtos;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(i -> productEntityToDto(i)).collect(Collectors.toList());
    }

    ProductDto productEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setBranchName(product.getBranch().getBranchName());
        productDto.setCategoryName(product.getCategory().getCategoryName());
        productDto.setColors(product.getColors().stream().map(i -> i.getColor()).collect(Collectors.toSet()));
        return productDto;
    }
}
