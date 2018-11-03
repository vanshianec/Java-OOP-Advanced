import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Comparator<Person> compareByName = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(Integer.compare(p1.getName().length(),(p2.getName().length())) == 0){
                    return Character.compare(p1.getName().toLowerCase().charAt(0),p2.getName().toLowerCase().charAt(0));
                }
                return Integer.compare(p1.getName().length(),p2.getName().length());
            }
        };
        Comparator<Person> compareByAge = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(),p2.getAge());
            }
        };

        TreeSet<Person> set1 = new TreeSet<>(compareByName);
        TreeSet<Person> set2 = new TreeSet<>(compareByAge);


        int N = Integer.parseInt(reader.readLine());

        while(N -- > 0){
            String [] stats = reader.readLine().split(" ");
            String name = stats[0];
            int age = Integer.parseInt(stats[1]);
            Person person = new Person(name,age);
            set1.add(person);
            set2.add(person);
        }

        for (Person person : set1) {
            System.out.println(person);
        }
        for (Person person : set2) {
            System.out.println(person);
        }






    }
}
