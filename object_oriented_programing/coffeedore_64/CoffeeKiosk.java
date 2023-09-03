import java.util.ArrayList;

public class CoffeeKiosk{
    private ArrayList<Item>menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk(){
        this.menu= new ArrayList<Item>();
        this.orders= new ArrayList<Order>();
    }

    //Getters and Setters
    public ArrayList<Item> getMenu(){
        return menu;
    }
    public void setMenu(ArrayList<Item> menu){
        this.menu=menu;
    }
    public ArrayList<Order> getOrder(){
        return orders;
    }
    public void setOrder(ArrayList<Order> orders){
        this.orders=orders;
    }

    //Methods
    public void addMenuItem(String name, double price){
        Item itemName= new Item(name, price);
        itemName.setIndex(Item.getIndex());
        menu.add(itemName);
    }
    public void displayMenu(){
        for(Item item:menu){
            System.out.println(item.getIndex()+ " " + item.getName() + "--"+ "$"+item.getPrice() );
        }
    }
        public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order nextOrder= new Order(name);
        // Show the user the menu, so they can choose items to add.
        cafeMenu.displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            if Integer.parseInt(itemNumber)==Item.index(nextOrder.addItem())

            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
        
    }




}