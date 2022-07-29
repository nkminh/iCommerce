package minh.nguyen.com.example.iCommerce.repository.Cart;

import minh.nguyen.com.example.iCommerce.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
