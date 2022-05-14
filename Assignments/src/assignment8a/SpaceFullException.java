package assignment8a;

public class SpaceFullException extends Exception {
	static final long serialVersionUID=1100001L;
	@Override
	public String toString() // member of "Object class"
	{
		return "Space is Full";
	}
}