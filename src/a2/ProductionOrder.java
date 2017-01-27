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

		// Increment orderSequence and set ID
		orderSequence++;
		ID = orderSequence;
		Inventory inv = (Inventory) this.inventory;
		inv.registerObserver(this);
	}

	public void update(double availQty, double ordQty)
	{
		if(ordQty >= minQuantity){
			Inventory inv = (Inventory) this.inventory;
			inv.updatedQuantites(ordQty, 0);
			display(ordQty);
		}
	}

	public void display(double dispQty)
	{
		String prodOrderString = String.format(
		"Production Order# %d, item %s, Quantity: %.1f",
		ID, ((Inventory)inventory).product, dispQty);

		System.out.println(prodOrderString);
	}

	public String toString()
	{
		Inventory inv = (Inventory) this.inventory;
		String prodOrderString = String.format(
		"[PO%d %s %.1f]",
		ID, inv.product, minQuantity);

		return prodOrderString;
	}
}
