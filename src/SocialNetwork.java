/*
Create an in-memory social network as follows
You are in charge of designing a small, in-memory social network, with the basic functionality of adding friendship
between two people via an AddFriendship function, and a GetSuggestedFriends function for a particular user in the
network. The criteria is to pick someone with whom the given user has the most number of friends in common.

Start by discussing the most suitable data structure, and implement all the objects and functions.

AddFriendShip(Person a, Person b) : This will add connection between two in the network

List<Person> GetSuggestedFriends(Person a) : This will check with everyone and will return the list of people with most common friends
*/

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SocialNetwork {
    // Store the network as a graph using adjacency list
    List<Person> people = new ArrayList<>();

    public void initializeNetwork() {
        Person p = new Person(0, "P0");
        people.add(p.ID, p);
        p = new Person(1, "P1");
        people.add(p.ID, p);
        people.add(2, new Person(2, "P2"));
        people.add(3, new Person(3, "P3"));
        people.add(4, new Person(4, "P4"));
        people.add(5, new Person(5, "P5"));
        people.add(6, new Person(6, "P6"));
        people.add(7, new Person(7, "P7"));

    }

    public void addFriendShip(Person A, Person B) {
        A.friends.add(B);

    }

    public List<Person> getFriendSuggestions(Person A, int maxSuggest) {
        Map<Person, Integer> suggests = new HashMap<>();
        for (Person friend : A.friends) {
            for (Person person : friend.friends) {
                if (!A.friends.contains(person)) { //skip if person is already a friend of A
                    suggests.merge(person, 1, Integer::sum);
                }
            }
        }
        List<Person> sFriends = new ArrayList<>();
        List<Map.Entry<Person, Integer>> sList = new ArrayList<>(suggests.entrySet());
        sList.sort((e1,e2) -> e2.getValue() - e1.getValue() );

        for ( int i=0; (i < sList.size() && i < maxSuggest); i++) {
            sFriends.add(sList.get(i).getKey());
        }
        return sFriends;
    }

    public void listAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public  class Person {
        int ID;
        String name;
        Set<Person> friends;

        Person(int id, String name) {
            this.ID = id;
            this.name = name;
            friends = new HashSet<>();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "ID=" + ID +
                    ", name='" + name + '\'' +
                    ", friends=" + friends +
                    '}';
        }
    }

    public static class UnitTests{
        @Test
        public void testAddFriendShip() {
            SocialNetwork network = new SocialNetwork();
            network.initializeNetwork();
            network.listAll();
        }

        @Test
        public void getFriendSuggestions() {
            SocialNetwork network = new SocialNetwork();
            network.initializeNetwork();

            List<Person> people = network.people;

            addFriends1(network, people);

            // Friend suggestion should give 4,6
            List<Person> expected = new ArrayList<>();
            expected.add(network.people.get(4));

            List<Person> suggestions = network.getFriendSuggestions(people.get(0),1);
            suggestions.forEach(System.out::println);
            Assert.assertEquals(expected, suggestions);

            System.out.println("================== Next Test ==================================");

            expected.add(network.people.get(6));
            suggestions = network.getFriendSuggestions(people.get(0),3);
            suggestions.forEach(System.out::println);
            Assert.assertEquals(expected, suggestions);

        }

        private void addFriends1(SocialNetwork network, List<Person> people) {
            network.addFriendShip(people.get(0), people.get(2));
            network.addFriendShip(people.get(0), people.get(3));
            network.addFriendShip(people.get(0), people.get(5));

            network.addFriendShip(people.get(1), people.get(2));

            network.addFriendShip(people.get(2), people.get(3));
            network.addFriendShip(people.get(2), people.get(4));
            network.addFriendShip(people.get(2), people.get(5));

            network.addFriendShip(people.get(3), people.get(4));
            network.addFriendShip(people.get(3), people.get(6));

            network.addFriendShip(people.get(4), people.get(7));
            network.addFriendShip(people.get(4), people.get(5));
        }

    }
}
