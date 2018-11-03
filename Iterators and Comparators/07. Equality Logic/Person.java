import java.util.Objects;

public class Person {
    private String name;
    private int age;


    public Person(String name,int age){
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person)o;
        return this.getName().equals(p.getName()) && this.getAge() == p.getAge();
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public String toString(){
        return String.format("%s %d",this.name,this.age);
    }
}
