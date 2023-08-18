package com.javalecture.phone;

public class Galaxy implements PhoneInterface {

    @Override
    public void sendCall() {
       System.out.println("전화를 겁니다");
    }

    @Override
    public void receiveCall() {
       System.out.println("전화를 받습니다");
    }

    public void vicsbee(){
        System.out.println("하이 빅스비");
    }
    // public static void main(String[] args) {
    //    Galaxy galaxy = new Galaxy();
    //   //= PhoneInterface galaxy =new Galaxy();
    // }
}
