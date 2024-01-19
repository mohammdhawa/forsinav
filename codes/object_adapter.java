public class IPhoneCharger { // Adaptee
	
	public String charge() {
		return "USB-A 3V";
	}

}


public interface Charger { // Target
	public String charge();
}


class AdapterToChargeSamsung implements Charger { // Adapter

	private IPhoneCharger iphone;
	
	public AdapterToChargeSamsung(IPhoneCharger iphone) {
		this.iphone = iphone;
	}
	
	@Override
	public String charge() {
		return iphone.charge() + " Adapted from IPhone to Samsung";
	}

}


public class Main {
    public static void main(String[] args) {
        // Create an instance of IPhoneCharger
        IPhoneCharger iphoneCharger = new IPhoneCharger();

        // Create an adapter to charge a Samsung device using the IPhoneCharger
        AdapterToChargeSamsung adapter = new AdapterToChargeSamsung(iphoneCharger);

        // Charge the Samsung device using the adapter
        String samsungChargeResult = adapter.charge();

        // Display the result
        System.out.println("Charging Result for Samsung: " + samsungChargeResult);
    }
}
