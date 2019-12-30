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

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Caminho do excel: ");
		String path = sc.nextLine();

		System.out.print("Salario minimo: ");
		Double min = sc.nextDouble();
		sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employee> employee = new ArrayList<Employee>();

			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(";");
				employee.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			// EMAILS DOS FUNCIONARIOS Q RECEBEM MAIS DO QUE 2000(MIN)
			List<String> emailsMin = employee.stream().filter(e -> e.getSalario() > min).map(e -> e.getEmail())
					.sorted(comp) // ordena emails por ordem alfabetica
					.collect(Collectors.toList());

			// mostra os emails na tela
			emailsMin.forEach(System.out::println);

			// SOMA DOS SALARIOS DOS FUNCIONARIOS QUE INICIAM COM M
			Double sum = employee.stream().filter(e -> e.getNome().toUpperCase().charAt(0) == 'M')
					.map(e -> e.getSalario()).reduce(0.0, (a, b) -> a + b);

			System.out.println("Soma total do salário dos funcionários q iniciam com M: " + String.format("%.2f", sum));

		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();

	}

}
