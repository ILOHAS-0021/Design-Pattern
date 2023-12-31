public class PizzaTestDrive {
	public static void main(String[] args){
		MyHWInfo.printInfo();

		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		Pizza pizza1 = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a "+ pizza1.getName());
		Pizza pizza2 = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza2.getName());
	}
}