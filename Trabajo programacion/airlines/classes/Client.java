package airlines.classes;
import airlines.classes.Person;
import airlines.classes.Flight;
/**
* Clase para implementar un Cliente
* @author: Raul Cardenas
* @version: 0.1
*/ 

public class Client extends Person{

	//Constantes
	private final static String NIF_DEF="";
	private final static String NAME_DEF="";
	private final static String LASTNAME_DEF="";
	private final static String BORNDATE_DEF="";
	private final static String NACIONALITY_DEF="";

	

	//Constructor por defecto
	public Client(){
		this(NIF_DEF,NAME_DEF,LASTNAME_DEF,BORNDATE_DEF,NACIONALITY_DEF);
	}

	/*
    *Constructor del cliente que llama a su super person
    */
	public Client(String name,String lastname,String borndate, String nif,String nationality){
		super(name,lastname,borndate,nif,nationality);
	}

    public String getNif(){
        return this.NIF;
    }
    @Override
    public String toString(){
        return "Soy "+this.name+" "+this.lastname+" naci el "+this.borndate+" soy "+this.nationality+" y mi dni es "+this.NIF;
    }
}