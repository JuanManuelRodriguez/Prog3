

public class listaVinculada {
	private Nodo first;
	private Integer sizeLista;
	
	public listaVinculada(){
		first=null;
		this.sizeLista=new Integer(0);
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void add(String valor){
		if(!isEmpty()){
			Nodo nuevo=new Nodo(first.getValor());
			nuevo.setSig(first.getSig());
			first.setValor(valor);
			first.setSig(nuevo);
		}else{
			first=new Nodo(valor);;
		}
		this.sizeLista++;
	}
	public void addOrdered(String valor){
		if(this.isEmpty()){
			first=new Nodo(valor);
		}
		else{
			Nodo aux=first;
			if(valor.compareTo(first.getValor())<0){
				Nodo aux2=new Nodo(first.getValor());
				aux2.setSig(first.getSig());
				first.setValor(valor);
				first.setSig(aux2);
			}
			else{
				Nodo padre=this.getFirst();
				while((aux!=null) && (aux.getValor().compareTo(valor)<0)){
					padre=aux;
					aux=aux.getSig();
				}
				if(aux!=null){
					Nodo nuevo=new Nodo(valor);
					nuevo.setSig(aux);
					padre.setSig(nuevo);
				}
				else{
					Nodo nuevo=new Nodo(valor);
					padre.setSig(nuevo);
				}
			}		
		}
		this.sizeLista++;
	}
	public String elementAt(Integer pos){
		if(!this.isEmpty()){
			Nodo aux=this.first;
			Integer cont=new Integer(0);
			while((aux != null) && (cont < pos)){
				aux=aux.getSig();
				cont++;
			}
			if(aux != null){
				return aux.getValor();
			}
		}
		return null;
	}
	
	public void deleteValor(String valor){
		Nodo cursor=first;
		if(cursor!=null){
			if(cursor.getValor().equals(valor)){//caso de que haya que borrar el primer nodo
				first=cursor.getSig();
				sizeLista--;
			}
			boolean encontre=false;
			while(cursor.getSig()!=null && !encontre){//cuando hay que borra un nodo intermedio o final
				if(cursor.getSig().getValor().equals(valor)){
					Nodo aux=cursor.getSig();
					cursor.setSig(aux.getSig());
					aux.setSig(null);
					encontre=true;
					sizeLista--;
				}
				else{
					cursor=cursor.getSig();
				}
				
			}
		}
	}
	public void deletePos(Integer pos){
		Nodo cursor=first;
		if(cursor!=null){
			Integer cont=new Integer(0);
			if(cont.equals(pos)){//caso de que haya que borrar el primer nodo
				first=cursor.getSig();
				sizeLista--;
				return;
			}
			Nodo padre=new Nodo();
			while(cursor.getSig()!=null && cont<pos){//cuando hay que borra un nodo intermedio o final
				cont++;
				padre=cursor;
				cursor=cursor.getSig();
			}
			if(cont.equals(pos)){	
				padre.setSig(cursor.getSig());
				cursor.setSig(null);
				sizeLista--;
			}

		}
	}
	public Integer size(){
		return this.sizeLista;
	}
	public void addInPos(String valor, Integer pos){
		if(!this.isEmpty()){
			Nodo cursor=first;
			Nodo padre=new Nodo();
			Integer cont=new Integer(0);
			while(cursor.getSig()!=null && cont<pos){
				cont++;
				padre=cursor;
				cursor=cursor.getSig();
			}
			if(cont.equals(pos)){
				if(cursor.getValor().equals(first.getValor())){//el valor a agregar va en la primera posicion
					Nodo nuevo=new Nodo(first.getValor());
					nuevo.setSig(first.getSig());
					first.setValor(valor);
					first.setSig(nuevo);
				}
				else{
					Nodo nuevo=new Nodo(valor);
					padre.setSig(nuevo);
					nuevo.setSig(cursor);
				}
			}
		}
	}	
	public Nodo getFirst(){
		return first;
	}
	public String[] elemMaxAndPos(){
		String[] aretornar = new String[2];
		if(!isEmpty()){
			Nodo cursor=first;
			String max="a";
			Integer pos=0;
			Integer posMax=0;		
			while(cursor.getSig()!=null){
				if(cursor.getValor().compareTo(max)>0){
					max=cursor.getValor();
					posMax=pos;
				}
				pos++;
				cursor=cursor.getSig();
			}
			aretornar[0]=new String(max);
			String posm=new String("\""+posMax+"\"");
			aretornar[1]=posm;
			
		}
		return aretornar;
	}
}
