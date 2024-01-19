public interface PlayerInterface {
	public PlayerInterface getPlayer();
}


class Player1 implements PlayerInterface {
	private double height = 1.87;
	private int weight = 85;
	private int power = 88;
	private String skin = "Black";
	private int id = 1;
	
	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	@Override
	public String toString() {
		return "PlayerObject [height=" + height + ", weight=" + weight + ", power=" + power + ", skin=" + skin + "]";
	}
	
	@Override
	public PlayerInterface getPlayer() {
		return this;
	}	
}


class Player2 implements PlayerInterface {
	private double height = 1.8;
	private int weight = 75;
	private int power = 78;
	private String skin = "White";
	private int id = 2;
	
	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	@Override
	public String toString() {
		return "PlayerObject [height=" + height + ", weight=" + weight + ", power=" + power + ", skin=" + skin + "]";
	}
	
	@Override
	public PlayerInterface getPlayer() {
		return this;
	}	
}

/////////////////////////////////////////////////////////////////////

public class FlyweightPlayerFactory {
	private Map<String, PlayerInterface> cache; 
	
	public FlyweightPlayerFactory() {
		cache = new HashMap<>();
	}
	
	public PlayerInterface getPlayer(String id) {
		if(cache.containsKey(id)) {
			return cache.get(id);
		}
		else {
			if(id.equalsIgnoreCase("1")) {
				cache.put(id, new Player1());
			}
			else {
				cache.put(id, new Player2());
			}
			return cache.get(id);
		}
	}
}