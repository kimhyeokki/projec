package com.javalecture.tvquiz01;

public class IPTV extends ColorTV {
    private String idAddress;
    
    public String getIdAddress() {
        return idAddress;
    }
    IPTV(int size, int nColor, String idAddress) {
        super(size, nColor);
        this.idAddress =idAddress;
    }
    
     public void showInfo(){
        System.out.printf("IP주소가 %s 이고 크기가  %d, %d 컬러 TV입니다.",getIdAddress(),getSize(),getnColor());
    }
    public static void main(String[] args) {
        new IPTV(64, 256, "127.0.0.1").showInfo();
    }
 }
