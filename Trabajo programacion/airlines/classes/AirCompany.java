package airlines.classes;
import airlines.classes.*;
import airlines.interfaces.IAirCompany;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ArrayList;

/**
*Nombre: AirCompany
*Descripcion: Clase que utilizara el programa principal.
*@author: Vicente Losada Mesa
*@version: 1.1.4
*/
public class AirCompany implements IAirCompany{
  public String name;
  protected char[] code=new char[3];
  public CEO ceo;
  public String fundationdate;
  public ArrayList<Plane> airnavy=new ArrayList<Plane>();
  public ArrayList<Flight> flights=new ArrayList<Flight>();
  public ArrayList<Client> clients=new ArrayList<Client>();
  public ArrayList<Employee> workers=new ArrayList<Employee>();
  public ArrayList<Ticket> tickets=new ArrayList<Ticket>();
  public ArrayList<Airport> airports=new ArrayList<Airport>();

/**
*Nombre:  Completo de una compañia.
*@param  name: Nombre de la compañia.
*@param  c: Jefe de la compañia.
*@param  dt: Fecha de fundacion de la compañia.
*/
  public AirCompany(String name,CEO c,String dt){
    this.name=name;
    GenerateCode(name);
    this.ceo=c;
    this.fundationdate=dt;
  }
/**
*Nombre: GenerateCode
*Descripcion: Genera el codigo de la compañia segun el nombre de la misma.
*@param  n: Recibe el nombre de la compañia.
*/
  public void GenerateCode(String n){
  for(int i=0;i<3;i++){
    this.code[i]=n.charAt(i);
    }
  }
    public String getCode(){
        String id="";
        for(int i=0;i<this.code.length;i++){
            id=id+this.code[i];
        }
        return id;
    }
/**
*Nombre: listMenu
*Descripcion: Muestra el menu que utilizara el metodo hireEmployee.
*/
  public void listMenu(){
    System.out.println("Bienvenido al programa de contratacion de un empleado, va a usted a contratar un empleado, elija una opcion: ");
    System.out.println("1) Contrate un Tripulante. ");
    System.out.println("2) Contrate un Piloto. ");
    System.out.println("3) Contrate un CEO.");
    System.out.println("0) Salir.");
  }
  /**
  *Nombre: listFire
  *Descripcion: Muestra el menu que utilizara el metodo fireEmployee.
  */
  public void listFire(){
    System.out.println("Bienvenido al programa de despidos de un empleado, va a usted a despedir un empleado, elija una opcion: ");
    System.out.println("1) Despide un Tripulante. ");
    System.out.println("2) Despide un Piloto. ");
    System.out.println("3) Despide un CEO.");
    System.out.println("0) Salir.");
  }
  /**
  *Nombre: listShop
  *Descripcion: Muestra el menu que utilizara el buyTicket.
  */
  public void listShop(){
    System.out.println("Bienvenido al programa de compra de su ticket, acontinuacion podra elegir entre comprar un ticket vip o un ticket normal: ");
    System.out.println("1) Comprar un ticket vip. ");
    System.out.println("2) Comprar un ticket normal. ");
    System.out.println("0) Salir. ");
  }
  /**
  *Nombre: readOption
  *Descripcion: Muestra el menu lee una opcion por teclado.
  */
  public int readOption(Scanner opt){
    int option;
    try{
      option=opt.nextInt();
    }catch(InputMismatchException e){
      opt=new Scanner(System.in);
      option=0;
    }catch(Exception e){
      System.out.println("Error en el sistema");
      option=0;
    }
    return option;
  }
/**
*Nombre: hireEmployee
*Descripcion: Metodo que contrata a un empleado.
*@param  e: Empleado que recibe y va a crear.
*/
  public void hireEmployee(Employee e){
    int option;
    Scanner opt=new Scanner(System.in);
    try{
      do{
          listMenu();
          option=readOption(opt);
        switch(option){
          case 0:
            System.out.println("Hasta luego.");
          case 1:
            if(e instanceof Tripulation){
              workers.add(e);
            }else{
              System.out.println("No se a podido contratar un tripulante.");
            }
            break;
          case 2:
            if(e instanceof Pilot){
              workers.add(e);
            }else{
              System.out.println("No se a podido contratar un piloto.");
            }
            break;
          case 3:
              if(e instanceof CEO){
                workers.add(e);
              }else{
                System.out.println("No se a podido contratar un CEO.");
              }
            break;
          default:
            System.out.println("Inserte un numero del 0 al 3");
        }
      }while(option!=3);
    }catch (InputMismatchException e2) {
      System.out.println("Ha ocurrido un error, introduzca un numero comprendido entre 0 y 3.");
    }
  }
/**
*Nombre: fireEmployee
*Descripcion: Metodo que despide a un empleado y borra dicho empleado, buscando en el ArrayList de empleados mediante el searchEmployee.
@param  e: Empleado que se va a despedir.
*/
  public void fireEmployee(Employee e){
    int option;
    Scanner opt=new Scanner(System.in);
    int id=e.getId();
    try{
      do{
          listFire();
          option=readOption(opt);
        switch(option){
          case 0:
            System.out.println("Hasta luego.");
          case 1:
            if(e instanceof Tripulation){
              workers.remove(searchEmployee(id));
              System.out.println("Se ha despedido a un tripulante.");
            }else{
              System.out.println("No se a podido despedir al tripulante.");
            }
          case 2:
            if(e instanceof Pilot){
              workers.remove(searchEmployee(id));
              System.out.println("Se ha despedido un piloto.");
            }else{
              System.out.println("No se a podido despedir al piloto.");
            }
          case 3:
          if(e instanceof CEO){
            workers.remove(searchEmployee(id));
            System.out.println("Se ha despedido al CEO.");
          }else{
            System.out.println("No se a podido despedir al CEO.");
          }
          default:
            System.out.println("Porfavor, inserte un numero del 0 al 3.");
        }
      }while(option!=3);
    }catch (InputMismatchException e3) {
      System.out.println("Ha ocurrido un error, introduzca un numero comprendido entre 0 y 3.");
    }
  }
/**
*Nombre: searchEmployee
*Descripcion: Metodo que busca un empleado pro su ódigo especifico.
*@param  id: Codigo especifico de cada empleado.
*@return Employee.
*/
  public Employee searchEmployee(int id){
    Employee tmp=null;
    boolean found=false;
    for(int i=0;i<workers.size()&&found!=true;i++){
      if(workers.get(i).getId()==id){
        found=true;
        System.out.println("El empleado que buscaba se ha encontrado.");
        tmp=workers.get(i);
      }else{
        System.out.println("No se ha encontrado el empleado.");
      }
    }
    return tmp;
  }
/**
*Nombre: listEmployee
*Descripcion: Metodo que lista la lista de empleados de la compañia.
*/
  public void listEmployee(){
    System.out.println("Esta es la lista de empleados de la compañia: ");
    for(int i=0;i<workers.size();i++){
        System.out.println(workers.get(i));
    }
  }
/**
*Nombre: totalSalary
*Descripcion: Calcula el salario de un empleado.
*@param  e:  Empleado al que se le va acalcular el salario.
*/
  public void totalSalary(Employee e){
    System.out.println("El salario total del empleado es "+e.salary);
  }
/**
*Nombre: AddPlane
*Descripcion: Metodo que añade un avion al ArrayList de aviones
*@param  p: Es el avion que se desea añadir
*@return boolean
*/
  public boolean AddPlane(Plane p){
    boolean added=false;
    if(p instanceof Plane){
      airnavy.add(p);
      added=true;
    }
    return added;
  }
/**
*Nombre: listPlane
*Descripcion: Metodo que lista la flota de aviones de la compañia.
*/
  public void listPlane(){
    System.out.println("Esta es la flota de aviones de la compañia: ");
   for(int i=0;i<airnavy.size();i++){
        System.out.println(airnavy.get(i));
    }
  }
  /**
  *@param p: Es el avion que se desea añadir
  *@return added: Sera true si se ha conseguido añadir el avion a la flota
  *Esete metodo añade aviones a la flota de la compañia
  */
  public boolean addPlane(Plane p){
    boolean added=false;
    if(p instanceof Plane){
      airnavy.add(p);
      added=true;
    }
    return added;
  }
/**
*Nombre: removePlane
*Descripcion: Borra un avion introducido por parametro.
@param  p: Es el avion que se desea eliminar
@return boolean
*/
  public boolean removePlane(Plane p){
    boolean eliminated=false;
    String code=p.getId();
    if(p instanceof Plane){
      if(airnavy.remove(searchPlane(code))){
        eliminated=true;
        System.out.println("Se ha destruido el avion indicado.");
      }else{
        System.out.println("No se ha podido destruir el avion indicado.");
        }
      }
      return eliminated;
  }

/**
*Nombre: searchPlane
*Descripcion: Metodo que busca un avion por su matricula en el ArrayList de aviones y lo devuelve.
*@param m: matricula del avion.
*@return Plane
*/
  public Plane searchPlane(String m){
    boolean found=false;
    Plane p=null;;
      for(int i=0;i<airnavy.size()&&found!=true;i++){
        if(airnavy.get(i).getId().equals(m)){
          found=true;
          p=airnavy.get(i);
          System.out.println("Se a localizado el avion que buscaba.");
        }else{
          System.out.println("No se ha localizado el avion.");
        }
      }
     return p;
  }
/**
*Nombre: addFlight
*Descripcion: Metodo que añade un vuelo, y devuelve un booleano si se ha podido añadir el vuelo o no.
*@param  f: es el vuelo que se desea añadir
*@return boolean
*/
  public boolean addFlight(Flight f){
    boolean added=false;
    if(f instanceof Flight){
      flights.add(f);
      added=true;
    }
    return added;
  }
/**
*Nombre: listFlight
*Descripcion: Metodo que lista los vuelos de la compañia.
*/
  public void listFlight(){
    System.out.println("Estos son los vuelos de la compañia: ");
    for(int i=0;i<flights.size();i++){
        System.out.println(flights.get(i));
    }
  }
/**
*Nombre: searchFlight
*Descripcion: Metodo que busca un vuelo por su codigo y lo devuelve.
*@param  code: Codigo del vuelo introducido.
*@return Flight
*/
  public Flight searchFlight(String code){
    boolean found=false;
    Flight tmp=null;;
      for(int i=0;i<flights.size()&&found!=true;i++){
        if(flights.get(i).getCode().equals(code)){
          found=true;
          tmp=flights.get(i);
          System.out.println("Se ha localizado el vuelo que estaba buscando.");
        }else{
          System.out.println("No se ha podido localizar el vuelo.");
        }
      }
      return tmp;
  }
/**
*Nombre: removeFlight
*Descripcion: Metodo que recibe un vuelo y lo elimina de la lista de vuelos de la compañia.
*@param  f:Es el vuelo que se desea eliminar
*@return boolean
*/
public boolean removeFlight(Flight f){
  boolean eliminated=false;
  String code=f.code;
  if(f instanceof Flight){
    if(flights.remove(searchFlight(code))){
      eliminated=true;
      System.out.println("El vuelo ha sido eliminado.");
    }else{
      System.out.println("El vuelo no pudo ser eliminado.");
    }
  }
  return eliminated;
}

/**
*Nombre: searchTicket
*Descripcion: Metodo que busca un ticket por su codigo de ticket.
*@param codeticket: Es el codigo del ticket que se busca
*@return Ticket
*/
public Ticket searchTicket(String codeticket){
  boolean found=false;
  Ticket tmp=null;
  for(int i=0;i<tickets.size()&&found!=true;i++){
    if(tickets.get(i).getCodeticket().equals(codeticket)){
      found=true;
      tmp=tickets.get(i);
      System.out.println("Se ha localizado, el ticket.");
    }else {
      System.out.println("No se pudo localizar el ticket.");
    }
  }
  return tmp;
}
/**
*Nombre: removeTicket
*Descripcion: Metodo que elimina un Ticket.
*@param  t:Es el ticket que se desea aliminar
*@return boolean
*/
public boolean removeTicket(Ticket t){
  boolean remove=false;
  String code=t.codeticket;
  if(t instanceof Ticket){
    tickets.remove(searchTicket(code));
    remove=true;
    System.out.println("Se ha eliminado el ticket. ");
  }else{
    System.out.println("No se ha podido eliminar el ticket. ");
  }
  return remove;
}
/**
*Nombre: addClient
*Descripcion: Metodo que añade un cliente al ArrayList de clientes
*@param  c: Es el cliente que se desea añadir
*@return boolean
*/
public boolean addClient(Client c){
  boolean added=false;
  if(c instanceof Client){
    clients.add(c);
    added=true;
  }
  return added;
}
/**
*Nombre: listClient
*Descripcion: Lista los Clientes de la compañia.
*/
public void listClient(){
  System.out.println("Esta es la lista de clientes de la compañia: ");
  for(int i=0;i<clients.size();i++){
      System.out.println(clients.get(i));
  }
}
/**
*Nombre: searchClient
*Descripcion: Metodo que busca a un cliente por su DNI en el ArrayList de Clientes de la compañia y lo devuelve.
*@param nif: DNI del cliente que queremos buscar.
*@return Client
*/
public Client searchClient(String nif){
  boolean found=false;
  Client tmp=null;
    for(int i=0;i<clients.size()&&found!=true;i++){
      if(clients.size()!=0){
          if(clients.get(i).getNif().equals(nif)){
            found=true;
              tmp=clients.get(i);
            System.out.println("Se ha localizado al cliente que estaba buscando. ");
            }
        }else{
          System.out.println("No existen clientes registrados");
      }
    }
    if(tmp==null){
        System.out.println("No se ha podido localizar al cliente. ");
    }
    return tmp;
}
/**
*Nombre: removeClient
*Descripcion: Metodo que elimina a un cliente del ArrayList de clientes de la compañia  y devuelve true si lo ha podido eliminar y false sino lo a podido quitar.
*@param c: Cliente que se quiere eliminar.
*@return boolean
*/
public boolean removeClient(Client c){
  boolean remove=false;
  String nif=c.getNif();
  if(c instanceof Client){
    clients.remove(searchClient(nif));
    remove=true;
    System.out.println("Se elimino al cliente de la base de datos. ");
  }else{
    System.out.println("No se ha podido eliminar al cliente de la base de datos. ");
  }
  return remove;
}
/**
*Nombre: showCEO
*Descripcion: Metodo que muestra al CEO de la compañia.
*/
public void showCEO(){
    System.out.println("El CEO de su compañia es "+this.ceo);

  }

}