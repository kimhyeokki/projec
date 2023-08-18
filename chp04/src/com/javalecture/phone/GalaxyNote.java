package com.javalecture.phone;

public class GalaxyNote implements MobilePhoneInterface, Mp3Interface {

    @Override
    public void sendCall() {
         System.out.println("노트가 전화를 겁니다");
    }

    @Override
    public void receiveCall() {
      System.out.println("노트가 전화를 받습니다");
    }
    public void sendSms(){
        System.out.println("문자를 보냅니다");
    }
    public void receiveSms(){
        System.out.println("문자를 받습니다");

    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }
    
}
