import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<WeaponType> weapons = new ArrayList<>();

        while(!input.equals("END")){
            String[] tokens = input.split(";");
            String command = tokens[0];
            String weaponType;
            String weaponName;
            int socketIndex;
            String gemType;
            WeaponType weapon;
            switch(command){
                case "Create":
                    weaponType = tokens[1];
                    weaponName = tokens[2];
                    weapon = new WeaponType(weaponName,weaponType);
                    weapons.add(weapon);
                    break;
                case "Add":
                    weaponName = tokens[1];
                    socketIndex = Integer.parseInt(tokens[2]);
                    gemType = tokens[3];
                    for (WeaponType w : weapons) {
                        if(w.getName().equals(weaponName)){
                            w.addGem(socketIndex,Gem.valueOf(gemType.toUpperCase()));
                        }
                    }
                    break;
                case "Remove":
                    weaponName = tokens[1];
                    socketIndex = Integer.parseInt(tokens[2]);
                    for (WeaponType w : weapons) {
                        if(w.getName().equals(weaponName)){
                            w.removeGem(socketIndex);
                        }
                    }
                    break;
                case "Print":
                    weaponName = tokens[1];
                    for (WeaponType w : weapons) {
                        if(w.getName().equals(weaponName)){
                            System.out.println(w);
                        }
                    }
                    break;
            }

            input = reader.readLine();
        }



    }
}
