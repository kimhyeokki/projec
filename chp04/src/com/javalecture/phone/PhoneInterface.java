package com.javalecture.phone;

interface PhoneInterface {
    final int TimeOut = 1000;      //인터페이스 안에서 상수는 선언 가능 변수만 선언은 불가
    void sendCall();
    void receiveCall();
    default void printLogo(){
        System.out.println("==== Phone ====");
    }    
}

interface MobilePhoneInterface extends PhoneInterface {
    void sendSms();
    void receiveSms();   
}
interface Mp3Interface {
    void play();
    void stop();
}