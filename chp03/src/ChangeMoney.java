class MoneyConverter{
    private static double rate;

    public static double getRate() {
        return rate;
    }
    public static void setRate(double _rate) {
        rate = _rate;
    }
    static double toDollar(double won){
        return won / rate;
    }
    static double toWon(double dollar){
        return dollar * rate;
    }

}
// static은 static 끼리 공유한다. this는 사용 불가


public class ChangeMoney {
   
    

    public static void main(String[] args) {
        MoneyConverter.setRate(1380);
        double won = MoneyConverter.toDollar(100000);
        double dollar = MoneyConverter.toWon(1000);
        System.out.printf("십만원을 달러로 환전하면 = %.2f %n",won);
        System.out.printf("천달러를 원으로 환전하면 = %.0f",dollar);
    }
}
