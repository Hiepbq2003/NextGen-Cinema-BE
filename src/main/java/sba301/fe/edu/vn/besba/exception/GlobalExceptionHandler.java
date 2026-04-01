package sba301.fe.edu.vn.besba.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sba301.fe.edu.vn.besba.base.BaseResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<Object>> handleCustomException(CustomException ex) {
        return ResponseEntity.status(ex.getHttpStatus())
                .body(BaseResponse.failure(ex.getMessage(), ex.getCode()));
    }

    // Xử lý các lỗi do @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(400)
                .body(BaseResponse.failure(errorMessage, 400));
    }

    // Xử lý tất cả các lỗi hệ thống không lường trước được
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(Exception ex) {
        logger.error("Lỗi hệ thống không xác định: ", ex);
        return ResponseEntity.status(500)
                .body(BaseResponse.failure("Lỗi hệ thống không xác định: " + ex.getMessage(), 500));
    }
}