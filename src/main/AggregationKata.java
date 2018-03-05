package main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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

//        students.collect(Collectors.groupingBy(Student::getDepartment))
//                .entrySet()  // Map<String, Collection<Student>
//                .stream()
//                .map(
//                        e -> new AbstractMap.SimpleEntry<String, Double>(
//                                e.getKey(), // is the string of the grouped department
//                                e.getValue().stream().mapToDouble(Student::getGrade) // streams each value which is a List<Student> and gets all their Grades
//                                        .average().getAsDouble()                  // then calculates the average, and returns them as Double
//                        )
//                )
//                .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue())); // On this map you'll have to collect them to the result map.
//    }


        return students
                .collect(
                        Collectors.groupingBy(
                                Student::getDepartment,                             //collect grouping by department
                                Collectors.averagingDouble(Student::getGrade))
                );
    }

    public static Map<String, Long> getNumberOfStudentsByDepartment(Stream<Student> students) {
        return students
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.counting()));
    }

    public static Map<String, List<String>> getStudentNamesByDepartment(Stream<Student> students) {
        return students
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));
        }

    public static Map<String, Map<Student.Gender, Long>> getTheNumberOfStudentsByGenderForEachDepartment(Stream<Student> students) {

        return null;

    }

}
