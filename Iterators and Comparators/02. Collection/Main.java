import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator listyIterator = null;
        String commands []= reader.readLine().split(" ");
        while(!commands[0].equals("END")){
           switch(commands[0]){
               case "Create":
                   String[] array = new String[commands.length-1];
                   for (int i = 1 ; i < commands.length; i++){
                       array[i-1] = commands[i];
                   }
                   listyIterator = new ListyIterator(array);
                   break;
               case "Move":
                   System.out.println(listyIterator.move());
                   break;
               case "HasNext":
                   System.out.println(listyIterator.hasNext());
                   break;
               case "Print":
                   listyIterator.print();
                   break;
               case "PrintAll":
                   listyIterator.printAll();
                   break;
           }

            commands[0] = reader.readLine().split(" ")[0];
        }


    }
}
