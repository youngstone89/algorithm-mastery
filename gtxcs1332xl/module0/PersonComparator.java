import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonComparator implements Comparator<ComparablePerson> {

    @Override
    public int compare(ComparablePerson p1, ComparablePerson p2) {
        return p1.getName().length() - p2.getName().length();
    }

    public static void main(String[] args) {
        System.err.println("hi");
        ComparablePerson p1 = new ComparablePerson("Ivan", 1);
        ComparablePerson p2 = new ComparablePerson("Mary", 2);

        PersonComparator pc = new PersonComparator();
        int result = pc.compare(p1, p2);
        System.out.println("person1 and person2 compare by name laength result: " + result);

        ArrayList<ComparablePerson> ps = new ArrayList<ComparablePerson>();
        ps.add(p1);
        ps.add(p2);
        Collections.sort(ps, new PersonComparator());

        for (ComparablePerson p : ps) {
            System.out.println(p);
        }
    }
}
