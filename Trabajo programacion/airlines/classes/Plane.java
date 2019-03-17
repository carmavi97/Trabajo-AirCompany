package airlines.classes;
/**
* Clase para implementar un Avion
* @author: Raul Cardenas
* @version: 0.1
*/ 

abstract public class Plane{

	//Constantes
	private final static String ID_DEF="";
	private final static String DATE_DEF="";
	private final static int PRICE_DEF=0;
	private final static int AUTONOMY_DEF=0;
	private final static int CAPACITY_DEF=0;
	private final static int CONSUMPTION_DEF=0;

	//Variables
	protected String id;
	protected String adquisition_date;
	protected int price;
	protected int autonomy;
	protected int capacity;
	protected int comsumption;
    protected Seat[][] seats;

	//Constructores

	//Constructor por defecto
	public Plane(){
		this(ID_DEF,DATE_DEF,PRICE_DEF,AUTONOMY_DEF,CAPACITY_DEF,CONSUMPTION_DEF);

	}

	//Constructor completo
	public Plane(String id, String date, int price, int autonomy, int capacity, int comsumption){
		this.id=id;
		this.adquisition_date=date;
		this.price=price;
		this.autonomy=autonomy;
		this.capacity=capacity;
		this.comsumption=comsumption;

	}
	
	public int getComsumption(){
		return this.comsumption;
	}
    
	public String getId(){
        return this.id;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean equal=false;
        if(obj instanceof Plane){
            Plane tmp=(Plane) obj;
            if(this.getId().equals(tmp.getId())){
                equal=true;
            }
        }
        return equal;
    }
    public abstract Seat[][] getSeats();
    
	@Override
	public String toString(){
		return "El avion con matricula ("+this.getId()+"), fue adquirido en "+this.adquisition_date+
            " y tiene una capacidad de "+this.capacity+" con una autonomia de "+this.autonomy+
            " y un consumo de "+this.getComsumption()+", cuesta "+this.price; 
	}

}