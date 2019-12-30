package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.00));
		list.add(new Product("HD Case", 80.90));

		//map � uma fun��o, que aplica uma fun��o, a todos elementos de uma stream
		//map funciona apenas pra stream
		//List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());//collect converte a stream novamente pra lista
		
		//static
		//List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());//collect converte a stream novamente pra lista

		//� static
		//List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());//collect converte a stream novamente pra lista
		
		//lambda declarado
		//Function<Product, String> func = p->p.getName().toUpperCase();
		//List<String> names = list.stream().map(func).collect(Collectors.toList());//collect converte a stream novamente pra lista

		//lambda inline
		List<String> names = list.stream().map(p->p.getName().toUpperCase()).collect(Collectors.toList());//collect converte a stream novamente pra lista
		
		names.forEach(System.out::println);

	}

}
