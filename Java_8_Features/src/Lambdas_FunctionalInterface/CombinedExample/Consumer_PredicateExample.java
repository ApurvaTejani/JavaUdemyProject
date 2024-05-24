package Lambdas_FunctionalInterface.CombinedExample;

import Lambdas_FunctionalInterface.Student.Student;
import Lambdas_FunctionalInterface.Student.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Consumer_PredicateExample {
    Predicate<Student> p1 = s -> s.getGpa() > 3.8;
    Predicate<Student> p2 = s -> s.getGradeLevel() > 3;
    BiConsumer<String, List<String>> bc = (name, activities) -> System.out.println(name + " does " + activities);
    Consumer<Student> c1 = s -> {
        if (p1.and(p2).test(s))
            bc.accept(s.getName(), s.getActivities());
    };

    public void printNameAndActivity(List<Student> studList) {
        studList.forEach(c1);
    }

    public static void main(String[] args) {
        List<Student> studList = StudentDatabase.getAllStudents();
        new Consumer_PredicateExample().printNameAndActivity(studList);
    }
}
