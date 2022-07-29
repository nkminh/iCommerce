package minh.nguyen.com.example.iCommerce.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private Boolean success;

    private String message;

    private T data;

    private int status;

    public ApiResponse(T data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
    }
    public ApiResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }

    public ResponseEntity<T> build() {
        return new ResponseEntity(this, HttpStatus.valueOf(this.status));
    }

}
