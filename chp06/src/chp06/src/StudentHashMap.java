import java.util.HashMap;

class Student {
    private int id;
    private String tel;
    public Student(int id, String tel) {
        this.id = id;
        this.tel = tel;
    }
    public int getId() {
        return id;
    }
    public String getTel() {
        return tel;
    }
}
public class StudentHashMap {
    public static void main(String[] args) {
        HashMap<String,Student> studentMap = new HashMap<>();
        studentMap.put("장성호", new Student(1, "010-1111-2222"));
        studentMap.put("장동건", new Student(2, "010-3333-4444"));
        studentMap.put("김혁기", new Student(3, "010-5555-6666"));
        Student student = studentMap.get("장동건");
        System.out.println(student.getTel());
    }
}
