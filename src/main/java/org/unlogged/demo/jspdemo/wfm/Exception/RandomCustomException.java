package org.unlogged.demo.jspdemo.wfm.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RandomCustomException extends Exception {
    private String message;
    private String code;

    public RandomCustomException(String message, String code) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
