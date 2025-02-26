package org.study.shopping.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handler1() {
        return ResponseEntity.status(400).body("타입 틀린!!!! 에러!!!!!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler2() {
        return ResponseEntity.status(400).body("에러!!!!!");
    }
}
