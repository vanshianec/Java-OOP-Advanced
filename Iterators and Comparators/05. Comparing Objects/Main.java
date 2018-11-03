import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input[] = reader.readLine().split(" ");
        List<Person> people = new ArrayList<>();

        while(!input[0].equals("END")){
            String personName = input[0];
            int personAge = Integer.parseInt(input[1]);
            String personTown = input[2];
            Person person = new Person(personName,personAge,personTown);
            people.add(person);

            input = reader.readLine().split(" ");
        }
        int index = Integer.parseInt(reader.readLine());
        int numberOfEqualPeople = 1;
        for (int i=0;i<people.size();i++){
            if(i == index -1 ){
                continue;
            }
            if(people.get(i).compareTo(people.get(index-1)) == 0){
                numberOfEqualPeople++;
            }
        }
        if(numberOfEqualPeople == 1){
            System.out.println("No matches");
        }
        else{
            System.out.printf("%d %d %d%n",numberOfEqualPeople,people.size()-numberOfEqualPeople,people.size());
        }

    }
}
