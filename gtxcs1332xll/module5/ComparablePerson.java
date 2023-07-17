import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ComparablePerson implements Comparable<ComparablePerson> {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public ComparablePerson(String name, int age) {
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
    public int compareTo(ComparablePerson o) {

        return age - o.getAge();
    }

    public static void main(String[] args) {
        ComparablePerson person1 = new ComparablePerson("Miguel", 31);

        ComparablePerson person2 = new ComparablePerson("Ivan", 43);

        System.out.println("person1's is younger than person2 " + String.valueOf(person1.compareTo(person2)));

        ComparablePerson person3 = new ComparablePerson("Adrianna", 15);

        ComparablePerson person4 = new ComparablePerson("Mary", 26);

        ComparablePerson person5 = new ComparablePerson("Andrew", 7);

        List<ComparablePerson> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        Collections.sort(persons);
        persons.stream().forEach(System.out::print);
    }

}
