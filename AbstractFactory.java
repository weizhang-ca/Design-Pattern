interface IFactory{
	public IEngine createEngine();
	
	public IWheel createWheel);
}

class BMWFactory implements IFactory{
	private IEngine engine;
	private IWheel wheel;
	public IEngine createEngine(){
		engine = new BMWEngine();
		return engine;
	}
	public IWheel createWheel(){
		wheel = new BMWWheel();
		return wheel;
	}
}

class FordFactory implements IFactory{
	private IEngine engine;
	private IWheel wheel;
	public IEngine createEngine(){
		engine = new BFordEngine();
		return engine;
	}
	public IWheel createWheel(){
		wheel = new FordWheel();
		return wheel;
	}
}

interface IEngine{
	public void operation();
}
interface IWheel{
	public void operation();
}

class BMWEngine implements IEngine{
	public void operation(){
		//BMW implementions
	}
}
class FordEngine implements IEngine{
	public void operation(){
		//Ford implementions
	}
}

//Wheel is the same

//Client
class Client{
	public static void main(String[] args) throws Exception{
		IFactory factory = new BMWFactory();
		IEngine engine = factory.createEngine();
		IWheel wheel = factory.createWheel();
		
		//Assemble car;
	}
}

