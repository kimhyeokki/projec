import java.util.Optional;

public class NullPointException {
    public static void main(String[] args) {
        String msg =null;
        Optional<String> cat = Optional.of("CAT");  //of() 확실한 값을 알고 있을때,null을 담으면 오류발생
        Optional<String> cat02 = Optional.ofNullable(null); //null인지 아닌지 확인하려고 
        System.out.println(cat.get());
        System.out.println(cat02.orElse("dog")); //null일 때 값을 얻어오기 위해 보통은 null => ""; 공백으로 대체한다.

        try {
            System.out.println(msg.length()); 
        } catch (NullPointerException e) {
            System.out.println("비어있습니다.");
            e.printStackTrace();
        }
    }
}
