public class Student {
    private  int id;  //private 
    private  String name;
    private  double score;
    private  String gender;
    
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public Student(int id, String name, double score, String gender) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
    }
    Student(int id,String name, double score){

    }

}
