package org.main;
import org.main.CustomException.PagoIncorrectoException;
import org.main.CustomException.PagoInsuficienteException;
import org.main.Moneda.*;
import org.main.Producto.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        // Creamos una máquina expendedora con  4 unidades de cada producto
        Expendedor exp = new Expendedor(4);

        // Creamos una moneda de 1000 pesos
        Moneda mon = new Moneda1000();
        System.out.println( mon.toString() ); // Imprimimos la información de la moneda

        // Creamos un comprador, el cual va a intentar comprar un Snickers con la
        // moneda de 1000 pesos que le entregaremos
        Comprador com = null;
        try {
            com = new Comprador(mon, Catalogo.SNICKERS.getId(), exp);

            // Notemos que debería tener un vuelto de 200 pesos. Podemos consultarselo
            System.out.println( com.getVuelto() );

            // Podemos consultar tambien por el sabor del producto que compró
            System.out.println( com.queConsumiste() );
        }
        catch (PagoIncorrectoException pie) {
            System.out.println(pie.getMessage());
        }
        catch (PagoInsuficienteException pie) {
            System.out.println(pie.getMessage());

            // Si la moneda fuera insuficiente, la moneda sería devuelta por el expendedor como vuelto
            System.out.println( exp.getVuelto().toString() );
        }

    }
}