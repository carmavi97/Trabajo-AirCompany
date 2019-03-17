package airlines.classes;
import airlines.classes.Employee;
import airlines.classes.AirCompany;
/**
*Nombre: CEO
*Descripcion: Clase Ceo que se utilizara en la clase AirCompany, para mostrar quien es el ceo de esa compañia.
*@author: Raul Cardenas y Vicente Losada.
*@version: 1.0
*/
public class CEO extends Employee{
  protected String n_company;
/**
*CONSTRUCTOR COMPLETO:
*Descripcion: Crea un CEO para la compañia aerea, con lo parametros de un empleado.
*@param name: Nombre del CEO.
*@param lastName: Apellido del CEO.
*@param bd: Fecha de nacimiento del CEO.
*@param nif: Nif del CEO.
*@param nt: Nacionalidad del CEO.
*@param salary: Salario del CEO.
*@param lang: Lenguaje del CEO.
*/
  public CEO(String name,String lastName,String bd,String nif,String nt, int salary,String lang){
    super(name,lastName,bd,nif,nt,salary);
    addLanguages(lang);
    
  }
@Override
  protected void doFlight(Flight v){
      
  }

 @Override
 public String toString(){
   return super.toString()+" y soy el CEO de la compañia "+this.n_company;
 }

}