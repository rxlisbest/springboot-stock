package com.ruiruisun.stock.handler;

import com.ruiruisun.stock.bean.ExceptionBean;
import com.ruiruisun.stock.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class StockExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> ExceptionHandler(NotFoundException exception) {
        if (exception.getMessage().length() > 0) {
            return new ResponseEntity<Object>(setExceptionBean(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(setExceptionBean(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    private ExceptionBean setExceptionBean(int status, String error) {
        ExceptionBean ExceptionBean = new ExceptionBean();
        ExceptionBean.setStatus(status);
        ExceptionBean.setError(error);
        ExceptionBean.setMessage("No message available");
        return ExceptionBean;
    }

    private ExceptionBean setExceptionBean(int status, String error, String message) {
        ExceptionBean ExceptionBean = new ExceptionBean();
        ExceptionBean.setStatus(status);
        ExceptionBean.setError(error);
        ExceptionBean.setMessage(message);
        return ExceptionBean;
    }
}
