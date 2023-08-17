package crazyFitness.services.testProduct;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import crazyFitness.model.Product;
import crazyFitness.services.ProductService;
import crazyFitness.services.exceptions.ServiceException;

class TestGetAllProducts {
 @Test
 void testGetAllProductsSuccess() {
	 try {
		 ProductService productService = new ProductService();
		List<Product> products = productService.getAllProductsList(); 
		for(Product product : products) {
			System.out.println(product.getProductId() + " - " + product.getProductImage()+ " - " + product.getProductName() 
			+ " - "+ product.getProductPrice() + " - " +product.getProductDescrption());
		}
	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}
	 
 }
 
}
