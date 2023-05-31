package com.example.nisum.MapStruct.exception;

import javax.xml.bind.ValidationException;

public class Validator {

    public int validateId(int id) throws ValidationException {
        if (id < 0) {
            throw new ValidationException("Invalid ID value");
        }
        return id;
    }
}
