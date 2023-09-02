import java.util.ArrayList;

public class Order{
    private String name;
    private boolean isReady;
    private ArrayList<Item> items;

    public Order(){
        this.name="Guest";
        this.items=new ArrayList<Item>();
    }
    public Order(String name){
        this.name=name;
        this.items=new ArrayList<Item>();
    }
    public void addItem(Item item){
        items.add(item);
    }
    public String getStatusMessage(){
        if(isReady){
            return "Your order is ready.";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public double getOrderTotal(){
        double sum=0;
        for(Item item:items){
            double price=item.getPrice();
            sum+=price;
        }
        return sum;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public boolean getIsReady(){
        return isReady;
    }
    public void setIsReady(boolean isReady){
        this.isReady=isReady;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items){
        this.items=items;
    }
    public void display(){
        System.out.println("Customer name: " + this.name);
        for(Item item:items){
            System.out.println(item.getName()+ "-" + item.getPrice());
        }
        System.out.println("Total: " +  getOrderTotal());
    }

}