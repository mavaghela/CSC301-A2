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
    }

    public void update(double availQty, double ordQty)
    {
      // some code
    }

    public void display(double displayQuanity)
    {
      // some code
    }

    private boolean ship(double availableQuantity)
    {
        return false;
    }
    public String toString()
    {
        return "";
    }
}
