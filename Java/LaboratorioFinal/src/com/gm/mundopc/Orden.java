/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.mundopc;

/**
 *
 * @author esdra
 */
public class Orden {
    private int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private final int maxComputadoras = 10;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        computadoras = new Computadora[maxComputadoras];
    }
    
    public void agregarComputadora(Computadora computadora){
        if(contadorComputadoras < maxComputadoras){
            computadoras[contadorComputadoras++] = computadora;
        }else{
            System.out.println("Arreglo lleno");
        }       
    }
    
    public void mostrarOrden(){
        System.out.println("Id Orden: " + this.idOrden);
        for (int i = 0; i < contadorComputadoras; i++) {
            System.out.println(computadoras[i].toString());
        }
    }
    
}
