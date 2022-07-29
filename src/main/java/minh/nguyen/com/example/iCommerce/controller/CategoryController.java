package minh.nguyen.com.example.iCommerce.controller;

import minh.nguyen.com.example.iCommerce.dto.ProductDto;
import minh.nguyen.com.example.iCommerce.entity.Category;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
import minh.nguyen.com.example.iCommerce.repository.CategoryRepository;
import minh.nguyen.com.example.iCommerce.services.ProductService;
import minh.nguyen.com.example.iCommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
@CrossOrigin("*")
@Validated
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Category>> findAll() {
        try {
            return new ApiResponse<List<Category>>(categoryRepository.findAll(), HttpStatus.OK).build();
        } catch (Exception ex) {
            return new ApiResponse<List<Category>>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
