package a2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Inventory implements Observable
{
    protected List<Observer> observers;
    protected Product product;
    protected double availableQuantity;
    protected double backorderedQuantity;

    public Inventory(Product product)
    {
        this.product = product;
        observers = new ArrayList<Observer>();
    }

    protected void updateQuantities(double stock, double backord)
    {
        this.availableQuantity = stock;
        this.backorderedQuantity = backord;
        notifyObserver();
    }

    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        ((SalesOrder)o).flag = true;
    }

    public void notifyObserver()
    {
        Iterator<Observer> iter = observers.iterator();
        while ( iter.hasNext() ) {
            Observer obs = iter.next();
            if(obs instanceof SalesOrder && !((SalesOrder)obs).flag) {
                obs.update(availableQuantity, backorderedQuantity);
            }
            else if (obs instanceof ProductionOrder && backorderedQuantity != 0) {
                obs.update(availableQuantity, backorderedQuantity);
            }
        }
    }

    public String toString()
    {
        String inventoryString = String.format(
        "%d %s, Available %.1f, Backorders: %.1f",
        product.ID, product, availableQuantity, backorderedQuantity);

        Iterator<Observer> iter = observers.iterator();
        while ( iter.hasNext() ) {
            Observer obs = iter.next();
            if (obs instanceof ProductionOrder) {
                inventoryString += "\n" + obs;
            }
        }

        return inventoryString;
    }
}
