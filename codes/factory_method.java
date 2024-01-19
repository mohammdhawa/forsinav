public class Araba {
	private String marka;
	private String model;
	private int beygirGucu;
	
	public Araba(String marka, String model, int beygirGucu) {
		super();
		this.marka = marka;
		this.model = model;
		this.beygirGucu = beygirGucu;
	}

	public String getMarka() {
		return marka;
	}

	public String getModel() {
		return model;
	}

	public int getBeygirGucu() {
		return beygirGucu;
	}

	@Override
	public String toString() {
		return "Araba [marka=" + marka + ", model=" + model + ", beygirGucu=" + beygirGucu + "]";
	}
}


class Z4 extends Araba {
	public Z4(int beygirGucu) {
		super("BMW", "Z4", beygirGucu);
	}
}


class A4 extends Araba {
	public A4(int beygirGucu) {
		super("Audi", "A4", beygirGucu);
	}
}


class R8 extends Araba {
	public R8(int beygirGucu) {
		super("Audi", "R8", beygirGucu);
	}
}



//////////////////////////////////////////////////

abstract public class ArabaFactory {
	private ArrayList<Araba>arabaList = new ArrayList<>();
	
	public ArabaFactory() {
		createAuto();
	}
	
	public ArrayList<Araba> getArabaList() {
		return arabaList;
	}

	public abstract void createAuto();
}


class BMWFactory extends ArabaFactory {

	@Override
	public void createAuto() {
		getArabaList().add(new Z4(160));
	}
	
}


class AudiFactory extends ArabaFactory {

	@Override
	public void createAuto() {
		getArabaList().add(new A4(180));
		getArabaList().add(new R8(220));
	}
	
}

////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		ArabaFactory bmw = new BMWFactory();
		
		ArabaFactory audi = new AudiFactory();
		
		System.out.println("BMW: ");
		for(Araba araba : bmw.getArabaList()) {
			System.out.println(araba);
		}
		
		System.out.println("Audi: ");
		for(Araba araba : audi.getArabaList()) {
			System.out.println(araba);
		}
	}

}