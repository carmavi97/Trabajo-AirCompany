package airlines.classes;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import airlines.classes.*;



/**

*Nombre de la clase: Menu
*Descripcion: Esta clase contrendra la mayoriade los metodos usados en el menu de el main
*@author:Carlos Martínez Villamandos
*@version:1.0
*/


public class Menu{

    private static Menu instance;

    private Menu(){

    }
    public static Menu getInstance(){
        if(instance==null){
            instance=new Menu();
        }
        return instance;
    }



    /**
    *Nombre: imprimeMenu
    *Descripcion: Muestra por pantalla el menu correspondiente
    */
    public void Print(){
        System.out.println("Bienvenidos al aeropuerto");
		System.out.println("0. Salir");
		System.out.println("1. Buscar vuelo");
		System.out.println("2. Consultar billete");
		System.out.println("3. Eliminar billete");
		System.out.println("4. Listar vuelos");
		System.out.println("5. Listar empleados");
		System.out.println("6. Listar clientes");
		System.out.println("7. Listar flota");
		System.out.println("8. Calcular salarios total");
		System.out.println("9. Calcular la rentabilidad de un vuelo");
    }

    /**
    *El metodo pedira al usuario por pantalla el codigo de un vuelo, tras lo cual imprimira si este es rentable o no
    *@param company: se trata de la compañia a la que pertece el vuelo
    */
    public void calculateRentavility(AirCompany company){
        System.out.println("Por favor, introduzca el codigo del vuelo que desea buscar");
        Scanner teclado=new Scanner(System.in);
        String code=teclado.nextLine();
        Flight flight=company.searchFlight(code);
        if(flight!=null){
            if(flight.Rentavility()){
                System.out.println("El precio de este vuelo es "+flight.plane.getComsumption()*flight.duration+" euros, ha recaudado "+flight.getGains()+" es rentable.");
            }else{
                System.out.println("El precio de este vuelo es "+flight.plane.getComsumption()*flight.duration+" euros, ha recaudado "+flight.getGains()+" no es rentable.");
            }
        }
    }
    /**
    *El metodo pedira direntes datos al usuario y los usara para encontra un vuelo, luego mostrala los asientos disponibles de dicho vuelo y
    le pedira que seleciones el billete que desa comprar, tras esto le pedira sus datos y si no esta registrado le pedira que se registre para
    realizar la compra
    *@param company: Es la compañia con la que se trabaja
    */
    public void buyTicket(AirCompany company){
        ArrayList<Flight> offers=new ArrayList<Flight>();
        boolean correct=false;
        Flight selected=null;
        Client client=null;
        int tic=0;
        System.out.println("¿Desde donde desea viajar?");
        String origin=this.searchFlight(company);
        if(origin!=null){
            System.out.println("¿A donde desea viajar?");
            String destination=this.searchFlight(company);
            if(destination!=null){
                 for(int i=0;i<company.flights.size();i++){
                     if(origin.equals(company.flights.get(i).getStart().getCode())&&destination.equals(company.flights.get(i).getDestination().getCode())){
                         offers.add(company.flights.get(i));
                     }
                 }
                if(offers.size()!=0){
                    do{
                        printOffers(offers);
                        System.out.println("Selecione el vuelo que desea o 0 para salir del menu");
                        Scanner teclado=new Scanner(System.in);
                        int wanted=0;
                        try{
                            wanted=teclado.nextInt();
                            if(wanted==0||wanted<(offers.size()+1)){
                                correct=true;
                                if(wanted!=0){
                                    selected=offers.get(wanted-1);
                                    ArrayList<Ticket> tickets=select(selected);
                                    System.out.println("Selecione el ticket que desea o 0 para salir del menu");
                                    try{
                                        tic=teclado.nextInt();
                                         if(tic<0||tic<(tickets.size()+1)){
                                             if(tickets.get(tic).getSold()==false){
                                                   client=checkClient(company);
                                                if(client!=null){
                                                    tickets.get(tic).sellTicket(client);
                                                    System.out.println("Gracias por volar con nosotros");
                                                    System.out.println("Su codigo de billete es "+tickets.get(tic).getCodeticket()+
                                                                                           " el codigo de su vuelo es "+selected.getCode()+
                                                                                           " y sale con fecha "+selected.getDate());
                                                }else{
                                                    boolean flag=false;
                                                    do{
                                                        System.out.println("Debe estar registrado para poder compar un billete, ¿desea registrarse? (s/n)");
                                                        Scanner teclado2=new Scanner(System.in);
                                                        char re;
                                                        try{
                                                            re=teclado2.nextLine().charAt(0);
                                                            if(re=='s'||re=='n'){
                                                                flag=true;
                                                                if(re=='s'){
                                                                    client=signUp(company);
                                                                    if(client!=null){
                                                                        company.clients.add(client);
                                                                        tickets.get(wanted).sellTicket(client);
                                                                        System.out.println("Gracias por volar con nosotros");
                                                                        System.out.println("Su codigo de billete es "+tickets.get(tic).getCodeticket()+
                                                                                           " el codigo de su vuelo es "+selected.getCode()+
                                                                                           " y sale con fecha "+selected.getDate());
                                                                    }else{
                                                                        System.out.println("Ha ocurrido un error");
                                                                        flag=false;
                                                                    }
                                                                }else{
                                                                    System.out.println("Adios");
                                                                }
                                                            }else{
                                                                System.out.println("Opcion no validad");
                                                            }
                                                        }catch(InputMismatchException e){
                                                            System.out.println(e);
                                                            System.out.println("error");
                                                        }
                                                    }while(flag==false);
                                                }
                                             }else{
                                                 System.out.println("Error, billete ya vendido");
                                             }

                                        }else{
                                            System.out.println("Introduzca una opcion correcta");
                                            correct=false;
                                        }
                                    }catch(InputMismatchException e){
                                        System.out.println(e);
                                        correct=false;
                                    }
                                }else{
                                    System.out.println("Adios");
                                }
                            }else{
                                System.out.println("Introduzca una opcion correcta");
                            }
                        }catch(InputMismatchException e){
                            System.out.println(e);
                        }
                    }while(correct==false);
                }else{
                    System.out.println("No se ofertan vuelos que haga esa ruta");
                }
            }else{
                System.out.println("No se ofertan vuelos hacia ese aeropuerto, o los datos eran incorrectos");
            }
        }else{
            System.out.println("No se ofertan vuelos desde ese aeropuerto, o los datos eran incorrectos");
        }
    }
    /**
    *Este metodo permite a un cliente nuevo registrarse
    *@return client: Es el cliente creado
    @param company: Es la compañia con la que se trabaja
    */
    private Client signUp(AirCompany company){
        boolean correct=false;
        System.out.println("Introduzca su nombre");
        Scanner teclado=new Scanner(System.in);
        String name=teclado.nextLine();
        System.out.println("Introduzca su apellido");
        String lastName=teclado.nextLine();
        System.out.println("Introduzca su DNI");
        String nif=teclado.nextLine();
        System.out.println("Introduzca su nacionalidad");
        String nationality=teclado.nextLine();
        System.out.println("Introduzca su fecha de nacimiento(DD/MM/YYYY)");
        String bornDate=teclado.nextLine();
        Client client=new Client(name,lastName,bornDate,nif,nationality);
        correct=true;
        return client;
    }

