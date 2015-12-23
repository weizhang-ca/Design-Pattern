//Method A; Eager initialization
class Singleton{
	private final static Singleton instance = new Singleton();
	private Singleton();
	public static Singleton getInstance(){
		return instance;
	}
}

//Method B; Lazy initialization
class Singleton{
	private static volatile Singleton instance;
	private Singleton();
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}