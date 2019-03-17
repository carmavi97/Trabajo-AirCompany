package airlines.classes;
/**
*Nombre de la clase: Person
*Descripcion: Clase abstracta de la cual heredaran,las clases Employee y Client.
*@author:Vicente Losada Mesa
*@version:1.0
*/
abstract public class Person{
  protected final static String NIF_DEF="";
  protected final static String NAME_DEF="";
  protected final static String LASTNAME_DEF="";
  protected final static String BORNDATE_DEF="";
  protected final static String NATIONALITY_DEF="";

  protected String NIF;
  protected String name;
  protected String lastname;
  protected String borndate;
  protected String nationality;
/**
*CONSTRUCTOR POR DEFECTO:
*Recibe los parametros establecidos final static (Constantes) y construye una persona por defecto la cual
heredaran las demas clases.
*/
  public Person(){
    this(NAME_DEF,LASTNAME_DEF,BORNDATE_DEF,NIF_DEF,NATIONALITY_DEF);
  }
/**
*CONSTRUCTOR COMPLETO:
*@param name: Nombre de la persona.
*@param lname: Apellidos de la persona.
*@param bd: Fecha de nacimiento de la persona.
*@param nif: NIF de la persona.
*@param nt: Nacionalidad de la persona.
*/
  public Person(String name, String lname, String bd, String nif, String nt){
    this.name=name;
    this.lastname=lname;
    this.borndate=bd;
    this.NIF=nif;
    this.nationality=nt;
  }

/**
*Nombre del metodo: checkNif
*Descripcion: Recibe un Nif y comprueba que sea valido, si lo es devuelve true,sino false.
*@param nif: Es el dni que se desea validar
*@return boolean: Devuelve true si el nif es valido, y false sino es valido.
*/
  public boolean checkNif(String nif){
    boolean valide=false;
		if(nif.length()==9){
			if(Character.isDigit(nif.charAt(0))&&Character.isDigit(nif.charAt(1))&&
				Character.isDigit(nif.charAt(2))&&Character.isDigit(nif.charAt(3))&&
				Character.isDigit(nif.charAt(4))&&Character.isDigit(nif.charAt(5))&&
				Character.isDigit(nif.charAt(6))&&Character.isDigit(nif.charAt(7))&&
				Character.isLetter(nif.charAt(8))){
					String miletra=""+nif.charAt(8);
					if(miletra.toUpperCase().equals(this.calculateLetter(nif.substring(0,8)))){
						valide=true;
					}
				}
		}
		return valide;
  }
  /**
  *Nombre del metodo: calculateLetter
  *Descripcion: Calcula la letra de un nif y la devuelve.
  *@param nif: Es el dni que se desea validar
  *@return String: Devuelve la letra del nif introducido.
  */
  protected String calculateLetter(String nif){
    int myNIF = Integer.parseInt(nif.substring(0,8));
        int rest = 0;
        String myLetter = "";
        String[] asignationLetter = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
         "H", "L", "C", "K", "E"};

        rest = myNIF % 23;

        myLetter = asignationLetter[rest];

        return myLetter;
  }
    @Override
    public String toString(){
        return("Soy "+this.name+" "+this.lastname+" con DNI "+this.NIF);
    }
}
