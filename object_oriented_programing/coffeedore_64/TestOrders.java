import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Instantiating each item
        // Item item1 = new Item("Mocha", 12.50);

        // Item item2 = new Item("Latte", 9.25);

        // Item item3 = new Item("Drip Coffee", 8.00);

        // Item item4 = new Item("Cappuccino", 10.75);

        // //This gave me "Mocha"
        // System.out.println(item1.getName());    

        // //Instantiating orders with no name and names

        // Order guest1=new Order();
        // Order guest2=new Order();
        // Order order1=new Order("Jimmy");
        // Order order2=new Order("Brittany");
        // Order order3= new Order("Ellen");

        // //This gave me "Guest"
        // System.out.println(guest1.getName());
        // //This gave me "Jimmy"
        // System.out.println(order1.getName());


        // //Added 2 or more items to each guests order list
        // guest1.addItem(item1);
        // guest1.addItem(item2);
        // guest2.addItem(item1);
        // guest2.addItem(item3);
        // order1.addItem(item4);
        // order1.addItem(item3);
        // order1.addItem(item2);
        // order2.addItem(item4);
        // order2.addItem(item4);
        // order3.addItem(item1);
        // order3.addItem(item4);

        // //Get status message for isReady=false
        // System.out.println(guest1.getStatusMessage());

        // //Changed isReady=true
        // guest1.setIsReady(true);

        // //Changed the status
        // System.out.println(guest1.getStatusMessage());

        // //Tested getOrderTotal. Sums were correct
        // System.out.println(order1.getOrderTotal());
        // System.out.println(guest1.getOrderTotal());

        // //Display all orders
        // guest1.display();
        // guest2.display();
        // order1.display();
        // order2.display();
        // order3.display();

        //Initialize menu
        CoffeeKiosk cafeMenu=new CoffeeKiosk();
        cafeMenu.addMenuItem("cookie", 3.25);
        cafeMenu.addMenuItem("Mocha", 12.50);
        cafeMenu.addMenuItem("Latte", 9.25);
        cafeMenu.addMenuItem("Drip Coffee", 5.50);
        cafeMenu.addMenuItem("Cappuccino", 6.75);
        cafeMenu.displayMenu();



    }
}
