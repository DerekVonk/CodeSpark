package main;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregationKata {

    public static Map<String, Double> getAverageGradeByDepartment(Stream<Student> students) {
//        Map<String, Double> result = new HashMap<>();

//        Map<String, List<Student>> studentsPerDepartment = students.collect(Collectors.groupingBy(s -> s.getDepartment()));
//
//        BiConsumer<String, List<Student>> consumer =
//                (String key, List<Student> value) -> {
//                    System.out.println(key + " " + value.iterator().next().getGrade());
//
//                    result.put(key, value.iterator().next().getGrade());
//                };
//
//
//        String s = result.toString();
//
        // from students aggregate for each department

        // average of all students' grades => DoubleStream?

        // collect the average of these in a result

//        students.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e -> e.getGrade())));


        return students
                .collect(
                        Collectors.groupingBy(
                                Student::getDepartment,                             //collect grouping by department
                                Collectors.averagingDouble(Student::getGrade)));
    }

}
