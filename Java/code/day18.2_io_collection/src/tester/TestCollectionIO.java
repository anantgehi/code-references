package tester;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Product;

import custom_exception.ProductHandlingException;

import static utils.SerDeSerUtils.*;

public class TestCollectionIO {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name to restore products from");
			String fileName = sc.nextLine();
			// Restore products
			Map<Integer, Product> products = restoreProducts(fileName);
			System.out.println("restored products ...."+products);
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Options 1. Update Price 2. Display all 3. Display products sorted as per date 4.Remove a Product 5.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter product id n price offset");
						Product product = products.get(sc.nextInt());// int --> Integer
						if (product == null)
							throw new ProductHandlingException("Invalid Product ID!!!!");
						// => product found
						product.setPrice(product.getPrice() + sc.nextDouble());
						System.out.println("price updated....");
						break;
					case 2:
						System.out.println("All products ");
						products.forEach((k, v) -> System.out.println(v));
						break;
					case 3:
						// HM ---> values ---> Collection<Product> ---> stream() --> Stream<Product> -->
						// sorted(comp) --> forEach : display
						System.out.println("Sorted products : ");
						products.values().stream().sorted(Comparator.comparing(Product::getManufactureDate))
								.forEach(System.out::println);
						break;

					case 4: // remove product
						System.out.println("Enter product ID");
						product = products.remove(sc.nextInt());
						if (product == null)
							throw new ProductHandlingException("Product can't be removed : Invalid Product ID!!!!");
						System.out.println("removed " + product);
						break;
					case 5:
						exit = true;
						// store product details before teminating from java app
						storeProductDetails(products, fileName);
						System.out.println("stored products....");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
