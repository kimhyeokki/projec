package com.javalecture.wontodollarquiz02;

public class WonToEuro extends Converter {
    WonToEuro(double ratio){    //생성자 함수 생성
        this.ratio =ratio;
    }

    @Override
    public double convert(double src) {    //부모클래스가 추상 Method를 가지고 있으므로 
                                            // 자식클래스는 부모클래스 함수를 오버라이드해서 반드시 구현부를 작성해야합니다.
       return src/ratio;
    }

    @Override
    public String srcString() {
        return "원";
    }

    @Override
    public String destString() {
        return "유로";
    }
    public static void main(String[] args) {
        new WonToEuro(1456).run();
    }
    
}
