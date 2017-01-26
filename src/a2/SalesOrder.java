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

        // Increment orderSequence and set ID
        orderSequence++;
        ID = orderSequence;

        Inventory inv = (Inventory) this.inventory;

        if (!ship(inv.availableQuantity)) {
            inv.registerObserver(this);
            inv.backorderedQuantity += this.quantity;
        }
        else{
            inv.availableQuantity -= this.quantity;
            display(quantity);
        }
    }

    public void update(double availQty, double ordQty)
    {
        Inventory inv = (Inventory) this.inventory;
        if (ship(availQty)){
            inv.availableQuantity -= this.quantity;
            inv.removeObserver(this);
            display(quantity);
        }

    }

    public void display(double displayQuanity)
    {
        String salesOrderString = String.format(
        "Shipping Order# %d to %s, Product: %s, Quantity: %.1f",
        ID, customer, ((Inventory)inventory).product, displayQuanity);

        System.out.println(salesOrderString);
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
