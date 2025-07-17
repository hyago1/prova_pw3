package com.pw.projetofinal.core.exception;

public class CamisaNotFoundExpection extends Exception{

    String message;

    public CamisaNotFoundExpection(String message) {
        this.message = message;
    }
}