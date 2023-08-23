import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar =  Calendar.getInstance();  //Calendar 은 new를 활용해서 호출 x WHY? : abstract 이기 때문에
        String monthArray[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String dayArray[] = {"","일","월","화","수","목","금","토"};
        String ampmArray[] = {"오전","오후"};
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR);  //12시간 기준
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); //24시간 기준
        int ampm = calendar.get(Calendar.AM_PM);  //오전은 0, 오후는 1로 리턴합니다.
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        
        System.out.println(calendar);
        System.out.println(year);
        System.out.println(monthArray[month]);
        System.out.println(date);
        System.out.println(dayArray[day]);
        System.out.println(ampmArray[ampm]+":"+hour);
        System.out.println(calendar.getTime());

        SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd hh:m:s"); //hh(12시),HH(24시)
        String myDate = sim.format(calendar.getTime());
        System.out.println(myDate);

        //Quiz01 시간을 구해서 인사말 하기
        //아침이면 Good morning(5~11), Afternoo(12~17), Evening(18~21), night(22~5)

        if(hourOfDay>=5 && hourOfDay<12){
            System.out.println("Good Morning");
        } else if(hourOfDay>=12 && hourOfDay<18){
            System.out.println("Good Afternoon");
        }else if(hourOfDay>=18 && hourOfDay<22){
            System.out.println("Good Evening");
        }else {
            System.out.println("Good Night");
        }
    }
}
