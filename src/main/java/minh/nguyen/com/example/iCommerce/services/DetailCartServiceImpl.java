package minh.nguyen.com.example.iCommerce.services;

import minh.nguyen.com.example.iCommerce.dto.DetailCartAdditionDto;
import minh.nguyen.com.example.iCommerce.dto.DetailCartDto;
import minh.nguyen.com.example.iCommerce.dto.ProductDto;
import minh.nguyen.com.example.iCommerce.entity.Cart;
import minh.nguyen.com.example.iCommerce.entity.DetailCart;
import minh.nguyen.com.example.iCommerce.entity.Product;
import minh.nguyen.com.example.iCommerce.repository.Cart.CartRepository;
import minh.nguyen.com.example.iCommerce.repository.Cart.DetailCartRepository;
import minh.nguyen.com.example.iCommerce.repository.product.ProductRepository;
import minh.nguyen.com.example.iCommerce.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailCartServiceImpl implements DetailCartService {

    @Autowired
    private DetailCartRepository detailCartRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<DetailCartDto> add(DetailCartAdditionDto detailCartAdditionDto) throws CustomException {
        if (detailCartAdditionDto == null
                || detailCartAdditionDto.getCount() <= 0
                || detailCartAdditionDto.getProductId() == null) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid data");
        }

        DetailCart detailCart = detailCartRepository.findByProductIdAndCartId
                (detailCartAdditionDto.getProductId(), 1L).orElse(null);
        Cart cart = cartRepository.findById(1L).orElse(null);
        Product product = productRepository.findById(detailCartAdditionDto.getProductId()).orElse(null);

        if (product == null) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Product isn't exited");
        }

        if (detailCart == null) {
            detailCart = new DetailCart();
            detailCart.setCart(cart);
            detailCart.setCount(detailCartAdditionDto.getCount());
            detailCart.setProduct(product);

        } else {
            detailCart.setCount(detailCart.getCount() + detailCartAdditionDto.getCount());
        }
        detailCartRepository.save(detailCart);
        return this.findAll();
    }

    @Override
    public List<DetailCartDto> findAll() {
        return detailCartRepository.findAll().stream().map(i -> detailCartEntityToDto(i)).collect(Collectors.toList());
    }

    DetailCartDto detailCartEntityToDto(DetailCart detailCart) {
        DetailCartDto detailCartDto = new DetailCartDto();
        detailCartDto.setId(detailCart.getId());
        detailCartDto.setProductName(detailCart.getProduct().getName());
        detailCartDto.setCount(detailCart.getCount());
        detailCartDto.setPrice(detailCart.getProduct().getPrice());
        detailCartDto.setAmount(detailCart.getProduct().getPrice().multiply(new BigDecimal(detailCart.getCount())));
        return detailCartDto;
    }

}
