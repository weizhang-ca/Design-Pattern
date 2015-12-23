abstract class State{
	private VendingMachine vm;
	public State(VendingMachine vm){
		this.vm = vm;
	}
	public void doAction();
}
class InsertCoinState{
	public InserCoinState(VendingMachine vm){
		super(vm);
	}
	public void doAction(){
		System.out.println("Please insert coin: 25 Cent, 50 Cent or 75 Cent");
		Scanner sc = new Scanner(System.in);
		String coin = sc.nextLine();
		if(coin.equals("25")||coin.equals("50")||coin.equals("75")){
			vm.addCoinValue(Float.parseFloat(coin));
			vm.setState(new SelectProductState(vm));
		}
		else{
			System.out.println("Invalid coin");
			vm.setState(this);
		}
	}
}

class SelectProductState extends State{
	public SelectProductState(VendingMachine vm){
		super(vm);
	}
	
	public void doAction(){
		System.out.println("Please select the product: 1-Pepsi(25 cents); 2-Coke(50 cents); 3-Red Bull(1.25 dollars); 4-Cancel");
		Scanner sc = new Scanner(System.in);
		String selection = sc.nextLine();
		if(selection.equals("1")||selection.equals("2")||selection.equals("3")||||selection.equals("4")){
			float totalValue = vm.getTotalValue();
			bool ifNotEnoughMoney = false;
			switch(selection){
				case "1":
					Product product = new Product("Pepsi", 25);
					break;
				case "2":
					Product product = new Product("Coke", 50);
					break;
				case "3":
					Product product = new Product("Red Bull", 125);
					break;
				case "4":
					vm.setState(new CancelTranscationState(vm));
					return;
			}
			vm.setSelectProduct(product);
			vm.setState(new ProcessOrderState(vm));
		}
	}
}
class ProcessOrderState extends State{
	public ProcessOrderState(VendingMachine vm){
		super(vm);
	}
	public doAction(){
		if(vm.getSelectProduct().price < vm.getTotalValue()){
			System.out.println("Not Enough Money");
			vm.setState(new InsertCoinState());
			return;
		}
		vm.setState(new DispenseProduct(vm));
	}
}
class CancelTransactionState extends State{
	public CancelTransactionState(VendingMachine vm){
		super(vm);
	}
	public doAction(){
		System.out.println("Cancelling the transaction and return your money...");
		vm.setTotalValue(0);
		vm.setState(new InsertCoinState(vm));
	}
}
class DispenseProductState extends State{
	public DispenseProduct(VendingMachine vm){
		super(vm);
	}
	
	public doAction(){
		System.out.println("Dispensing product "+vm.getSelectProduct().desc);
		float changes = vm.getTotalValue() - vm.getSelectProduct().price;
		System.out.println("Returning changes "+String.valueOf(changes));
		vm.setTotalValue(0);
		vm.setState(new InsertCoinState(vm));
	}
}

class Product{
	public Product(desc, price){
		...
	};
	public float price;
	public String desc;

}
class VendingMachine{
	private State state;
	private float totalValue;
	private Product selectProduct;
	
	public void start(){
		setState(new InsertCoinState(this));
	}
	public void setState(State state){
		this.state = state;
	}
	public void addValue(float insertedCoin){
	}
	public void doAction(){
		state.doAction();
	}
}
class testVendingMachine{
	public static void main(String[] args){
		VendingMachine vm = new VendingMachine();
		vm.start();
		while(true){
			vm.doAction();
		}
	}
}