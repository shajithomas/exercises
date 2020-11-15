class Factorial {
		public static void main( String [] args) {
				Factorial fact = new Factorial();
				int n = Integer.parseInt(args[0]);
				int result = fact.computeFactorial(n);
				System.out.println ("Factorial of " + n + " is: " + result);
		}
		private int computeFactorial(int n) {
				if ( n <= 2 ) return n;
				return n*computeFactorial(n-1);
		}
}
