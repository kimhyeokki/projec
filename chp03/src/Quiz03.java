class Song{
    String title;
    String artist;
    int year;
    String country;
    Song(){}
    Song(String title, String artist, int year, String country){
        this.title =title;
        this.artist =artist;
        this.year=year;
        this.country=country;
    }
   void show(){
        System.out.printf("이곡은 %d년도에 출시된 %s 국적의 %s 가(이) 부른 %s 입니다",this.year,this.country,this.artist,this.title);
    }
}

public class Quiz03 {
    //Song이라는 클라스를 만든다, title, artist, year, country 필드 가지고, 생성자 함수는 빈 생성자 하나, 4개의 매개변수를 가지는 생성자 함수
    //show() 매서드를 통해 몇년도에 출시된 어느나라 국적의 가수부른 노래 출력   
    public static void main(String[] args) {
        Song song =new Song("세븐", "정국", 2023, "한국");
        song.show();
        Song song02 = new Song();
        song02.artist ="빅뱅";
        song02.country="한국";
        song02.title="'봄여름가을겨울'";
        song02.year =2022;
        System.out.println('\t'); //줄바꿈 '\t'
        song02.show();
    }
}
