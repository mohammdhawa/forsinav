interface Store {
	public void getProduct();
}


class Product implements Store {
	private String description;
	
	public Product(String description) {
		this.description = description;
	}
	
	@Override
	public void getProduct() {
		System.out.println(description);
	}
}


class Composite implements Store {
	private ArrayList<Store>products;
	private String description;
	
	public Composite(String description) {
		products = new ArrayList<>();
		this.description = description;
	}
	
	public void add(Store product) {
		products.add(product);
	}
	public void remove(Store product) {
		products.remove(product);
	}

	@Override
	public void getProduct() {
		System.out.println(description + ": ");
		for(Store product : products) {
			product.getProduct();
		}
	}
}

////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		
		Composite items = new Composite("Items");
		
		Composite samsung = new Composite("Samsung");
		Composite iphone = new Composite("Iphone");
		
		items.add(samsung);
		items.add(iphone);
		
		samsung.add(new Product("S23"));
		samsung.add(new Product("A-52 g5"));
		samsung.add(new Product("Note 9 pro"));
		
		iphone.add(new Product("Iphone 15"));
		iphone.add(new Product("Ipad 7"));
		
		items.getProduct();
	}

}