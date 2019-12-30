package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			//PIPELINE PRA ACHA A SOMA DOS PRE�OS			
			double avg = list.stream()
					.map(p->p.getPrice())//pega somente os pre�os
					.reduce(0.0, (x,y)->x+y)/list.size();

			System.out.println("Pre�o m�dio: " + String.format("%.2f", avg));
			
			//comparador
			Comparator<String> comp = (s1, s2)->s1.toUpperCase().compareTo(s2.toUpperCase());
			
			//nomes dos produtos com pre�o abaixo da m�dia
			List<String> nomes = list.stream()
					.filter(p->p.getPrice()<avg)
					.map(p->p.getName())	          //map pra pegar o nome de cada produto
					.sorted(comp.reversed())          //reversed ordena decrescente
					.collect(Collectors.toList());    //transforma stream em lista
			
			//mostra os nomes na tela
			nomes.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}

}
