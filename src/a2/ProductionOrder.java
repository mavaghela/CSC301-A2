package a2;

public class ProductionOrder implements Observer, DisplayElement
{
	private static int orderSequence;
    protected int ID;
	protected double minQuantity;
	protected Observable inventory;

	public ProductionOrder(int minQty, Observable inventory)
	{
		this.minQuantity = minQty;
		this.inventory = inventory;
	}

	public void update(double availQty, double ordQty)
	{

	}

	public void display(double dispQty)
	{

	}

	public String toString()
	{

		// String stringOrder = String.format("Production Order# %d,
		// item %s, Quantity: %d", ID, name);

		return "";
	}
}
