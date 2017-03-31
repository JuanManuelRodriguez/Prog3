
public class Pila {
	private listaVinculada pila;
	public Pila(){
		pila=new listaVinculada();
	}
	public String tope(){
		return pila.elementAt(0);
	}
	public void apilar(String valor){
		pila.add(valor);
	}
	public void desapilar(){
		pila.deletePos(0);
	}
	public boolean esVacia(){
		return pila.isEmpty();
	}
}
