import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().length() - p2.getName().length();
    }

    public static void main(String[] args) {
        System.err.println("hi");
        Person p1 = new Person("Ivan", 1);
        Person p2 = new Person("Mary", 2);

        PersonComparator pc = new PersonComparator();
        int result = pc.compare(p1, p2);
        System.out.println("person1 and person2 compare by name laength result: " + result);

        ArrayList<Person> ps = new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        Collections.sort(ps, new PersonComparator());

        for (Person p : ps) {
            System.out.println(p);
        }
    }
}
