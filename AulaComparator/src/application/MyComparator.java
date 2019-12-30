package application;

import java.util.Comparator;

import entities.Product;

public class MyComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		//retornara negativo se o 1� for menor q o 2�
		//retornara positivo se o 1� for maior q o 2�
		//retornara 0 se forem iguais
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());//ordena os produtos por nome
	}

}
