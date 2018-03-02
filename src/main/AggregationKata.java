package main;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class AggregationKata {

    public static Map<String, Double> getAverageGradeByDepartment(Stream<Student> students) {
        Map<String, Double> result = new HashMap<>();

        // from students aggregate for each department

//        Map<String, List<Student>> studentsPerDepartment = students.collect(Collectors.groupingBy(s -> s.getDepartment()));

//        BiConsumer<String, List<Student>> consumer =
//                (String key, List<Student> value) -> {
//                    System.out.println(key + " " + value.iterator().next().getGrade());
//
//                    result.put(key, value.iterator().next().getGrade());
//                };
//
//
//        String s = result.toString();

        BiFunction

        students.reduce(new HashMap<String, List<Student>>, )



        int a = 9;

        // average of all students' grades => DoubleStream?

        // collect the average of these in a result

        return null;
    }

}
