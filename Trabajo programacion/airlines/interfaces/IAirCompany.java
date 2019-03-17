package airlines.interfaces;
import airlines.classes.CEO;
import airlines.classes.Client;
import airlines.classes.Ticket;
import airlines.classes.Flight;
import airlines.classes.Plane;
import airlines.classes.Employee;
import java.util.Scanner;
/**
	* Nombre: IAirCompany
	* Descripcion: Interfaz de AirCompany
	* @author: Raul Cardenas
	* @version: 1.0
*/
public interface IAirCompany{
	public void hireEmployee(Employee e);
	public void fireEmployee(Employee e);
	public void listEmployee();
	public Employee searchEmployee(int id);
    public void totalSalary(Employee e);

	public boolean addPlane(Plane p);
	public void listPlane();
	public boolean removePlane(Plane p);
	public Plane searchPlane(String m);

	public boolean addFlight(Flight f);
	public void listFlight();
	public Flight searchFlight(String code);
	public boolean removeFlight(Flight f);
	//!!!¿NO HARIA FALTA UN ADDTICKET?!!
	public boolean removeTicket(Ticket t);
	public Ticket searchTicket(String codeticket);
	//TENGO VARIAS DUDAS EN LOS METODOS DE TICKET y en la clase tambien.
	public boolean addClient(Client c);
	public void listClient();
	public Client searchClient(String nif);
	public boolean removeClient(Client c);
	//AGREGADOS POR NOSOTROS:
	public void showCEO();
	public void listMenu();
	public void listFire();
	public void listShop();
	public void GenerateCode(String n);
	public int readOption(Scanner opt);
}