    /**
    *Este metodo comprueba si el cliente esta registrado por su dni
    *@return client: Es el cliente en cuestion, que sera null si no existe
    @param company: Es la compañia con la que se trabaja
    */
    private Client checkClient(AirCompany company){
        Scanner teclado=new Scanner(System.in);
        boolean correct=false;
        Client client=null;
        char opcion;
        do{
            System.out.println("Introduzca su DNI por favor");
            String nif=teclado.nextLine();
            client=company.searchClient(nif);
            if(client==null){
                System.out.println("Su DNI no corresponde con la base de datos, ¿desea volver a intentarlo? (s/n)");
                try{
                    opcion=teclado.nextLine().charAt(0);
                    if(opcion=='s'||opcion=='n'){
                        correct=true;
                        if(opcion=='s'){
                            client=checkClient(company);
                        }
                    }else{
                        System.out.println("Opcion no validad");
                    }
                }catch(InputMismatchException e){
                    System.out.println(e);
                }
            }else{
                correct=true;
            }
        }while(correct==false);
        return client;
    }

    /**
    *Este metodo sirve para selecionar un vuleo de los impresos en buyticket e imprimir los billetes disponibles
    *@param selected: Es el vuelo que ha selecionado el usuario
    *@return tickets: Es un arraylist de los tickets disponibles
    */
    private ArrayList<Ticket> select(Flight wanted){
        ArrayList<Ticket> tickets=new ArrayList<Ticket>();
        int k=0;
        for(int i=0;i<wanted.getSeats().length;i++){
            for(int j=0;j<wanted.getSeats()[i].length;j++){
                if(wanted.getSeats()[i][j].ticket.getSold()==false){
                    tickets.add(wanted.getSeats()[i][j].ticket);
                    k++;
                    System.out.print(k+") "+wanted.getSeats()[i][j].ticket+" ");
                }else{
                    System.out.print(" VENDIDO ");
                }
            }
            System.out.println(" ");
        }
        return tickets;
    }
    /**
    *Este metodo imprime los vuelos disponibles de un recorrido
    *@param offers: SE treata de una arraylist de vuelos que se dean imprimir
    */
    private void printOffers(ArrayList<Flight> offers){
        for(int i=0;i<offers.size();i++){
            if(i==0||i%2==0){
                System.out.print((i+1)+")"+offers.get(i).getCode()+"     ");
            }else{
                System.out.println((i+1)+")"+offers.get(i).getCode());
            }
        }
        System.out.println(" ");
    }
    /**
    *Este metodo sera utilizado para pedir al usuario el nombre de un aeropuerto y buscarlo en la base de datos de la compañia
    para saber si la compañia opera en ese aeropuerto
    *@param company: Es la compañia aerea con la que se trabaja
    *@return airport: Es el codigo del aeropuerto que se busca, en ecaso de que no este ne la base de datos de la compañia sera null
    */
    private String searchFlight(AirCompany company){
        boolean found=false;
        String airport=null;

        System.out.println("Por favor, introduzca el nombre del aeropuerto");
        Scanner teclado=new Scanner(System.in);
        String wanted=teclado.nextLine();
        for(int i=0;i<company.airports.size()&&found!=true;i++){
            if(wanted.equals(company.airports.get(i).getCode())||wanted.equals(company.airports.get(i).name)){
                airport=company.airports.get(i).getCode();
                found=true;
            }
        }
        return airport;
    }
    /**
    *Este metodo sirve para selecionar un ticket de los impresos en buyticket
    *@param selected: Es el ticket que ha selecionado el usuario
    */
    private void pickTicket(int selected){

    }
    /**
    *Este metodo pide un codigo de ticket, y en caso de que se corresponda al de un ticket, pide al usuario que se identifique, si esta registrado imprime el vuelo al que pertenece
    *@param company: la compañia con la que se trabaja
    */
    public void searchTicket(AirCompany company){
        boolean real=false;
        System.out.println("Por favor, introduzca el identificador del billete");
        Scanner teclado=new Scanner(System.in);
        String code=teclado.nextLine();
        String cFlight=code.substring(0,(code.length()-2));
        if(company.searchFlight(cFlight)!=null){
            System.out.println("Por favor, introduzca su DNI");
            teclado=new Scanner(System.in);
            String dni=teclado.nextLine();
            if(company.searchClient(dni)!=null){
                System.out.println(company.searchFlight(cFlight));
            }else{
            System.out.println("Error,por favor introduzca un valor correcto");
            }
        }else{
            System.out.println("Error,por favor introduzca un valor correcto");
        }
    }

