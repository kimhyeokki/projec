import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Student02{
    private String name,department,id;
    private double grade;
    public Student02(){

    }
    public Student02(String name, String department, String id, double grade) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public String getId() {
        return id;
    }
    public double getGrade() {
        return grade;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
        @Override
    public String toString() {
        return "Student02 [name=" + name + ", department=" + department + ", id=" + id + ", grade=" + grade + "]";
    }


}

public class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student02> stinfo = new ArrayList<>();
        stinfo.add(new Student02("장성호", "java", "01", 3.0));
        stinfo.add(new Student02("장동건", "c#", "02", 2.5));
        stinfo.add(new Student02("김혁기", "python", "03", 4.3));
        while(true){
            String name01 = scanner.nextLine();
            if(name01.equals("그만"))
            break;
            if(name01.equals(stinfo.get(0).getName())){
                System.out.println(stinfo.get(0));
            }
            else if(name01.equals(stinfo.get(1).getName())){
                System.out.println(stinfo.get(1));
            } else if(name01.equals(stinfo.get(2).getName())){
                System.out.println(stinfo.get(2));
            }else{
                System.out.println("없는 사람입니다.");
            }
        }

        HashMap<String,Student02> studentList = new HashMap<>();
        studentList.put("장성호", new Student02("장성호", "java", "01", 3.0));
        studentList.put("장동건", new Student02("장동건", "c#", "02", 2.5));
        studentList.put("김혁기", new Student02("김혁기", "python", "03", 4.3));
        //  Set<String> set = studentList.keySet();
        //  Iterator<String> it = set.iterator();
        //  Student02 inf0 = studentList.get(it.next());
        //  while(it.hasNext()){
        //     System.out.println(studentList.get(it.next()).toString());
        //  }
         while (true) {
            System.out.println("학생이름을 입력하시오");
            String name = scanner.nextLine();
            if(name.equals("그만"))
            break;
            if(studentList.get(name)==null){
                System.out.println("없는 사람입니다.");
            }else{
                System.out.println(studentList.get(name).toString());
            }
         }

    }
    //Quiz05 학생이름과 점수를 가지는 HashMap을 작성하고, 5명의 학생 이름과 점수를 입력하시어
    //이때 점수가 3.8이상인 학생을 출력해보기
}

