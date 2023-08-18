package com.javalecture.wontodollarquiz02;

public class KmTOMile extends Converter {
    KmTOMile(double ratio){
        this.ratio =ratio;
    }

    @Override
    public double convert(double src) {
        return src /ratio;        
    }

    @Override
    public String srcString() {
        return "km";
    }

    @Override
    public String destString() {
     return "mile";   
    }
    public static void main(String[] args) {
        new KmTOMile(1.6).run();
    }
}
