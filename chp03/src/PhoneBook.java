//이름 : 전화번호

import java.util.Scanner;

class Phone {
    private String name;
    private String tel; 
    
    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}

public class PhoneBook {
    // has-a 다른 클래스를 포함하고 있을 때 아래 같은 두경우에 has-a라고 말한다.
    private Phone phoneList[];  //Phone 클래스 호출하고 phoneList[] 배열생성
    private Scanner scanner;    // 직접 입력 받기위해 Scanner  클래스 호출 하고 scanner로 선언

    public PhoneBook() {          //PhoneBook 생성자 함수 생성
        scanner =new Scanner(System.in);  //사용자 입력 가능
    }
    public void write() {
        System.out.println("몇명을 입력하시겠습니까?");
        int total = scanner.nextInt();
        phoneList = new Phone[total];
        for(int i=0;i<total;i++){
            System.out.println("이름과 전화번호를 입력하시오");
            String name = scanner.next();
            String tel = scanner.next();
            phoneList[i] =new Phone(name,tel);
        }
        System.out.println(total + "명의 전화번호부가 입력되었습니다.");
    }
    //전화번호 찾기 search() 함수 만들고
    public String search(String name){  
        for(int i=0;i<phoneList.length;i++){   //만들어진 phoneList의 내용을 비교하기 위해
            if(name.equals(phoneList[i].getName())){
              return phoneList[i].getTel();
              //System.out.println("전화번호는"+searchTel+"입니다.");
            }
        }
        return " 해당하는 사람이 없음";  
    }
    public void run(){
        while(true){
            System.out.println("이름을 쓰세요");
            String name = scanner.next();
            if(name.equals("그만"))
             break;
           String tel = search(name);
           if(tel==null){
            System.out.println("없는 사람입니다 다시 입력해주세요");
           } else{
            System.out.println(name+"님의 전화번호는 "+tel+"입니다.");
           }
        }
    }
}
