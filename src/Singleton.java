public class Singleton {
	private Singleton(){
	}
	
	private static class SingletonHolder {
		private static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	public void test () {
		System.out.println("This is from singleton");
	}
}