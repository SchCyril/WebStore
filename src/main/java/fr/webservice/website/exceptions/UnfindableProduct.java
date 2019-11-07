package fr.webservice.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnfindableProduct extends RuntimeException {
    public UnfindableProduct(String s) {
        super(s);
    }
}
