public class Book {
    String title;
    String name;
    Book(){
        this("","");
    }
    Book(String title){
        this(title, "작자미상");
        // this.title =title;  //this는 자기 자신을 가르킨다. 속성 앞에 주로 활용함
        // name="작자미상";     
    }
    Book(String title, String name){
        this.title =title;
        this.name = name;
       
    }
    
    void bookinfo(){
        System.out.println("이 책의 제목은 " + title + "이고 작가 이름은 " +name+ "입니다.");
    }

    public static void main(String[] args) {
        Book ayo = new Book("안녕하세요");
        ayo.bookinfo();
        Book simchung = new Book("심청전");
        System.out.printf("%s / %s %n",simchung.title,simchung.name);
        simchung.bookinfo();
        Book noname = new Book();

    }
}