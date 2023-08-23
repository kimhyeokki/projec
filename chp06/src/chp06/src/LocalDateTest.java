import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) {
        //Calendar => LocalDate
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime nowdatetime = LocalDateTime.now();
        System.out.println(nowdatetime);
        System.out.printf("%d년%d월%d일",now.getYear(),now.getMonthValue(),now.getDayOfMonth());
        // SimpleDateFormat format = new SimpleDateFormat("yyyy년MM/dd hh:mm:ss");
       nowdatetime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"));
       System.out.println(nowdatetime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));

       ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));  //표준시 다른나라 시간
       System.out.println(seoulDateTime);

    }
}
