package UserException;

@SuppressWarnings("serial")
public class IDNotFoundException extends Exception{
	public IDNotFoundException(){super();};
	public IDNotFoundException(String message){
		super(message);
	}
}
