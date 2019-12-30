package model.services;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {

	// soma todos produtos que estiverem dentro do criterio
	public double filterSum(List<Product> list, Predicate<Product> criteria) {
		double soma = 0.0;
		for (Product p : list) {
			if (criteria.test(p)) {
				soma += p.getPrice();
			}
		}
		return soma;

	}

}
