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
public class CargaDDJJIngresoFertilizante {
              /*Cree la clase java CargaDDJJIngresoFertilizante que contenga la definición de una variable
“fertilizantesPermitidos” que se corresponde al siguiente array de 2 dimensiones, 10 filas por
3 columnas, definida como variable global en la clase con los siguientes fertilizantes cargados:*/
    
     
         static  String[][] fertilizantesPermitidos={
        {"101",  "UREA"              ,"BS"},
        {"102",  "SULFATO AMONICO"   ,"BS"},
        {"103",  "NITRATO AMONICO"   ,"BS"},
        {"104",  "NITRATO DE CALCIO" ,"BS"},
        {"105","SUPERFOSFATO SIMPLE" ,"BD"},
        {"106","SUPERFOSFATO TRIPLE" ,"BD"},
        {"107","NITRATO AMONICO"     ,"BS"},
        {"108","CLORURO DE POTASIO"  ,"BD"},
        {"109","SULFATO DE POTASIO"  ,"BS"},
        {"110","NITROGENO LIQUIDO"   ,"BD"}
           
    };
    
 
    /*Codifique en la clase CargaDDJJIngresoFertilizante un método main inicial que contenga el
código necesario para ejecutar las siguientes acciones:*/
    public static void main(String[] args){
 

        Scanner leer1=new Scanner(System.in);
        Scanner leer2=new Scanner(System.in);
        
        //Crear una instancia (new) de la clase DDJJIngresoFertilizante;
        DDJJIngresoFertilizante primerIngresoF=new DDJJIngresoFertilizante();
        
        //Solicite al usuario los datos
        
        primerIngresoF.registrarDatos();
        
        //Solicitar al usuario la cantidad de fertilizantes
        
        primerIngresoF.cantFertilizantes();
        String codigo="";
        int cantFertilizantes=primerIngresoF.getCantFertilizantes();
        boolean control=true;
        int kilos=0;
        int cantEnvase;
        int subtotal = 0;
        String nombre;
        String Tipo;
        
        
        /*Para completa cada columna del array solicitar el código del fertilizante a informar, el
usuario ingresa un valor, buscar el código en el array de fertilizantesPermitidos, si no se
encuentra el código indicar la situación con el mensaje “El código del fertilizante
ingresado no existe, intente nuevamente” y volver a pedir el código, si el código se
encuentra solicitar según corresponda el tamaño de la Bolsa (los valores validos son 5,
10, 25, 50) o la cantidad de Bidones (valor mayor a 0) y la cantidad a ingresar, aplicar la
información obtenida para cargar el array de detallesFertilizantes de la instancia, el
subtotal es el resultante de multiplicar el monto del fertilizante correspondiente por la
cantidad de envases. Validar que la capacidad y cantidad sean mayores a cero. Repetir
este proceso hasta completar las N filas que componen el array de detallesFertilizantes.*/
         
        for(int i=1;i<=cantFertilizantes;i++){
            
            while(control){
                
                System.out.println("Ingrese el codigo del fertilizante numero   "+i);
                codigo=leer2.nextLine();
                    if(encontrarCodigo(fertilizantesPermitidos,codigo)){
                        if(fertilizantesPermitidos[buscarFilaFertilizante(fertilizantesPermitidos,codigo)][2].equalsIgnoreCase("Bd")){
                            do{
                                System.out.println("Ingrese la capacidad de el bidon");
                                kilos=leer1.nextInt();
                                if(kilos>0){
                                    System.out.println("Capacidad cargada");
                                }else{
                                    System.out.println("La capacidad es invalida");
                                }
                            }while(kilos<=0);
                            subtotal=12;
                           
                            control=false;
                        }else{
                            do{
                                System.out.println("Ingrese la capacidad de la bolsa");
                                kilos=leer1.nextInt();
                                if(kilos!=5&kilos!=10&kilos!=25&kilos!=50){
                                    System.out.println("La capacidad es invalida ");
                                }else{
                                    System.out.println("capacidad cargada");
                                }
                                
                                
                                
                            }while(kilos!=5&kilos!=10&kilos!=25&kilos!=50);
                            
                            switch(kilos){
                                case 5:
                                    
                                    subtotal=5;
                                    break;
                                    
                                case 10:
                                    
                                    subtotal=8;
                                    break;
                                    
                                case 25:
                                    subtotal=20;
                                    break;
                                    
                                case 50:
                                    subtotal=36;
                                    break;
                                    
                            }
                            
                            control=false;
                            
                        }
                         do{
                                System.out.println("Ingrese la cantidad del envase");
                                cantEnvase=leer1.nextInt();
                                if(cantEnvase>0){
                                    System.out.println("Fertilizante Guardado!\n");
                                    System.out.println("");
                                }else{
                                    System.out.println("La cantidad no puede ser menor a 0");
                                }
                            }while(cantEnvase<=0);
                         //Calcular Subtotal según  el precio del envase y la cantidad del mismo;
                         subtotal*=cantEnvase;
                         System.out.println("----------------------------------------------------------------");
                         System.out.println("Datos sobre el fertilizante más reciente registrado");
                         System.out.println("Tipo de envase:"+fertilizantesPermitidos[buscarFilaFertilizante(fertilizantesPermitidos,codigo)][2]);
                         System.out.println("Cantidad de envases :"+cantEnvase);
                         System.out.println("Este es el subtotal de este fertilizante "+subtotal);
                         System.out.println("-----------------------------------------------------------------");
                         nombre=fertilizantesPermitidos[buscarFilaFertilizante(fertilizantesPermitidos,codigo)][1];
                         Tipo=fertilizantesPermitidos[buscarFilaFertilizante(fertilizantesPermitidos,codigo)][2];
                         
                         primerIngresoF.ubicarInformacion(codigo,nombre,Tipo,String.valueOf(kilos),String.valueOf(cantEnvase),String.valueOf(subtotal));
                        
                        
                    }else{
                        System.out.println("El codigo ingresado no coincide con ningun fertilizante");
                    }
           
                
                }
                control=true;
                
                }
               
              
              primerIngresoF.calcularTotalAbonoIngreso();
              
              
              
              //Llenar de espacios aquellos elementos  menores a la longitud mas grande que se encuentra dentro de nuestra matriz(para dar una vista clara del contenido);
              
              
              primerIngresoF.completarConEspacios();
              
              /* Finalmente, en la clase CargaDDJJIngresoFertilizante, imprima por pantalla la totalidad de
los datos de la Declaración Jurada*/
              
              primerIngresoF.mostrarDatos();
              
              //Sentencia final : Total en pesos del cargamento de fertilizantes;
              
              System.out.println("El total es: $"+primerIngresoF.getMontoXIngreso());
              
            
            }
            //Metodo encargado de buscar el codigo dado por teclado en mi tabla o matriz de fertilizantes;
            public static boolean encontrarCodigo(String[][] matriz,String codigo){
                boolean validador=false;
                for(int i=0;i<matriz.length;i++){
                    if(codigo.equalsIgnoreCase(matriz[i][0])){
                        validador=true;
                    }
                    
                    
                }
           
               return validador;
            }
            public static int buscarFilaFertilizante(String[][] matriz,String codigo){
                
                int fila = 0;
                    for(int i=0;i<matriz.length;i++){
                    if(codigo.equalsIgnoreCase(matriz[i][0])){
                        fila=i;
                        break;
                    }
                    
                }
                
                return fila;
            }
            
            }

            
        

