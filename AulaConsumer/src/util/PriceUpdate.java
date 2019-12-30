package util;

import java.util.function.Consumer;

import entities.Product;

public class PriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		// soma 10%
		p.setPrice(p.getPrice() * 1.10);

	}

}
