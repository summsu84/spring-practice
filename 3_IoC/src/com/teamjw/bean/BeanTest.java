package com.teamjw.bean;

//POJO
public class BeanTest {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("My Message : " + message);
    }
}
