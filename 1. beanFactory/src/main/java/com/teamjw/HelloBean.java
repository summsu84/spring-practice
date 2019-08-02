package com.teamjw;

public class HelloBean {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("My Message : " + message);
    }
}
