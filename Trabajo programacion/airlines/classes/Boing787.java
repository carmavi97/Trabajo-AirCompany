package airlines.classes;
import airlines.classes.Plane;
/**
* Clase para implementar un Avion
* @author: Raul Cardenas 
* @author: Carlos Martínez
* @version: 0.1
*/ 

public class Boing787 extends Plane{
	//Constantes
	private final static int PRICE_DEF=280;
	private final static int AUTONOMY_DEF=8000;
	private final static int CAPACITY_DEF=300;
	private final static int CONSUMPTION_DEF=12;
	private final static int ROW_DEF=50;
	private final static int COL_DEF=7;
    private final static int ROWVIP=10;

	//Variables
	protected String  id;
	protected String adquisition_date;
    //Se trata de un array de booleanos que seran true si hay un vehiculo y false si no
	protected boolean [] vehicles;

	public Boing787(String id, String date){
		super(id,date,PRICE_DEF,AUTONOMY_DEF,CAPACITY_DEF,CONSUMPTION_DEF);
		this.seats=new Seat[ROW_DEF][COL_DEF];
        this.createSeats();
	}

	public void VIP(){
		boolean vip=true;
		for (int i=0;i<ROWVIP ;i++ ) {
			for (int j=0;j<COL_DEF ;j++ ) {
				this.seats[i][j].vip=true;
			}
		}
	}
    /**
    *Rellena la matriz de asientos para el avion, primero recoriendo los asientos vip
    y despues los normales
    */
    private void createSeats(){
        for(int i=0;i<ROWVIP;i++){
            for(int j=0;j<seats[i].length;j++){
                seats[i][j]=new Seat(true,i,j);
            }
        }
        for(int i=ROWVIP;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                seats[i][j]=new Seat(false,i,j);
            }
        }
    }
    /*
    * Este metodo busca si hay espacio para vehiculos en el avion y de haberlo cambia el valor del espacio a true indicando
    que ahora contiene un vehiculo
    *
    *return add: es un booleano que sera true si se consigue guardar el vehiculo en el avion
    */
    public boolean addVehicle(){
        boolean add=false;
        for(int i=0;i<vehicles.length&add==false;i++){
            if(this.vehicles[i]==false){
                add=true;
                this.vehicles[i]=true;
            }
        }
        return add;
    }
    public Seat[][] getSeats(){
        return this.seats;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean equal=false;
        if(obj instanceof Boing787){
            equal=super.equals(obj);
        }
        return equal;
    }
    
    @Override
	public String toString(){
		return super.toString(); 
	}
}