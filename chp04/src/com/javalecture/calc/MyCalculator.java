package com.javalecture.calc;

import java.util.Scanner;

// Add, Mult , Subtr, Div
class Add extends Calc{
    Add(){
        setValue(a, b);
    }
    Add(int a, int b){
        setValue(a, b);
    }

    @Override
    int Calculator() {
        return a+b;
    }
}
class Mult extends Calc{
    Mult(){
        setValue(a, b);
    }
    Mult(int a,int b){
        setValue(a, b);
    }

    @Override
    int Calculator() {
        return a*b;
    }

}
class Subtr extends Calc{
    Subtr(){
        setValue(a, b);
    }
    Subtr(int a,int b){
        setValue(a, b);
    }

    @Override
    int Calculator() {
        return a>b? a-b:b-a;
    }
}
class Div extends Calc{
    Div(){
        setValue(a, b);
    }
    Div(int a,int b){
        setValue(a, b);
    }

    @Override
    int Calculator() {
        return a/b;
    }

}
public class MyCalculator {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    String operator = scanner.next();
    Calc exp =null;  // == Calc exp = new Add(),....new Div()
    int result =0;
    switch(operator){
        case "+" : 
        exp = new Add();
          break;
        case "-" :
           exp = new Subtr();
        break;
        case "*" :
          exp = new Mult();
          break;
           case "/" :
           exp = new Div();
          break;
    } 
    scanner.close();
    exp.setValue(a,b);  // == Calc exp = new Add(),...,new Div().setvalue(a,b)
    result = exp.Calculator(); // == Calc exp = new Add(),...,new Div().Calculator() 
    System.out.println(result);
   }
    
}
