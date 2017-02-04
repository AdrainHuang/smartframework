package thread;

/**
 * Created by AdrainHuang on 2017/2/4.
 */
public class ClientThread extends Thread {

	private ProductService productService;

	public ClientThread(ProductService productService) {
		this.productService = productService;
	}


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		productService.updateProductPrice(1, 300);
	}

	public static void main(String[] args) {
//		ProductService productService = new ProductServiceImpl();
//		productService.updateProductPrice(1,3000);

//		ClientThread clientThread = new ClientThread(productService);
//		clientThread.start();

		for (int i = 0; i < 1000; i++) {
			ProductService productService = new ProductServiceImpl();
			ClientThread clientThread = new ClientThread(productService);
			clientThread.start();
		}
	}
}
