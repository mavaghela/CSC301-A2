package a2;

import java.util.ArrayList;
import java.util.List;

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

    }

    public void registerObserver(Observer o)
    {

    }

    public void removeObserver(Observer o)
    {

    }

    public void notifyObserver()
    {

    }

    public String toString()
    {
        return "";
    }
}
