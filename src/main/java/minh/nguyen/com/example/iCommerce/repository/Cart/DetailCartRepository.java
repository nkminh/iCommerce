package minh.nguyen.com.example.iCommerce.repository.Cart;

import minh.nguyen.com.example.iCommerce.entity.DetailCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailCartRepository extends CrudRepository<DetailCart, Long> {

    Optional<DetailCart> findByProductIdAndCartId(Long productId, Long cartId);
    List<DetailCart> findAll();
}
