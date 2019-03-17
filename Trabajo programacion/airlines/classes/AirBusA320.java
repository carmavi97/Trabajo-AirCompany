package airlines.classes;
import airlines.classes.Plane;
/**
* Clase para implementar un Avion
* @author: Raul Cardenas
* @version: 0.1
*/ 

public class AirBusA320 extends Plane{
	//Constantes
	private final static int PRICE_DEF=80;
	private final static int AUTONOMY_DEF=4000;
	private final static int CAPACITY_DEF=80;
	private final static int CONSUMPTION_DEF=11;
	private final static int ROW_DEF=20;
	private final static int COL_DEF=4;
    private final static int ROWVIP=5;

	//Variables
	protected String id;
	protected String adquisition_date;

	public AirBusA320(String id, String date){
		super(id,date,PRICE_DEF,AUTONOMY_DEF,CAPACITY_DEF,CONSUMPTION_DEF);
        this.seats=new Seat[ROW_DEF][COL_DEF];
        this.createSeats();

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
    public Seat[][] getSeats(){
        return this.seats;
    }

	@Override
	public String toString(){
		return super.toString(); 
	}
    
    @Override
    public boolean equals(Object obj){
        boolean equal=false;
        if(obj instanceof AirBusA320){
            equal=super.equals(obj);
        }
        return equal;
    }

}