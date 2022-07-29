package minh.nguyen.com.example.iCommerce.repository;

import minh.nguyen.com.example.iCommerce.entity.Category;
import minh.nguyen.com.example.iCommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
}
