public interface IColor {
	public void colorize_shape();
}


class RED implements IColor {
	@Override
	public void colorize_shape() {
		System.out.println("Colorized with RED color");
	}
}


class BLUE implements IColor {
	@Override
	public void colorize_shape() {
		System.out.println("Colorized with BLUE color");
	}
}

/////////////////////////////////////////////////////////////

abstract public class Shape {
	private IColor  color;
	
	public Shape(IColor color) {
		this.color = color;
	}

	public IColor getColor() {
		return color;
	}

	public void setColor(IColor color) {
		this.color = color;
	}
	
	public abstract void product();
}


class Circle extends Shape {
	private int radius;
	
	public Circle(IColor color, int radius) {
		super(color);
		this.radius = radius;
	}

	@Override
	public void product() {
		System.out.print("Circle: ");
		getColor().colorize_shape();
	}
}

class Square extends Shape {
	private int side;
	
	public Square(IColor color, int side) {
		super(color);
		this.side = side;
	}

	@Override
	public void product() {
		System.out.print("Square: ");
		getColor().colorize_shape();
	}
}

/////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		IColor redColor = new RED();
        IColor blueColor = new BLUE();

        // Create shape instances with different colors
        Shape redCircle = new Circle(redColor, 5);
        Shape blueSquare = new Square(blueColor, 8);

        // Display information about the shapes
        System.out.println("Red Circle:");
        redCircle.product();

        System.out.println("\nBlue Square:");
        blueSquare.product();

	}
}