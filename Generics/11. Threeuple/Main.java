import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        String firstName = firstLine.split(" ")[0]+ " " + firstLine.split(" ")[1];
        String secondName = firstLine.split(" ")[2];
        String town = firstLine.split(" ")[3];
        String secondLine = reader.readLine();
        String name = secondLine.split(" ")[0];
        int liters = Integer.parseInt(secondLine.split(" ")[1]);
        boolean drunkOrNot = secondLine.split(" ")[2].equals("drunk");
        String thirdLine = reader.readLine();
        String personName = thirdLine.split(" ")[0];
        double d = Double.parseDouble(thirdLine.split(" ")[1]);
        String bank = thirdLine.split(" ")[2];

        Threeuple<String,String,String> t1 = new Threeuple<>(firstName,secondName,town);
        Threeuple<String,Integer,Boolean> t2 = new Threeuple<>(name,liters,drunkOrNot);
        Threeuple<String,Double,String> t3 = new Threeuple<>(personName,d,bank);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }


}


