package dev.springboot.eshopping.exception;

import dev.springboot.eshopping.util.ProductErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ProductRestException {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        ProductErrorResponse productErrorResponse = new ProductErrorResponse();
        productErrorResponse.setCode(HttpStatus.NOT_FOUND.toString());
        productErrorResponse.setMessage(e.getMessage());
        productErrorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
        return new ResponseEntity<>(productErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(Exception e) {
        ProductErrorResponse productErrorResponse = new ProductErrorResponse();
        productErrorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        productErrorResponse.setMessage(e.getMessage());
        productErrorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
        return new ResponseEntity<>(productErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
