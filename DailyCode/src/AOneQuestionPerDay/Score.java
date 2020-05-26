package AOneQuestionPerDay;
import java.util.*;
class Student{
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class Score{

    public static void main(String[] args){
        Scanner  sc =new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int chioce = sc.nextInt();
            List<Student> list = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                String s =sc.next();
                int score = sc.nextInt();
                list.add(new Student(s,score));
            }

            if(chioce == 0){
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            }else{
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            for (Student s:list
                    ) {
                System.out.println(s.name+" "+s.score);
            }
        }
    }
}