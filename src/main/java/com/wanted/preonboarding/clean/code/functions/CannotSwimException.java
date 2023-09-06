package com.wanted.preonboarding.clean.code.functions;

public class CannotSwimException extends Exception {
    public CannotSwimException(){
        super();
    }

    public CannotSwimException(Exception e){
        super(e);
    }

    public CannotSwimException(String message){
        super(message);
    }
}