    /**
    *Este metodo pide un codigo de ticket, y en caso de que se corresponda al de un ticket, pide al usuario que se identifique, si esta registrado borra el billete
    *@param company: la compañia con la que se trabaja
    */
    public void removeTicket(AirCompany company){
        boolean real=false;
        System.out.println("Por favor, introduzca el identificador del billete");
        Scanner teclado=new Scanner(System.in);
        String code=teclado.nextLine();
        String cFlight=code.substring(0,(code.length()-2));
        if(company.searchFlight(cFlight)!=null){
            System.out.println("Por favor, introduzca su DNI");
            teclado=new Scanner(System.in);
            String dni=teclado.nextLine();
            Client client=company.searchClient(dni);
            if(client!=null){
                    for(int i=0;i<company.tickets.size();i++){
                        Ticket ticket=company.tickets.get(i);
                       if(ticket.getCodeticket().equals(code)&&
                         ticket.getClient().equals(client)){
                           ticket.refundTicket();
                        }
                    }
            }
        }
    }

    /**
    *Este metodo calcula el salario total de todos los empleados
    *@param company:La compañia con la que se trabaja
    */
    public void calculateSalary(AirCompany company){
        int salary=0;
        for(int i=0;i<company.workers.size();i++){
            salary=salary+company.workers.get(i).getSalary();
        }
        System.out.println("El salario total de todos los empleados es de "+salary);
    }
}
