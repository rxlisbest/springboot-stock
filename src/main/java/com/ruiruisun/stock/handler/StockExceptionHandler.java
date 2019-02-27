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
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> ExceptionHandler(HttpServletRequest request,NotFoundException exception) {
        ResponseEntity<Object> responseEntity = null;
        if (exception.getMessage() == null || exception.getMessage().length() == 0) {
            responseEntity = new ResponseEntity<Object>(setExceptionBean(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), request.getRequestURI()), HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity<Object>(setExceptionBean(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), request.getRequestURI()), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    private ExceptionBean setExceptionBean(int status, String error, String path) {
        ExceptionBean exceptionBean = new ExceptionBean();
        exceptionBean.setTimestamp(new Date().toString());
        exceptionBean.setStatus(status);
        exceptionBean.setError(error);
        exceptionBean.setMessage("No message available");
        exceptionBean.setPath(path);
        return exceptionBean;
    }

    private ExceptionBean setExceptionBean(int status, String error, String message, String path) {
        ExceptionBean exceptionBean = new ExceptionBean();
        exceptionBean.setTimestamp(new Date().toString());
        exceptionBean.setStatus(status);
        exceptionBean.setError(error);
        exceptionBean.setMessage(message);
        exceptionBean.setPath(path);
        return exceptionBean;
    }
}
