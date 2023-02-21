import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {

        return age - o.getAge();
    }

    public static void main(String[] args) {
        Person person1 = new Person("Miguel", 31);

        Person person2 = new Person("Ivan", 43);

        Person person3 = new Person("Adrianna", 15);

        Person person4 = new Person("Mary", 26);

        Person person5 = new Person("Andrew", 7);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        Collections.sort(persons);
        persons.stream().forEach(System.out::print);
    }

}
