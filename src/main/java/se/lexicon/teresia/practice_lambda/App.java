package se.lexicon.teresia.practice_lambda;

import java.util.ArrayList;
import java.util.List;

public class App 
{

    public static void main( String[] args )
    {
    	List<Product>theProducts = new ArrayList<>();
        fillProducts(theProducts);
        
        System.out.println("Print all products");
        for (Product product : theProducts) {
			System.out.println(product);
		}
        System.out.println("Print all in stock");
        doThingsWithProducts(theProducts, p->p.getStock()>0,p->System.out.println(p));
        
        System.out.println("Products stats with a B");
        doThingsWithProducts(theProducts, p->p.getProductName().charAt(0)=='B',p->System.out.println(p));
        
        System.out.println("Price between 100 and 150 (excluding)");
        doThingsWithProducts(theProducts, p->p.getPrice()>=100 && p.getPrice()<=150,p->System.out.println(p));
        
        System.out.println("Raise Price and print");
        doThingsWithProducts(theProducts, p->p.getStock()<10,p->{p.setPrice(p.getPrice()*1.5);System.out.println(p);});

        
    }

    public static void doThingsWithProducts(List<Product> theList, Conditional theCondition, Action theAction)
    {
    	for (Product product : theList) {
			if(theCondition.test(product)) theAction.execute(product);
		}
    }

    
	private static void fillProducts(List<Product> products) {
		products.add(new Product("Apple", 50, 10));
		products.add(new Product("Pear", 155, 12));
		products.add(new Product("Banana", 140, 20));
		products.add(new Product("Orange", 85, 0));
		products.add(new Product("Peach", 100, 5));
		products.add(new Product("Pineapple", 250, 4));
		products.add(new Product("Mini orange", 55, 0));
	}
}
