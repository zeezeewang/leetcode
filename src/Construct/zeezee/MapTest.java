package Construct.zeezee;


import java.util.*;

public class MapTest {

    public static void main(String[] args) {

        final List<Student> students = getStudents();

        final Map<String, String> result = checkIn(students);

        reportCheckIns(result);

    }

    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", "1"));
        students.add(new Student("李四", "2"));
        students.add(new Student("王五", "3"));
        students.add(new Student("赵六", "4"));
        students.add(new Student("罗七", "5"));
        return students;
    }

    private static Map<String, String> checkIn(final List<Student> students) {
        final Map<String, String> result = new HashMap<>();
        for (final Student student : students) {
            System.out.println("点名：" + student.getName());

            final Scanner console = new Scanner(System.in);
            final String response = console.next();
            result.put(student.getName(), response);
        }
        return result;
    }

    private static void reportCheckIns(final Map<String, String> result) {
        System.out.println("点名结果：");
        System.out.println(result);
        System.out.println("------------------------------------------------------------------------");
    }

}
