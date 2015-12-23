interfact IFactory{
	public IProduct createProduct();
}

class FactoryA implements IFactory{
	private IProduct product;
	public IProduct createProduct(){
		product = new ProductA();
	};
}


class FactoryB implements IFactory{
	private IProduct product;
	public IProduct createProduct(){
		product = new ProductB();
	};
}


interface IProduct{
	public void operation();
}

class ProductA implements IProduct{
	public void operation(){
		//A implementation
	}
}


class ProductB implements IProduct{
	public void operation(){
		//B implementation
	}
}

class Client{
	public static void main(){
		IFactory factory = new FactoryA();
		IProduct product = factory.createProduct();
		product.operation();
		
		factory = new FactoryB();
		product = factory.createProduct();
		product.operation();
	}
}