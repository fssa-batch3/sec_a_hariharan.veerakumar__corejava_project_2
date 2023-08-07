package crazyFitness.services.testProduct;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import crazyFitness.services.ProductService;
import crazyFitness.services.exceptions.ServiceException;

public class TestDeleteProduct {
	@Test
	public void testValidDelete() {
		ProductService productService = new ProductService();
		try {
			assertTrue(productService.ProductDelete(2));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInValidIDDelete() {
		ProductService productService = new ProductService();
		try {
			assertFalse(productService.ProductDelete(2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNegativeIdDelete() {
		ProductService productService = new ProductService();
		try {
			assertFalse(productService.ProductDelete(-2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}