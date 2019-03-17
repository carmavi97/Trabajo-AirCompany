import java.util.Scanner;
import java.util.InputMismatchException;
import airlines.classes.*;
/**
*Nombre: AirCompany
*Descripcion: Main Programa principal.
*@author: Raul Cardenas & Carlos Martínez
*@version: 1.0
*/

public class Main{
	public static void main(String[] args) {
        Menu menu=null;
        menu=menu.getInstance();
		Scanner teclado;
		int opcion;

        CEO Carlos=new CEO("Carlos","Serrano","14/02/1987","42126069M","Español",5000,"Español");
        AirCompany company=new AirCompany("IBERIA",Carlos,"14/02/2019");
        company.workers.add(Carlos);
        
        Airport airport1 = new Airport("COR","Aeropuerto Cordoba","Espana","Cordoba");
        Airport airport2 = new Airport("MAD","Madrid-Barajas Adolfo Suarez","Espana","Madrid");
        Airport airport3 = new Airport("BCN","Josep Taradellas Barcelona-El Prat","Espana","Barcelona");
        Airport airport4 = new Airport("JFK","Aeropuerto de New York JFK","EE.UU","New York");
        Airport airport5 = new Airport("BIO","Aeropuerto de Loiu ","España","Bilbao");
        Airport airport6 = new Airport("VAL","Aeropuerto de Manises","España","Valencia");

        company.airports.add(airport1);
        company.airports.add(airport2);
        company.airports.add(airport3);
        company.airports.add(airport4);
        company.airports.add(airport5);
        company.airports.add(airport6);
        
		Tripulation tripu1=new Tripulation("Jesus","Luque","12/08/1991","03146050H","Español");
        company.workers.add(tripu1);
		Tripulation tripu2=new Tripulation("Pablo","Exposito","18/01/1995","23000080B","Español");
        company.workers.add(tripu2);
        
		Pilot pilot1=new Pilot("Vicente", "Losada", "10/02/1999","18329101X","Español",10);
        company.workers.add(pilot1);
		Pilot pilot2=new Pilot("Manuel", "Cerezo", "04/08/1980", "47616796B", "Ingles",20);
        company.workers.add(pilot2);
		AirBusA320 plane1=new AirBusA320("IBA0001","08/03/2008");
        company.airnavy.add(plane1);
		Flight cm=new Flight(airport2, airport1,company,"2019/03/11 08:00",50,pilot1, pilot2,plane1,80);
		company.flights.add(cm);
		Flight mb=new Flight(airport3,airport2,company,"2019/03/11 09:30",40,pilot1,pilot2,plane1,50);
        company.flights.add(mb);
        
		AirBusA320 plane2=new AirBusA320("IBA002","27/02/2011");
        company.airnavy.add(plane2);
        Pilot pilot3=new Pilot("Carlos", "Martinez", "10/05/1999","86900961S","Aleman",15);
        company.workers.add(pilot3);
		Pilot pilot4=new Pilot("Andres", "Carrasco", "07/11/1999","76649450H","Ruso",15);
        company.workers.add(pilot4);
        
		Flight mv=new Flight(airport6,airport2,company,"2019/03/11 11:00",45,pilot3,pilot4,plane2,60);
		company.flights.add(mv);
		Flight vb=new Flight(airport5,airport6,company,"2019/03/11 12:30",45,pilot3,pilot4,plane2,60);
        company.flights.add(vb);
        
        Pilot pilot5=new Pilot("Antonio", "Raya", "09/12/1992","46612840M","Español",100);
        company.workers.add(pilot5);
		Pilot pilot6=new Pilot("Angel", "Martin", "01/03/1980","06431965S","Argentino",200);
        company.workers.add(pilot6);
		Boing787 plane3=new Boing787("IBB0001","05/12/2013");
        company.airnavy.add(plane3);

		Flight mn=new Flight(airport4,airport2,company,"2019/03/11 19:00",620,pilot5,pilot6,plane3,600);
        company.flights.add(mn);
		
        
        Client cliente1=new Client("Carlos","Martinez","01/12/1997","46271355r","Español");
        company.clients.add(cliente1);
		/**
		*Nombre: Menu
		*Descripcion: Muestra el menu que utilizara el programa principal
		*/
		try{
			teclado=new Scanner(System.in);
			do{	
					menu.Print();
					opcion=leeOpcion(teclado);
					switch(opcion){
						case 0:
								System.out.println("Adios");
								break;
						case 1:  
								menu.buyTicket(company);
								break;
						case 2: 
								menu.searchTicket(company);
								break;
						case 3: 
								menu.removeTicket(company);
								break;
						case 4: 
								company.listFlight();
								break;
						case 5: 
								company.listEmployee();
								break;
						case 6: 
								company.listClient();
								break;
						case 7: 
								company.listPlane();
								break;
						case 8: 
								menu.calculateSalary(company);
								break;
						case 9: 
								menu.calculateRentavility(company);
								break;
						default: System.out.println("Inserte un número del 0 al 9");
					}
			}while(opcion!=0);
		}catch(InputMismatchException e){
			System.out.println(e);
	}
}
    
/**
 *Nombre: leeOption
 *Descripcion: Metodo que lee la opcion elegida por el usuario
*/
	static int leeOpcion(Scanner t){
		int opcion;
		try{
			opcion=t.nextInt();
		}catch(InputMismatchException e){
			t=new Scanner(System.in); //reestablecemos lectura de flujo de entrada.
			opcion=0;
		}catch(Exception e){
			System.out.println("Error en el sistema");
			opcion=0;
		}
		return opcion;
	}
}