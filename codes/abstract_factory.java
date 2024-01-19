public class Sofa {
	private String description;
	
	public Sofa(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Sofa [description=" + description + "]";
	}
	
}


class VictorianSofa extends Sofa {

	public VictorianSofa() {
		super("Victorian Sofa");
		// TODO Auto-generated constructor stub
	}
	
}


class ModernSofa extends Sofa {

	public ModernSofa() {
		super("Modern Sofa");
		// TODO Auto-generated constructor stub
	}
	
}

/////////////////////////////////////////////////////////////////////

public class Table {
	private String description;
	
	public Table(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Table [description=" + description + "]";
	}
	
}


class VictorianTable extends Table {

	public VictorianTable() {
		super("Victorian Table");
		// TODO Auto-generated constructor stub
	}
	
}


class ModernTable extends Table {

	public ModernTable() {
		super("Modern Table");
		// TODO Auto-generated constructor stub
	}
	
}

////////////////////////////////////////////////////////////////////////

public class Chair {
	private String description;
	
	public Chair(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Chair [description=" + description + "]";
	}
	
}


class VictorianChair extends Chair {

	public VictorianChair() {
		super("Victorian Chair");
		// TODO Auto-generated constructor stub
	}
	
}


class ModernChair extends Chair {

	public ModernChair() {
		super("Modern Chair");
		// TODO Auto-generated constructor stub
	}
	
}

////////////////////////////////////////////////////////////////////////////

public interface FurnitureAbstractFactory {
	public Chair createChair();
	public Sofa createSofa();
	public Table createTable();
}


class VictorianFactory implements FurnitureAbstractFactory {

	@Override
	public Chair createChair() {
		return new VictorianChair();
	}

	@Override
	public Sofa createSofa() {
		return new VictorianSofa();
	}

	@Override
	public Table createTable() {
		return new VictorianTable();
	}
	
}


class ModernFactory implements FurnitureAbstractFactory {

	@Override
	public Chair createChair() {
		return new ModernChair();
	}

	@Override
	public Sofa createSofa() {
		return new ModernSofa();
	}

	@Override
	public Table createTable() {
		return new ModernTable();
	}
	
}

/////////////////////////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		
		FurnitureAbstractFactory victorianFactory = new VictorianFactory();
        Chair victorianChair = victorianFactory.createChair();
        Sofa victorianSofa = victorianFactory.createSofa();
        Table victorianTable = victorianFactory.createTable();

        System.out.println("Victorian Furniture Set:");
        System.out.println(victorianChair);
        System.out.println(victorianSofa);
        System.out.println(victorianTable);
        System.out.println();

        // Create a Modern furniture set
        FurnitureAbstractFactory modernFactory = new ModernFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();
        Table modernTable = modernFactory.createTable();

        System.out.println("Modern Furniture Set:");
        System.out.println(modernChair);
        System.out.println(modernSofa);
        System.out.println(modernTable);
		
	}

}