package airlines.classes;
import java.util.ArrayList;

/**
*@author: Carlos Martínez Villandos 
*@version 1.0
* clase que almacenara la informacion de los aeropuertos
*/
public class Airport{
    protected static final String CODE_PRE="";
    public static final String NAME_PRE="";
    public static final String COUNTRY_PRE="";
    public static final String CITY_PRE="";
    
    protected String code;
    public String name;
    public String country;
    public String city;
    protected ArrayList<String> services=new ArrayList<String>();
    
    /**
    *@param code: Es el codigo que identifica al aeropuerto
    *@param name:Es el nombre dekl aeropuerto 
    *@param country:Es el nombre del pais dond eesta el aeropuerto
    *@param city: Es el nombre de la ciudad donde esta el aeropuerto 
    */
    public Airport(String code, String name, String country, String city){
        this.code=code;
        this.name=name;
        this.country=country;
        this.city=city;
    }
    
    public Airport(){
        this(CODE_PRE,NAME_PRE,COUNTRY_PRE,CITY_PRE);
    }
    
    public String getCode(){
        return this.code;
    }
    
    public void setCode(String code){
        this.code=code;
    }
    /**
    *return secicios es un String formado por los servicios que hay en el aeropuerto 
    *Crea un String que es la union de los String que nombran los metodos del aeropuerto para 
    facilitar la impresion
    */
    private String printServices(){
        String servicios="";
        for(int i=0;i<services.size();i++){
            servicios=servicios+" "+services.get(i)+",";
        }
        return servicios;
    }
    
    /**
    *@param service: Es un String que es el nombre del servicio que se desea añadir
    *Añade un servicio a la lista
    */
    public void addService(String service){
        services.add(service);
    }
    /*
    *@param: service es un String que es el nombre del servicio que se desea eliminar
    *Borra un servicio de la lista
    */
    public void deleteService(String service){
        services.remove(services.indexOf(service));
    }
    @Override
    public String toString(){
        return "El aeropuerto "+this.name+ "("+this.getCode()+")"+" se encuentra en "+this.city+", "
            +this.country;
    }
}
