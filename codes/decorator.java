public interface CoffeeShop {
	public void makeCoffee();
}


class CoffeeCup implements CoffeeShop {
	
	@Override
	public void makeCoffee() {
		System.out.println("Cup of Coffee");
	}
}

/////////////////////////////////////////////////////////////

abstract class CoffeeDecorator implements CoffeeShop {
	private CoffeeShop coffee;
	
	public CoffeeDecorator(CoffeeShop coffee) {
		this.coffee = coffee;
	}

	public CoffeeShop getCoffee() {
		return coffee;
	}
}


class Milk extends CoffeeDecorator {
	
	public Milk(CoffeeShop coffee) {
		super(coffee);
	}
	
	public void addMilk() {
		System.out.println("Added Milk.");
	}
	
	@Override
	public void makeCoffee() {
		getCoffee().makeCoffee();
		addMilk();
	}
}


class Creame extends CoffeeDecorator {
	
	public Creame(CoffeeShop coffee) {
		super(coffee);
	}
	
	public void addCreame() {
		System.out.println("Added Creame.");
	}
	
	@Override
	public void makeCoffee() {
		getCoffee().makeCoffee();
		addCreame();
	}
}


///////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		
		CoffeeShop cup = new CoffeeCup();
		
		CoffeeShop milk = new Milk(cup);
		
		CoffeeShop creame = new Creame(cup);
		
		milk.makeCoffee();
		creame.makeCoffee();
	}
}

///////////////////////////////////////////////////