package airlines.classes;
/**
*Nombre de la clase: Pilot
*@author: Vicente Losada Mesa
*@version: 1.0
*Descripcion: Clase Piloto que equivale a el empleado fisico que pilotara un avion.
*/
public class Pilot extends Employee{
    protected final static int SALARY_DEF=100000;
    protected int hfligth;
    protected int salary;
/**
*CONSTRUCTOR POR DEFECTO:
*Llama al constructor del padre y ademas usa la constante SALARY_DEF para establecer el salario del piloto.
*/
  public Pilot(){
    super(NAME_DEF,LASTNAME_DEF,BORNDATE_DEF,NIF_DEF,NATIONALITY_DEF,SALARY_DEF);
    this.salary=SALARY_DEF;
    this.hfligth=0;
  }
/**
  *CONSTRUCTOR COMPLETO:
  *@param name: Nombre del piloto.
  *@param lname: Apellidos del piloto.
  *@param bd: Fecha de nacimiento del piloto.
  *@param nif: NIF del piloto.
  *@param nt: Nacionalidad del piloto.
  *@param hv: Horas de vuelo que tiene el piloto.
  */
  public Pilot(String name, String lname, String bd, String nif, String nt,int hv){
    this.name=name;
    this.lastname=lname;
    this.borndate=bd;
    this.NIF=nif;
    this.nationality=nt;
    this.salary=SALARY_DEF;
    this.hfligth=hv;
  }
/**
*Nombre del metodo: toString
*Descripcion: Metodo sobreescrito, del toString del padre.
*@return String: Devuelve el toString del padre modificado con las horas de vuelo del piloto.
*/
  @Override
  public String toString(){
    return super.toString()+" tengo acumuladas "+this.hfligth+" horas de vuelo.";
  }
  /**
  *Nombre del metodo: doFlight
  *Descripcion: Metodo que aumenta las horas de vuelo del piloto y modifica el salario del mismo.
  *@param v: Recibe un vuelo y toma su variable de horas de vuelo.
  */
  @Override
  protected void doFlight(Flight v){
    this.hfligth=hfligth+v.duration;
    //HORAS DE VUELO DEL VUELO
    this.salary=salary+5000;
  }
}