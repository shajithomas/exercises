import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    public class Person {
        String name;
        int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    /*
     * The filter here is only called once since its looking for the 1st occurrence
     */
    @Test
    public void testFilterAndFindFirst() {
        List<String> list = List.of("a", "ab", "bc", "abcd");
        Optional<String> out = list.stream()
                .filter(e -> {
                    System.out.println("In filter " + e);
                    return (e.length() == 2);
                })
                .findFirst();
        System.out.println(out.get());
    }

    @Test
    public void testFilterAndCollect() {
        List<String> list = List.of("a", "ab", "bc", "abcd");
        List<String> out = list.stream()
                .filter(e -> {
                    System.out.println("In filter " + e);
                    return (e.length() == 2);
                })
                .collect(Collectors.toList());
        System.out.println(out);

        //returns the count of elements in the list
        System.out.println("------ counting ----------------");
        long count = list.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        //just use the count directly on stream
        System.out.println(list.stream().count());

        //filtered count
        System.out.println("----------------- Filtered count : should be 3 -------------------- ");
        System.out.println(
                list.stream()
                        .filter(e -> e.length() < 3)
                        .count());

        //return the name element with maximum length
        System.out.println("---------- element w/ max length ---------------");
        Optional<String> maxLen = list.stream()
                .collect(Collectors.maxBy((e1, e2) -> e1.length()- e2.length()));
        System.out.println(maxLen.get());

        //return the total length of all the strings
        System.out.println("---------- total length of all elements ---------------");
        System.out.println(
                list.stream()
                .collect(Collectors.summingInt(String::length))
        );

        //print the average length of all the strings
        System.out.println("---------- average length ---------------");
        System.out.println(
                list.stream()
                        .collect(Collectors.averagingInt(String::length))
        );
    }

    @Test
    public void testListAndMapFuncs() {
        List<Person> people = List.of (new Person("sam", 22), new Person("Charles", 33));
        System.out.println(people.toString());
        Map<String, Person> map = people.stream()
                .collect(Collectors.toMap(e -> e.name, e -> e));
        System.out.println(map);
        map.forEach( (k,v) -> System.out.println(k + ", value: " + v.age) );

    }
    @Test
    public void testSetFuncs() {
        Set<Person> people = Set.of (new Person("sam", 22), new Person("Charles", 33));
        System.out.println(people.toString());
        people.forEach( k -> System.out.println(k) );
        people.forEach(System.out::println);

    }

    /*
     toMap() with binaryOperator 3rd parameter to group them
     this will group into 2
     */
    @Test
    public void testMapFuncs() {
        Set<Person> people = Set.of (new Person("sam", 22), new Person("Charles", 33), new Person("wendy", 20));
        System.out.println(people.toString());
        Map<Boolean, String> byAge = people.stream()
                .collect(Collectors.toMap(p -> p.age <= 22, p -> p.name, (l, p) -> l + ","+ p));
        System.out.println(byAge);
    }

    /*
    group by age
     */
    @Test
    public void testMapGroupingFuncs() {
        Set<Person> people = Set.of (new Person("sam", 22), new Person("Charles", 33), new Person("wendy", 20));
        System.out.println(people.toString());
        Map<Integer, String> byAge = people.stream()
                .collect(Collectors.toMap(p -> (p.age/10)*10, p -> p.name, (l, p) -> l + ","+ p));
        System.out.println(byAge);

    }

}
