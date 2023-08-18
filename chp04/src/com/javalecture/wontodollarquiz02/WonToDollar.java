package com.javalecture.wontodollarquiz02;

import java.util.Scanner;

abstract class Converter{
    abstract public double convert(double src);
    abstract public String srcString();
    abstract public String destString();
    public double ratio;
    public void run(){
        Scanner scanner  =new Scanner(System.in);
        System.out.printf("%s를 %s로 환전해드리겠습니다.",srcString(),destString());
        System.out.printf("%n%s를 입력하세요",srcString());
       double inputmoney = scanner.nextDouble();
       double changemoney = convert(inputmoney);
       System.out.printf("환전된 금액은 %f%s입니다.",changemoney,destString());
    }
}

public class WonToDollar extends Converter {
    public WonToDollar(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public double convert(double src) {
       return src/ratio;
    }

    @Override
    public String srcString() {
        return "원";
    }

    @Override
    public String destString() {
        return "달러";
    }
    public static void main(String[] args) {
        WonToDollar wonToDollar = new WonToDollar(1380);
        wonToDollar.run();
    }
    
}
