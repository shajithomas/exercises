
public class IntegerOverflowCheck {
	int total = 0;
	public int add (int num){
		if ( total+num < 0) {
			throw new RuntimeException("Integer Overflow occured...");
		}
		total += num;
		return total;
	}

}
