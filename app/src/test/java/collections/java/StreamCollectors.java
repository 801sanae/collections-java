package collections.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamCollectors {
        

    @Test
    @DisplayName("toList")
    public void toList(){
        List<Person> people = List.of(
            new Person("minyoung"),
            new Person("matthew"),
            new Person("jun")
        );

        List<String> names = people.stream()
            .map(w -> w.name)
            .collect(Collectors.toList());

        assertEquals(3, names.size());
        assertEquals("minyoung", names.get(0));
    }

    @Test
    @DisplayName("joining")
    public void joining(){
        List<Object> things = List.of("name", 23, "seoul");
        String result = things.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        assertEquals("name, 23, seoul", result);
    }

    @Test
    @DisplayName("sumingInt")
    public void sumingInt(){

        List<Employee> employees = getEmployees();

        int sumSalary = employees.stream()
                                    .collect(Collectors.summingInt(Employee::salary));


        assertEquals(66350, sumSalary);
    }


    @Test
    @DisplayName("groupingBy")
    public void groupingBy(){
        List<Employee> employees = getEmployees();

        Map<String, List<Employee>> byDept = employees.stream()
                                                        .collect(Collectors.groupingBy(Employee::department));

        System.out.println(byDept.get("it").toString());
        assertEquals(2, byDept.get("it").size());

    }

    @Test
    @DisplayName("groupingByLiskePrivot")
    public void groupingByLiskePrivot(){
        List<Employee> employees = getEmployees();

        // Map<String, List<Employee>> byDept = employees.stream()
        //                                                 .collect(Collectors.groupingBy(Employee::department));

        Map<String, Integer> totalByDept = employees.stream()
                                                        .collect(Collectors.groupingBy(Employee::department, Collectors.summingInt(Employee::salary)));

        System.out.println(totalByDept.get("it")); //15300
        System.out.println(totalByDept.get("support")); //20450

        assertEquals(15300, totalByDept.get("it"));
        assertEquals(20450, totalByDept.get("support"));
    }

    private static final Integer PASS_THRESHOLD = 50;

    @Test
    @DisplayName("partitioningBy")
    public void partitioningBy(){
        List<Student> students = List.of(
            new Student("minyoung1", 80),
            new Student("minyoung2", 30),
            new Student("minyoung3", 40),
            new Student("minyoung4", 50),
            new Student("minyoung5", 55),
            new Student("minyoung6", 80)
        );

        Map<Boolean, List<Student>> passingFailing = students.stream()
                                                                .collect(Collectors.partitioningBy(s->s.grade >= PASS_THRESHOLD));

        assertEquals(4, passingFailing.get(true).size());
    }    

    private List<Employee> getEmployees() {
        List<Employee> employees = List.of(
            new Employee("minyoung1", 3150, "sales"),
            new Employee("minyoung2", 4150, "it"),
            new Employee("minyoung3", 5150, "support"),
            new Employee("minyoung4", 6150, "sales"),
            new Employee("minyoung5", 7150, "support"),
            new Employee("minyoung6", 8150, "support"),
            new Employee("minyoung7", 9150, "management"),
            new Employee("minyoung8", 11150, "it"),
            new Employee("minyoung9", 12150, "sales")
        );
        return employees;
    }    

    /**
     * Employee
String name, Integer salary, String department
     */
    public record Employee(String name, Integer salary, String department
    ) {
    }    

    /**
     * Person
String name     */
    public record Person(String name) {
    }

    /**
     * Student
String name, Integer grade
     */
    public record Student(String name, Integer grade
    ) {
    }
}
