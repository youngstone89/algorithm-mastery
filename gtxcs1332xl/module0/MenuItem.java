public class MenuItem implements Comparable<MenuItem> {
    private String name;
    private int price;

    
    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public int compareTo(MenuItem o) {
        return this.price - o.price;
    }
    public static void main(String[] args) {
        MenuItem item1 = new MenuItem("Burger", 100);
        MenuItem item2 = new MenuItem("cheese", 1);

        System.out.println(item1.compareTo(item2) < 0);
        System.out.println(item1.compareTo(item2) == 0);
        System.out.println(item1.compareTo(item2) > 0);

    }    
}
