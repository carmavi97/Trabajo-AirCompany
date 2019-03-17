package airlines.classes;

import airlines.classes.Seat;


/**
*class name: Seat
*@author: Carlos Martínez Villamandos
*@version: 0.1
* Esta clase consiste en los asientos fisicos que tiene un avion, y que segun el vuelo estaran o no ocupados 
*/
public class Seat{
    
    private static boolean VIP_PRE=false;
    private static boolean SOLD_PRE=false;
    private static int ROW_PRE=0;
    private static int COL_PRE=0;
    
    public boolean vip;
    public int[] position=new int[2];
    public Ticket ticket;
    
    /*
    *@param vip: Es un booleano que indica si el asiento es vip o no
    *@param row: Es un numero que indica la fila en la que esta el asiento
    *@param col: Es un caracter que indica la columna en la que esta el asiento
    */
    public Seat(boolean vip,int row,int col){
        this.vip=vip;
        this.position[0]=row;
        this.position[1]=col;
    }
    
    public Seat(){
        this( VIP_PRE, ROW_PRE, COL_PRE);
    }
    
    @Override
    public boolean equals(Object obj){
        boolean equal=false;
        if(obj instanceof Seat){
            Seat tmp=(Seat) obj;
            if(this.vip==tmp.vip&&this.position[0]==tmp.position[0]&&this.position[1]==tmp.position[1]){
            equal=true;
            }
        }
        
        return equal;
    }
}