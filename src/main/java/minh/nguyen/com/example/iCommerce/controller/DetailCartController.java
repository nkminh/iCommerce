package minh.nguyen.com.example.iCommerce.controller;

import minh.nguyen.com.example.iCommerce.dto.DetailCartAdditionDto;
import minh.nguyen.com.example.iCommerce.dto.DetailCartDto;
import minh.nguyen.com.example.iCommerce.entity.Category;
import minh.nguyen.com.example.iCommerce.entity.DetailCart;
import minh.nguyen.com.example.iCommerce.services.DetailCartService;
import minh.nguyen.com.example.iCommerce.util.ApiResponse;
import minh.nguyen.com.example.iCommerce.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("detail-cart")
@Controller
@CrossOrigin("*")
@Validated
public class DetailCartController {

    @Autowired
    private DetailCartService detailCartService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<DetailCartDto>> findAll() {
        try {
            return new ApiResponse<List<DetailCartDto>>(detailCartService.findAll(), HttpStatus.OK).build();
        } catch (Exception ex) {
            return new ApiResponse<List<DetailCartDto>>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<List<DetailCartDto>> addOrUpdate(@RequestBody DetailCartAdditionDto detailCartAdditionDto) {
        try {
            return new ApiResponse<List<DetailCartDto>>(detailCartService.add(detailCartAdditionDto), HttpStatus.OK).build();
        } catch (CustomException ex) {
            return new ApiResponse<List<DetailCartDto>>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception ex) {
            return new ApiResponse<List<DetailCartDto>>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
