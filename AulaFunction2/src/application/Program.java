package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import model.services.ProductService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		ProductService ps = new ProductService();

		// double soma = ps.filterSum(list);

		// soma somente os produtos q iniciarem com 'T'
		double soma = ps.filterSum(list, p -> p.getName().toUpperCase().charAt(0) == 'T');

		System.out.println("Soma: " + String.format("%.2f", soma));

	}

}
