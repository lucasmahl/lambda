package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.00));
		list.add(new Product("HD Case", 80.90));

		// predicado recebe uma express�o lambda (fun��o anonima)
		// q recebe como argumento um produto p e resulta em booleano
		// Predicate<Product> pred = p -> p.getPrice() >= 100;
		// list.removeIf(pred);

		//list.removeIf(new ProductPredicate());
		
		// RETIRA QM FOR MAIOR Q 100
		// list.removeIf(p -> p.getPrice() >= 100);
		// list.removeIf(Product::staticProductPredicate); //referencia em Product
		// list.removeIf(Product::nonStaticProductPredicate); //referencia em product

		double min = 100.0;
		list.removeIf(p -> p.getPrice() >= min);

		for (Product p : list) {
			System.out.println(p);
		}

	}

}
