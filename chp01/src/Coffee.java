import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String name = scanner.next();
       int price = 0;
    //    if(name.equals("아메리카노")){  //문자열 비교는 매서드로 비교해야 한다 ==은 안됨 // equals를 사용
    //         price =2000;
    //    } else if(name.equals("카푸치노")){
    //     price =3000;
    //    }

    /*switch(조건식){
        case 결과값 :
        break;
        case  :
        .
        .
        .
        default :  //else와 같은 느낌....
        break;
    }
    */
       
       switch (name) {
        case "아메리카노" : price = 2000;
        System.out.println("주문하신 " +name + "의 가격은 " + price+"입니다.");        
            break;
        case "카푸치노","카페라떼": price = 3000;
        System.out.println("주문하신 " +name + "의 가격은 " + price+"입니다.");
                            //("주무하신 %s의 가격은 %d입니다",name price)
            break;
        case "바닐라라떼" : price =3000;
        System.out.println("주무하신 %s의 가격은 %d입니다");
        break;
        default : System.out.println(name+"는 메뉴에 없습니다. 옆에 스타벅스로 이용해주세요.");
            break;
       }
         System.out.println("""
                 문자열입니다
                 """);
       scanner.close();
    }
}
