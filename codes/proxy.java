public interface InternetService {
	public void connect(String host);
}


class RealNetwork implements InternetService {
	public void connect(String host) {
		System.out.println("Connecting to " + host);
	}
}


class ProxyInternet implements InternetService {
	private ArrayList<String>banned_hosts;
	private InternetService internet_service = new RealNetwork();
	
	public ProxyInternet(ArrayList<String>banned_hosts) {
		this.banned_hosts = banned_hosts;
	}
	
	public void connect(String host) {
		if(banned_hosts.contains(host)) {
			System.out.println("Accedd to " + host + " Denied.\n");
		}
		else {
			internet_service.connect(host);
			System.out.println("Accessed to " + host + "\n");
		}
	}
}


////////////////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> banned_hosts = new ArrayList<>();
		
		banned_hosts.add("www.facebook.com");
		banned_hosts.add("www.tiktok.com");
		banned_hosts.add("www.instagram.com");
		
		InternetService proxy_network = new ProxyInternet(banned_hosts);
		
		proxy_network.connect("www.facebook.com");;
		
		proxy_network.connect("www.google.com");
	}

}


/////////////////////////////////////////////////////////////////////////