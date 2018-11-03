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
               if(p1.getName().compareTo(p2.getName()) == 0){
                   return Integer.compare(p1.getAge(),p2.getAge());
               }
               return p1.getName().compareTo(p2.getName());
            }
        };


        TreeSet<Person> set1 = new TreeSet<>(compareByName);
        HashSet<Person> set2 = new HashSet<>();


        int N = Integer.parseInt(reader.readLine());

        while(N -- > 0){
            String [] stats = reader.readLine().split(" ");
            String name = stats[0];
            int age = Integer.parseInt(stats[1]);
            Person person = new Person(name,age);
            set1.add(person);
            set2.add(person);
        }

        System.out.println(set1.size());
        System.out.println(set2.size());







    }
}
