package airlines.classes;
import airlines.classes.Flight;
/**
*Nombre de la clase: Tripulation
*@author: Vicente Losada Mesa
*@version: 1.0
*Descripcion: Clase tripulacion que servira para crear tripulantes.
*/
public class Tripulation extends Employee{
  protected final static int SALARY_DEF=40000;
  protected int salary;
  /**
  *CONSTRUCTOR POR DEFECTO:
  *Llama al constructor del padre y ademas usa la constante SALARY_DEF para establecer el salario del tripulante.
  */
  public Tripulation(){
    super(NAME_DEF,LASTNAME_DEF,BORNDATE_DEF,NIF_DEF,NATIONALITY_DEF,SALARY_DEF);
  }
  /**
    *CONSTRUCTOR COMPLETO:
    *@param name: Nombre del tripulante.
    *@param lname: Apellidos del tripulante.
    *@param bd: Fecha de nacimiento del tripulante.
    *@param nif: NIF del tripulante.
    *@param nt: Nacionalidad del tripulante.
    */
  public Tripulation(String name, String lname, String bd, String nif, String nt){
    this.name=name;
    this.lastname=lname;
    this.borndate=bd;
    this.NIF=nif;
    this.nationality=nt;
    this.salary=SALARY_DEF;
  }

  @Override
  public String toString(){
    return super.toString();
  }
/**
  *Nombre del metodo: doFlight
  *Descripcion: Metodo que aumenta las horas de vuelo del tripulante y modifica el salario del mismo.
  *@param v: Es el vuelo que realiza el tripulante
  */
  @Override
  protected void doFlight(Flight v){
    this.salary=salary+1000;
  }
}