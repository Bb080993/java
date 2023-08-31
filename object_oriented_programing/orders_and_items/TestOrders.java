import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name="Mocha";
        item1.price=12.50;

        Item item2 = new Item();
        item2.name="Latte";
        item2.price=9.25;

        Item item3 = new Item();
        item3.name="Drip Coffee";
        item3.price=8.00;

        Item item4 = new Item();
        item4.name="Cappuccino";
        item4.price=10.75;
    
    
        // Order variables -- order1, order2 etc.

        Order order1= new Order();
        order1.name="Cindhuri";
        order1.ready=true;


        Order order2 = new Order();
        order2.name="Jimmy";
        order2.items.add(item1);
        order2.total=item1.price;
        order2.ready=true;

        Order order3 = new Order();
        order3.name="Noah";
        order3.items.add(item4);
        order3.total=item4.price;

        Order order4= new Order();
        order4.name="Sam";
        order4.items.add(item2);
        order4.total=item2.price;
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total+=(item2.price*2);

        //Print out order 1 and see what happens
        System.out.println(order1);
        //This is what we get: Order@7344699f....probably the space in memory of this object

        //Predict what will happen if you print out order1.total-it has not been set yet so perhaps an error, or null
        System.out.println(order1.total);
        //It defaulted to zero
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
