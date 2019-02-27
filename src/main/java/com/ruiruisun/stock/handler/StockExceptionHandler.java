package com.ruiruisun.stock.handler;

import com.ruiruisun.stock.bean.ExceptionBean;
import com.ruiruisun.stock.exception.NotFoundException;
import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
@ResponseBody
public class StockExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> ExceptionHandler(HttpServletRequest request,NotFoundException exception) {
        ResponseEntity<Object> ResponseEntity = null;
        if (exception.getMessage() == null || exception.getMessage().length() == 0) {
            ResponseEntity = new ResponseEntity<Object>(setExceptionBean(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), request.getRequestURI()), HttpStatus.NOT_FOUND);
        } else {
            ResponseEntity = new ResponseEntity<Object>(setExceptionBean(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), request.getRequestURI()), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity;
    }

    private ExceptionBean setExceptionBean(int status, String error, String path) {
        ExceptionBean ExceptionBean = new ExceptionBean();
        ExceptionBean.setTimestamp(new Date().toString());
        ExceptionBean.setStatus(status);
        ExceptionBean.setError(error);
        ExceptionBean.setMessage("No message available");
        ExceptionBean.setPath(path);
        return ExceptionBean;
    }

    private ExceptionBean setExceptionBean(int status, String error, String message, String path) {
        ExceptionBean ExceptionBean = new ExceptionBean();
        ExceptionBean.setTimestamp(new Date().toString());
        ExceptionBean.setStatus(status);
        ExceptionBean.setError(error);
        ExceptionBean.setMessage(message);
        ExceptionBean.setPath(path);
        return ExceptionBean;
    }
}
