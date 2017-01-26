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
    }

    protected void updatedQuantites(double stock, double backord)
    {
        this.availableQuantity = stock;
        this.backorderedQuantity = backord;
        notifyObserver();
    }

    public void registerObserver(Observer o)
    {
        observers.add(o);
        notifyObserver();
    }

    public void removeObserver(Observer o)
    {
        Iterator<Observer> iter = observers.listIterator();
        for ( ; iter.hasNext(); ) {
            Observer obs = iter.next();
            if (obs == o) {
                iter.remove();
            }
        }
    }

    public void notifyObserver()
    {
         for (Observer observer : observers) {
             observer.update(availableQuantity, backorderedQuantity);
         }
    }

    public String toString()
    {
        return "";
    }
}
