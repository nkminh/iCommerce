package minh.nguyen.com.example.iCommerce.controller;

import minh.nguyen.com.example.iCommerce.dto.DetailCartDto;
import minh.nguyen.com.example.iCommerce.dto.ProductDto;
import minh.nguyen.com.example.iCommerce.entity.Category;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
import minh.nguyen.com.example.iCommerce.services.ProductService;
import minh.nguyen.com.example.iCommerce.util.ApiResponse;
import minh.nguyen.com.example.iCommerce.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@Controller
@CrossOrigin("*")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> search(@RequestBody ProductFilter productFilter) {
        try {
            return new ApiResponse<List<ProductDto>>(productService.search(productFilter), HttpStatus.OK).build();
        } catch (Exception ex) {
            return new ApiResponse<List<ProductDto>>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> findAll() {
        try {
            return new ApiResponse<List<ProductDto>>(productService.findAll(), HttpStatus.OK).build();
        } catch (Exception ex) {
            return new ApiResponse<List<ProductDto>>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
