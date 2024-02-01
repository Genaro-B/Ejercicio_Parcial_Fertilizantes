/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial.utn;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class DDJJIngresoFertilizante {
    Scanner leer=new Scanner(System.in);
    Scanner leerEnteros=new Scanner(System.in);
    /*
    Cree la clase java DDJJIngresoFertilizante (Declaracion Jurada de Ingreso de Fertilizantes) la cual
debe contener los siguientes atributos privados
o anioDeclaracion de tipo int
o mesDeclaracion de tipo int
o montoXIngreso de tipo double
o empresa de tipo String
o cuitEmpresa de tipo long
o detallesFertilizantes array tipo String de 2 dimensiones:
    */
    private int anioDeclaracion;
    private int mesDeclaracion;
    private double montoXIngreso;
    private String empresa;
    private long cuitEmpresa;
    private int cantFertilizantes;
    private String[][] detallesFertilizantes;

   //Genere los correspondientes métodos get / set públicos para cada una de las variables de la clase 
    
    public int getAnioDeclaracion() {
        return anioDeclaracion;
    }

    public int getMesDeclaracion() {
        return mesDeclaracion;
    }

    public double getMontoXIngreso() {
        return montoXIngreso;
    }

    public String getEmpresa() {
        return empresa;
    }

    public long getCuitEmpresa() {
        return cuitEmpresa;
    }

    public String[][] getDetallesFertilizantes() {
        return detallesFertilizantes;
    }

    public void setAnioDeclaracion(int anioDeclaracion) {
        this.anioDeclaracion = anioDeclaracion;
    }

    public void setMesDeclaracion(int mesDeclaracion) {
        this.mesDeclaracion = mesDeclaracion;
    }

    public void setMontoXIngreso(double montoXIngreso) {
        this.montoXIngreso = montoXIngreso;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setCuitEmpresa(long cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public void setDetallesFertilizantes(String[][] detallesFertilizantes) {
        this.detallesFertilizantes = detallesFertilizantes;
    }

    public int getCantFertilizantes() {
        return cantFertilizantes;
    }
    
    /*
    Solicite al usuario los datos razón social de la empresa, el cuit, el año y mes de la
declaración y asigne los mismos en los correspondientes atributos. Valide que la razón
social no sea vacía, que el cuit posea 11 dígitos y que el mes y año de la declaración no
supere el mes y año actual, si los datos no cumplen esta condición mostrar un mensaje y
solicitar el ingreso nuevamente.
    */
    public void registrarDatos(){
        int año = 0,mes = 0;
        long cuit = 0;
        String empresa = null;
       boolean control=true;
       
       while(control){
           System.out.println("Ingrese el nombre de la empresa");
           empresa=leer.nextLine();
           System.out.println("Ingrese el cuit de la empresa");
           cuit=leerEnteros.nextLong();
           System.out.println("Ingrese el año actual");
           año=leerEnteros.nextInt();
           System.out.println("Ingrese el mes actual");
           mes=leerEnteros.nextInt();
           if(!empresa.equals("")){
               if(String.valueOf(cuit).length()==11){
                   if(año>0&año<=2024){
                       if(mes>0&mes<=12){
                           System.out.println("Datos cargados exitosamente");
                           control=false;
                       }else{
                           System.out.println("El dato mes debe ser valido(entre 1 y 12)");
                       }
                   }else{
                       System.out.println("El dato año debe ser valido,no puede ser mayor al actual");
                   }
               }else{
                   System.out.println("EL dato cuit Empresa debe contener 11 digitos para considerarse valido");
               }
           }else{
               System.out.println("El dato nombre empresa no puede estar vacio");
           }
           
           
       }
       this.anioDeclaracion=año;
       this.cuitEmpresa=cuit;
       this.mesDeclaracion=mes;
       this.empresa=empresa;
        
        
    }
    /*Solicitar al usuario la cantidad de fertilizantes discriminados por tipo envase que desea
ingresar a la provincia. Validar que el número ingresado sea mayor a cero. Aplique el
valor ingresado por el usuario para inicializar la variable detallesFertilizantes de la clase
DDJJIngresoFertilizante con el tamaño indicado: Ejemplo si se ingresa 12 el array tendrá
un tamaño de 12 filas por 6 columnas.*/
    public void cantFertilizantes(){
        int cant=0;
        do{
            System.out.println("Ingrese la cantidad de fertilizantes que desea ingresar al pais!");
            cant=leerEnteros.nextInt();
            if(cant>0){
                System.out.println("Dato cargado");
            }else{
                System.out.println("La cantidad de fertilizantes a ingresar debe ser mayor a 0");
            }
        }while(cant<=0);
        this.cantFertilizantes=cant;
        detallesFertilizantes=new String[cant+1][6];
        detallesFertilizantes[0][0]="Codigo Fertilizante";
        detallesFertilizantes[0][1]="Nombre";
        detallesFertilizantes[0][2]="Tipo-E";
        detallesFertilizantes[0][3]="Capacidad-E";
        detallesFertilizantes[0][4]="Cant-E";
        detallesFertilizantes[0][5]="Subtotal";
    }
    
    
    //aplicar la informacion obtenida para cargar el array de detallesFertilizantes de la instancia,
    
    public void ubicarInformacion(String codigoFertilizante,String nombreFertilizante,String tipoEnvase,String capacidad,String cantEnvase,String subtotal){
        int fila = 0;
        
        for(int i=0;i<detallesFertilizantes.length;i++){
            if(detallesFertilizantes[i][0]==null){
                fila=i;
                break;
            }
        }
        detallesFertilizantes[fila][0]=codigoFertilizante;
        detallesFertilizantes[fila][1]=nombreFertilizante;
        detallesFertilizantes[fila][2]=tipoEnvase;
        detallesFertilizantes[fila][3]=capacidad;
        detallesFertilizantes[fila][4]=cantEnvase;
        detallesFertilizantes[fila][5]=subtotal;
    }
    
    public void calcularTotalAbonoIngreso(){
        
        int total=0;
        
        for(int i=1;i<detallesFertilizantes.length;i++){
            total+=Integer.parseInt(detallesFertilizantes[i][5]);
        }
        
        this.montoXIngreso=total;
        
        
    }
    public void mostrarDatos(){
        System.out.println("<----Datos Generales---->");
        System.out.println("Empresa:"+this.empresa);
        System.out.println("Cuit:"+this.cuitEmpresa);
        System.out.println("Mes:"+this.mesDeclaracion);
        System.out.println("Año:"+this.anioDeclaracion);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       
        
        for(int i=0;i<detallesFertilizantes.length;i++){
            for(int j=0;j<detallesFertilizantes[0].length;j++){
                System.out.print(detallesFertilizantes[i][j]+"  |  ");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
        
    }
   public void completarConEspacios(){
       int mayor=0;
       boolean control=true;
       
       for(int i=0;i<detallesFertilizantes.length;i++){
           
           for(int j=0;j<detallesFertilizantes[0].length;j++){
                   if(detallesFertilizantes[i][j].length()>mayor){
               mayor=detallesFertilizantes[i][j].length();
           }
                   
       }
           
           
           
       }
        
       for(int i=0;i<detallesFertilizantes.length;i++){
                for(int j=0;j<detallesFertilizantes[0].length;j++){
               
           while(control){
               
               if(detallesFertilizantes[i][j].length()==mayor){
                   control=false;
               }else{
                   
                   detallesFertilizantes[i][j]+=" ";
                   
               }
           }
           control=true;
               
                }
           }
           
           
       }
       
       
       
   }
    

