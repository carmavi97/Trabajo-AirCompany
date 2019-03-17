package airlines.classes;
import airlines.classes.Person;
import airlines.classes.Flight;
import java.util.Scanner;
import java.util.ArrayList;
/*
*Nombre de la clase: Employee
*@author: Carlos Martínez Villamndos 
*@version 1.0
* clase abstracta que servira para crear tripulacion y pilotos
*/

abstract public class Employee extends Person{
    
    protected static final int SALARY_PRE=0;
    protected static int nEmployee=0;
    
    protected int id=0;
    protected ArrayList<String> idiomas=new ArrayList<String>();
    protected int salary;
    
    /*
    *@param salary: Es el salario del empleado
    */
    protected Employee(String name,String lastName,String bornDate ,String nif, String nationality, int salary){
        super(name,lastName,bornDate,nif,nationality);
        this.salary=salary;
        nEmployee++;
        this.id=nEmployee;
    }
    
    protected Employee(){
        super();
        this.salary=SALARY_PRE;
        nEmployee++;
        this.id=0;
    }
    
    protected int getId(){
        return this.id;
    }
    
    protected int getSalary(){
        return this.salary;
    }
    /*
    *@param language es lenguaje que habla el empleado
    * Añade al arraylist de idiomas los idiomas que el empleado habla
    */
    protected void addLanguages(String language) {
        idiomas.add(language);
    }
    /*
    *@param v es el vuelo que realiza
    * hace los cambios pertinentes a cuando el empleado realiza un vuelo
    */
    abstract protected void doFlight(Flight v);
    /*
    *@return lenguas Strign de lenguas que conoce el empleado
    * crea un string de las lenguas que el empleado conoce para facilitar su impresion
    */
    private String idiomasQueSe(){
        String lenguas="";
        for(int i=0;i<idiomas.size();i++){
            lenguas=lenguas+" "+idiomas.get(i);
        }
        return lenguas;
    }
    @Override
    public String toString(){
        return "Soy "+this.name+" "+this.lastname+" naci el "+this.borndate+" soy "+this.nationality
            +" cobro,"+this.salary+" y hablo "+this.idiomasQueSe();
    }
}