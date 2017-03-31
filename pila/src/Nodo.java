

public class Nodo {
	private Nodo sig;
	private String valor;
	
	public Nodo (){
		this.sig=null;
		
	}
	public Nodo (String valor){
		this.sig=null;
		this.valor=valor;
	}
	public String getValor(){
		return this.valor;
	}
	public void setValor(String valor){
		this.valor=valor;
	}
	public Nodo getSig(){
		return this.sig;
	}
	public void setSig(Nodo sig){
		this.sig=sig;
	}
}
