package fc;

public interface FacadeComponent {
	public void playMovie();
}


class FacadeImplementation implements FacadeComponent {
	private Projector projector;
	private Mp3Player audioPlayer;
	private Mp4Player videoPlayer;
	
	public FacadeImplementation() {
		projector = new Projector();
		audioPlayer = new Mp3Player();
		videoPlayer = new Mp4Player();
	}
	
	public void playMovie() {
		projector.turnOn();
		audioPlayer.playAudio();
		videoPlayer.playVideo();
	}
}

//////////////////////////////////////////////////////////

class Projector {
	public void turnOn() {
		System.out.println("The projector Turned On.");
	}
}


class Mp3Player {
	public void playAudio() {
		System.out.println("The Audi Turned On.");
	}
}


class Mp4Player {
	public void playVideo() {
		System.out.println("The Video Turned On.");
	}
}

//////////////////////////////////////////////////////////////////

class FacadeFactory {
	private static FacadeFactory instance = new FacadeFactory();
	
	private FacadeFactory() {
		
	}
	
	public static FacadeFactory getInstance() {
		return instance;
	}
	
	public FacadeComponent getFacade() {
		return new FacadeImplementation();
	}
}


///////////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacadeFactory fc = FacadeFactory.getInstance();
		
		FacadeComponent facadeComp = fc.getFacade();
		
		facadeComp.playMovie();
	}
}