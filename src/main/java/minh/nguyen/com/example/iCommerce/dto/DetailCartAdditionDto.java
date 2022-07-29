package minh.nguyen.com.example.iCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailCartAdditionDto {
    private Long productId;
    private Integer count;
}
