package minh.nguyen.com.example.iCommerce.services;

import minh.nguyen.com.example.iCommerce.dto.DetailCartAdditionDto;
import minh.nguyen.com.example.iCommerce.dto.DetailCartDto;
import minh.nguyen.com.example.iCommerce.dto.ProductDto;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
import minh.nguyen.com.example.iCommerce.util.CustomException;

import java.util.List;


public interface DetailCartService {
    List<DetailCartDto> add(DetailCartAdditionDto detailCartAdditionDto) throws CustomException;
    List<DetailCartDto> findAll();
}
