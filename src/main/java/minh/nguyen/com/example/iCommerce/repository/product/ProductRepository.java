package minh.nguyen.com.example.iCommerce.repository.product;

import minh.nguyen.com.example.iCommerce.entity.Product;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    List<Product> findAllByIdAndNameAndPriceAndBranch_BranchNameAndCategory_CategoryName
            (Long id, String name, BigDecimal price, String branchName, String categoryName);
}
