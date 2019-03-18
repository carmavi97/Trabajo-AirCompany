package airlines.classes;

import airlines.classes.Seat;
import airlines.classes.Plane;
import airlines.classes.Pilot;
import airlines.classes.Tripulation;
import airlines.classes.Airport;
import airlines.classes.AirCompany;
import airlines.classes.Ticket;

/**
*Nombre de la clase: Fligth
*Descripcion: Clase que estancia y guarda la infromacion de los vuelos
*@author:Carlos Martínez Villamandos
*@version:1.0
*/
public class Flight{

    protected static final String CODE_PRE="";
    protected static final String DEAPERTUREDATE_PRE="";

    protected Airport destination;
    protected Airport start;
    protected String date;
    protected int duration;
    protected String code;
    protected Pilot[] pilots=new Pilot[2];
    protected Tripulation[] staff;
    protected Plane plane;
    protected Seat[][] seats;
    public float price;
    protected boolean ready=false;
    protected AirCompany company;
    protected int gains = 0;
    /**
    *@param destination: Es el aeropuerto al que se dijige el vuelo
    *@param start:Es el aeropuerto dede el que sale el vuelo
    *@param company: Es la compañia  la que pertenece el vuelo
    *@param date: Es la fecha a la que sale el vuelo
    *@param duration: Es la duracion del vuelo
    *@param pilot1: Es uno de los dos prilotos que relizan el vuelo
    *@param pilot2: Es uno de los dos pilotos que realiza el vuelo
    *@param plane: Es el avion en el que se reliza el vuelo
    *@param price: Es el precio base del vuelo
    */
    public Flight(Airport destination, Airport start,AirCompany company, String date, int duration,
                  Pilot pilot1, Pilot pilot2, Plane plane,float price){
        this.destination=destination;
        this.start=start;
        this.date=date;
        this.duration=duration;
        this.pilots[0]=pilot1;
        this.pilots[1]=pilot2;
        this.plane=plane;
        this.code=createCode(company,destination,date);
        this.calculaStaff();
        this.price=price;
        this.company=company;
        this.seats=plane.getSeats();
        this.assignTickets();

    }

    public Airport getStart(){
        return this.start;
    }

    public Airport getDestination(){
        return this.destination;
    }

    public Seat[][] getSeats(){
        return this.seats;
    }

    public String getDate(){
        return this.date;
    }
    public String getCode(){
        return this.code;
    }
    public int getGains(){
      return this.gains;
    }
    /**
    *Genera el codigo del vuelo
    *@param dest:Ees el aeropuerto destino
    *@param company: Es la compañia que oferta el vuelo
    *@param d: es la fecha y hora a la que sale el vuelo (formato YYYY/MM/DD HH:MM)
    *@return code: es el codigo del vuelo
    */
    private String createCode(AirCompany company,Airport dest, String d){
        String code="";
        String hour=calculateHour(d);
        code=company.getCode()+hour+dest.getCode();
        return code;
    }
    /**
    *@param: da es la fecha y hora a la que sale el vuelo (formato YYYY/MM/DD HH:MM)
    *@return hour: es un String que contiene la hora de salida de forma que se use en createCodigo
    *extrae la hora a la que sale el vuelo para usarla en createCode
    */
    private String calculateHour(String da){
        String hour="";
        hour=da.substring(11,13)+da.substring(14,16);
        return hour;
    }
    /**
    *Este metodo calcula el nuemero necesario de tripulacion y crea su vector
    */
    private void calculaStaff(){
        int crew;
        crew=(int)Math.ceil((plane.capacity*2)/100);
        this.staff=new Tripulation[crew];
    }

    /**
    *@param t: es el tripulacion que se desea añadir al vuelo
    * Este metodo añade un tripulante al avion si hay espacio, ademas avisa de cuando esta lleno
    *@return add: es una variable boolenana que sera true si se ha añadido al vuelo el tripulante correctamente
    */
    public boolean addTripulation(Tripulation t){
        boolean add=false;
        if (this.ready==false){
            for(int i=0;i<this.staff.length&&add==false;i++){
                if(this.staff[i]!=null){
                    this.staff[i]=t;
                    add=true;
                    if(i==(this.staff.length-1)){
                        this.ready=true;
                        System.out.println("Vuelo listo");
                    }
                }
            }
        }else{
            System.out.println("Ya esta lleno");
        }
        return add;
    }
    /**
    *@param t: es el tripulacion que se desea eliminar
    *@return remove: es una valirable
    * este metodo busca un tripulante por su codigo y si lo encuentra lo elimina del array
    */
    public boolean removeTripulation(Tripulation t){
        boolean remove=false;
        for(int i=0;i<this.staff.length && remove==false;i++){
            if(t.getId()==this.staff[i].getId()){
                this.staff[i]=null;
                remove=true;
            }
        }
        return remove;
    }
    /**
    * Este metodo se encarga de generar un String a partir de la posicion de un asiento concreto para
    asignar dicho codigo al ticket asociado a dicho asiento en este vuelo
    *@param i:es la fila del asiento
    *@param j:es la columna del asiento
    *@return code: Es un el codigo que se le asignara al ticket
    */
    private String generateTCode(int i,int j){
        String code=this.code+i+j;
        return code;
    }
    /**
    *Este metodo le asignara un ticket a cada asiento del vuelo, usano como codigo
    la union de el codigo del vuelo y la posicion del asiento
    */
    private void assignTickets(){
        for(int i=0;i<this.seats.length;i++){
            for(int j=0;j<this.seats[i].length;j++){
                this.seats[i][j].ticket=new Ticket(false,this.price,this.seats[i][j].vip,i,this.numberToLetter(j),this.code+i+j);
            }
        }
    }
    /**
    * Este metodo devuelve un caracte en funcion del int que reciba para asi ser asignado a un billete
    *@param j: Es el entero que representa la columna en al que esta el ticket
    *@return col: Es el caracter que reopresenta la columna a la que pertene el billete al que se le asinara esta letra
    */
    private char numberToLetter(int j){
        char[] col={'A','B','C','D','E','F','G'};
        return col[j];
    }
    /**
    *@return profitable: sera true si el vuelo es rentable y false si no lo sabe
    * calcula las ganancias actuales del vuelo y las perdidas por combustible y tras comparanlas
    devuelve si es renttable el vuelo o no
    */
    public boolean Rentavility(){
        boolean profitable=false;
        int lost=0;
        for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                if(this.seats[i][j].ticket.getSold()==true){
                    this.gains+=this.seats[i][j].ticket.getPrice();
                }
            }
        }
        lost=(this.plane.getComsumption()*this.duration);
        if(this.gains>lost){
            profitable=true;
        }
        return profitable;
    }
    @Override
    public boolean equals(Object obj){
        boolean equal=false;
        if(obj instanceof Flight){
            Flight tmp=(Flight) obj;
            if(tmp.getCode().equals(this.getCode())){
                equal=true;
            }
        }
        return equal;
    }
    @Override
    public String toString(){
        return "El vuelo "+this.code+" sale desde "+this.start+" hacia "+this.destination+", fecha:"+this.date;
    }
}
