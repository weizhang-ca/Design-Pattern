interface Character{
	public void display();
}

class ConcreteCharacter implements Character{
	public void display(){
		//implementation
	}
}

abstract class Decorator implements Character{
	private Character character;
	public Decorator(Character character){
		this.character = character;
	}
	public void display(){
		character.display();
	}
}

class WeightedCharacter extends Decorator{
	private String weight;
	public WeightedCharacter(Character character){
		super(character);
	}
	public void display(){
		super.display();
		displayWeight();
	}
	public void displayWeight(){
		//implementation
	}
}

class ColorCharacter extends Decorator{
	public ColorCharacter(Character character){
		super(character);
	}
	public void display(){
		super.display();
		displayColor();
	}
	public void displayColor(){
		//implementation
	}
}

//Client
class Client{
	public static void main(String[] args){
		Character character = new ConcreteCharacter();
		Character decoratedCharacter = new ColorCharacter(new WeighedCharacter(character));
		decoratedCharacter.display();
	}
}