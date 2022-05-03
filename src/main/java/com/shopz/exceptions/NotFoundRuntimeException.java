package com.shopz.exceptions;

public class NotFoundRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -4595284763572619684L;

    public NotFoundRuntimeException(String message) {
        super(message);
    }
}
