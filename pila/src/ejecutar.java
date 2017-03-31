

public class ejecutar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pila p=new Pila();
		p.apilar("a");
		p.apilar("b");
		p.apilar("c");
		p.apilar("d");
		System.out.println(p.tope());
		p.desapilar();
		System.out.println(p.tope());
		p.desapilar();
		System.out.println(p.tope());
		p.desapilar();
		System.out.println(p.tope());
		p.desapilar();
		if(p.esVacia()){
			System.out.println("la pila esta vacia");
		}
	}

}
