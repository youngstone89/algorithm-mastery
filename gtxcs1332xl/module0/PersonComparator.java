import java.util.Comparator;
public class PersonComparator implements Comparator<Person> {
    
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().length() - p2.getName().length();
    }
    public static void main(String[] args) {
        System.err.println("hi");
    }
    
}
