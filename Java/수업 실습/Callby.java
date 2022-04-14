
public class Callby {

	public static void value(int a) {
		a += 50;
		System.out.println("value() method: a = " + a);
	}
	
	public static void ref(Car car) {
		car.owner = "Me";
		car.price -= 100;
		System.out.println("refer() method: car.price = " + car.price + "\t car.owner = " + car.owner);
	}
}
