import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
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
            String weaponName2;
            int socketIndex;
            String gemType;
            WeaponType weapon;
            WeaponType w1;
            WeaponType w2;
            WeaponType better;
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
                case "Author":
                    Annotation a = WeaponType.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Author: "+((CustomAnnotation) a).author());
                    break;

                case "Revision":
                    Annotation a2 = WeaponType.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Revision: "+((CustomAnnotation) a2).revision());
                    break;

                case "Description":
                    Annotation a3 = WeaponType.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Class description: "+((CustomAnnotation) a3).description());
                    break;

                case "Reviewers":
                    Annotation a4 = WeaponType.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Reviewers: "+String.join(", ",((CustomAnnotation) a4).reviewers()));
                    break;
                case "Compare":
                    weaponName = tokens[1];
                    weaponName2 = tokens[2];
                     w1 = null;
                     w2 = null;
                     better = null;
                    for (WeaponType w : weapons) {
                        if(w.getName().equals(weaponName)){
                            w1 = w;
                        }
                        else if (w.getName().equals(weaponName2)){
                            w2 = w;
                        }
                    }
                    if(w1.compareTo(w2) >= 0){
                        better = w1;
                    }
                    else{
                        better = w2;
                    }
                    System.out.println(better + String.format(" (Item Level: %.1f)",better.getAveragePowerLevel()));
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
