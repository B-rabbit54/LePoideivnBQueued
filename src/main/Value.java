package main;

public class Value implements Comparable
{
	private int value;
	public Value(int value)
	{
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	@Override
	public String toString()
	{
		return value + "";
		
	}
	@Override
	public int compareTo(Object o) {
		
		Value ov = (Value)o;		
		return this.getValue() - ov.getValue();
	}

}
