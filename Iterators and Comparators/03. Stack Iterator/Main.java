import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        String commands[] = reader.readLine().split("[, ]+");

        while(!commands[0].equals("END")){
            switch (commands[0]){
                case "Push":
                    for (int i = 1 ; i < commands.length;i++){
                        stack.push(Integer.parseInt(commands[i]));
                    }
                    break;
                case "Pop":
                    try{
                        stack.pop();
                    }
                    catch(NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

          commands = reader.readLine().split("[, ]+");
        }
        for (Integer element : stack) {
            System.out.println(element);
        }

        for (Integer element : stack) {
            System.out.println(element);
        }


    }
}
