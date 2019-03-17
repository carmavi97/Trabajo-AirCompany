package airlines.classes;
import  airlines.classes.Seat;
import  airlines.classes.Flight;
import  airlines.classes.Ticket;
/**
*Nombre de la clase: Ticket
*@author: Vicente Losada Mesa
*@version: 1.0
*Descripcion: Es la clase que usaremos para crear Tickets y utilizarlos en la compañia aerea.
*/
public class Ticket{
  //CONTANSTES:
    static protected final boolean SOLD_DEF=false;
    static protected final float PRICE_DEF=0;
    static protected final boolean V_DEF=false;
    static protected final String CODE_DEF="";
    static protected final int ROW_DEF=0;
    static protected final char COL_DEF='x';




  //VARIABLES:
    protected boolean vip=false;
    protected boolean sold=false;
    protected float price;
    protected String codeticket;
    protected Client client;
    protected int row;
    protected char col;

/**
*CONSTRUCTOR POR DEFECTO:
*Descripcion: Crea un Ticket por DEFECTO el cual tendra como parametros todas las constantes recibira la posicion y
si es vip mediante el Seat por defecto.
*/
    public Ticket(){
    this(SOLD_DEF,PRICE_DEF,V_DEF,ROW_DEF,COL_DEF,CODE_DEF);
  }
  //Hay que poner la posicion en concreto de la plaza del Ticket.
/**
*CONSTRUCTOR COMPLETO:
*Descripcion: Crea un Ticket completo, donde se muestra la posicion de la plaza de dicho de Ticket.
*@param s: Define si un ticket esta vendido o no.
*@param row: Recibe la fila en la que se encuentra el asisento de este billete
*@param col: Es un char que contiene la letra que corresponde a la columna donde esta el asiento de este billete
*@param code:Es un string del codigo qu se le asigna al billete
*@param price: Es el precio normal del vuelo al que pertece el billete
*@param vip: Es un booleano que define si el billete es uno vip o no
*/

    public Ticket(boolean s,float price,boolean vip,int row, char col,String code){
    this.vip=vip;
    this.sold=s;
    this.codeticket=code;
    this.price=this.calculatePrice(price);
    this.row=row;
    this.col=col;
  }

/**
*Nombre: getPrice
*@return float: Devuelve la variable price de la clase.
*/
    public float getPrice(){
    return this.price;
  }

 /**
 *Nombre: getSold
 *@return boolean: Devuelve la variable sold de la clase.
 */
    public boolean getSold(){
    return this.sold;
  }

/**
*Nombre: sellTicket
*Descripcion: Metodo que cambia la variable boolean sold de false a true.
*@param client: el cliente que compra el billete
*/
    public void sellTicket(Client client){
    this.sold=true;
    this.client=client;
  }

    /**
    *Este metodo devuleve el cliente al que pertenece el billete o nulo si no pertenece a nadie
    *@return: El cliente al que pertenece el billete
    */
    public Client getClient(){
        return this.client;
    }
    /**
    *Este metodo devuelve el codigo del billete
    *@return this.codeticket: Es un string que es el codgio del billete
    */
    public String getCodeticket(){
        return this.codeticket;
    }
    /**
    *Mombre: refundTicket
    *Metodo que en caso de devolucion de un billete, cambia su valor para vendido a false
    */
    public void refundTicket(){
        this.sold=false;
        this.client=null;
    }
    
    /**
    *Nombre: calculatePrice
    *Descripcion: Obtiene el precio de un billete en cuestion dependiendo del vuelo que reciba.
    *@param  p: float del precio normal del vuelo
    *@return price: Devuelve el precio correctamente calculado segun el vuelo quje recibe.
    */
    public float calculatePrice(float p){
    float price;
    if(this.vip==true){
      price=p+(float)(p*0.2);
      Math.ceil(price);
    }else{
      price=p;
    }
    return price;
  }
    @Override
    public boolean equals(Object obj){
        boolean equal=false;
        if(obj instanceof Ticket){
            Ticket tmp=(Ticket) obj;
            if(this.getCodeticket().equals(tmp.getCodeticket())){
            equal=true;
            }
        }
        return equal;
    }
    @Override
    public String toString(){
        return this.row+this.col+" "+this.price+" euros";  
    }

}