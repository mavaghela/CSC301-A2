package a2;

public class SalesOrder implements Observer, DisplayElement
{
    private static int orderSequence;
    protected int ID;
    protected Customer customer;
    protected double quantity;
    protected Observable inventory;

    public SalesOrder(Customer customer, double quantity, Observable inventory)
    {
        this.customer = customer;
        this.quantity = quantity;
        this.inventory = inventory;

        // if (!ship(this.inventory.availableQuantity)) {
        //     this.inventory.registerObserver(this);
        // }
        // else{
            display(quantity);
        // }

        // update(this.inventory.availableQuantity, quantity);
    }

    public void update(double availQty, double ordQty)
    {
        //inventory.availableQuantity = availQty - ordQty;

    }

    public void display(double displayQuanity)
    {

        //System.out.print(String.format("Shipping Order# %d to %s, Product: %s, Quantity: %d", ID, customer, inventory.product, displayQuanity));
    }

    private boolean ship(double availableQuantity)
    {
        return quantity <= availableQuantity;
    }

    public String toString()
    {
        return "";
    }
}
