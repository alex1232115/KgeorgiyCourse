package technologies.inputOutput.ReaderWriter;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {

            Person p = new Person("Sam", 33, 178, true);
            oos.writeObject(p);
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());

            Person p1 = (Person) ois.readObject();
            System.out.printf("Name: %s \t Age: %d \n", p1.getName(), p1.getAge());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double height;
    private boolean married;

    Person(String n, int a, double h, boolean m){

        name=n;
        age=a;
        height=h;
        married=m;
    }
    String getName() {return name;}
    int getAge(){ return age;}
    double getHeight(){return height;}
    boolean getMarried(){return married;}
}