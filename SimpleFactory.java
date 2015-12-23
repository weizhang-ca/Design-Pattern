class SimpleFactory{
	private IProduct product;
	public IProduct createProduct(String name){
		if(name.equals("A")){
			product = new ProductA();
		}
		else if(name.equals("B"){
			product = new ProductB();
		}
		return product;
	}
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

//Client

class Client{
	public static void main(){
		SimpleFactory factory = new SimpleFactory();
		IProduct product = factory.createProduct("A");
		product.operation();
	}
}