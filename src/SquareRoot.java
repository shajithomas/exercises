
public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double result = computeRoot(Double.parseDouble(args[0]));
		System.out.println(result);

	}
	public static double computeRoot(double num) {
		int guess = 1;
		while ( guess*guess < num) {
			guess++;
		}
		if ( guess * guess == num ) {
			return guess;
		}
		int highGuess = guess;
		int lowGuess = guess-1;
		return sqrRoot(num,lowGuess,highGuess );
		
	}
	public static double sqrRoot(double num, double low, double high) {
		double mid = (low + high)/2;
		double midSquare = mid*mid;
		if ( approxEquals ( midSquare, num ) ) {
			return mid;
		}
		if ( midSquare > num ) {
			return sqrRoot(num, low, mid);
		} else {
			return sqrRoot(num, mid, high);
		}
		
		
	}
	
	public static boolean approxEquals( double num1, double num2) {
		int precision = 1000;
        return Math.round(num1 * precision) == Math.round(num2 * precision);
	}

}
