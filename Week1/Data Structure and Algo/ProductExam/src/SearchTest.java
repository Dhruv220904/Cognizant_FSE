import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {

    // Linear Search
    public static Product linearSearch(Product[] products, String key) {

        for (Product product : products) {

            if (product.productName.equalsIgnoreCase(key)) {
                return product;
            }

        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String key) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(key);

            if (compare == 0) {

                return products[mid];

            } else if (compare < 0) {

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Tablet", "Electronics")

        };

        System.out.println("===== Linear Search =====");

        Product result = linearSearch(products, "Watch");

        if (result != null)
            System.out.println(result);
        else
            System.out.println("Product Not Found");

        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        System.out.println("\n===== Binary Search =====");

        Product result2 = binarySearch(products, "Watch");

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product Not Found");
    }
}