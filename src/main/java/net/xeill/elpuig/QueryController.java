package net.xeill.elpuig;
import javax.xml.xquery.XQResultSequence;
import java.util.Scanner;
import net.sf.saxon.s9api.*;
import java.io.File;
import net.xqj.exist.ExistXQDataSource;

public class QueryController {
    Scanner sc = new Scanner(System.in);
    ExistController ec = new ExistController();
    public void ListarElemento(){
        System.out.println("Que archivo queremos listar?" +
                "\n1.Ciudad" +
                "\n2.Coches" +
                "\n3.Marca" +
                "\n4.Vendedor");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                XQResultSequence xqrs1 = ec.executeQuery("for $ciudad in /doc('/db/foaf/foaf/Ciudad.xml')/ciudades/ciudad return $ciudad");
                ec.printResultSequence(xqrs1);

                System.out.println("\nPrueba a listar un texto cualquiera");
                String texto = sc.next();
                XQResultSequence xqrs = ec.executeQuery("for $ciudad in /doc('/db/foaf/foaf/Ciudad.xml')/ciudades/ciudad return $ciudad"+texto);
                ec.printResultSequence(xqrs);
                break;

            case 2:
                XQResultSequence xqrsListCoche = ec.executeQuery("for $coche in /doc('/db/foaf/foaf/Coches.xml')/coches/coche return $coche");
                ec.printResultSequence(xqrsListCoche);

                System.out.println("\nPrueba a listar un texto cualquiera");
                String textoCoche = sc.next();
                XQResultSequence xqrsCoche = ec.executeQuery("for $coche in /doc('/db/foaf/foaf/Coches.xml')/coches/coche return $coche/"+textoCoche);
                ec.printResultSequence(xqrsCoche);
                break;

            case 3:
                XQResultSequence xqrsListMarca = ec.executeQuery("for $vehiculo in /doc('/db/foaf/foaf/Marca.xml')/vehiculos/vehiculo return $vehiculo");
                ec.printResultSequence(xqrsListMarca);

                System.out.println("\nPrueba a listar un texto cualquiera");
                String textoMarca = sc.next();

                XQResultSequence xqrsMarca = ec.executeQuery("for $vehiculo in /doc('/db/foaf/foaf/Marca.xml')/vehiculos/vehiculo return $vehiculo"+textoMarca);
                ec.printResultSequence(xqrsMarca);
                break;

            case 4:
                XQResultSequence xqrsListVendedor = ec.executeQuery("for $registro in /doc('/db/foaf/foaf/Vendedor.xml')/registros/registro return $registro");
                ec.printResultSequence(xqrsListVendedor);

                System.out.println("\nPrueba a listar un texto cualquiera");
                String textoVendedor = sc.next();

                XQResultSequence xqrsVendedor = ec.executeQuery("for $vehiculo in /doc('/db/foaf/foaf/Marca.xml')/vehiculos/vehiculo return $vehiculo"+textoVendedor);
                ec.printResultSequence(xqrsVendedor);
                break;
            }
        }

    public void ListarCondicion(){
        System.out.println("Prueba a listar alguno de estos ficheros" +
                "\n 1.Ciudad" +
                "\n2.Coches" +
                "\n3.Marca" +
                "\n4.Vendedor");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                XQResultSequence xqrs = ec.executeQuery("for $ciudad in /doc('/db/foaf/foaf/Ciudad.xml')/ciudades/ciudad return $ciudad");
                ec.printResultSequence(xqrs);

                System.out.println("Escribe el Rango de KM minimo para listar las ciudades acordes");
                int minimoKM = sc.nextInt();

                XQResultSequence xqrs1 = ec.executeQuery("for $ciudad in /doc('/db/foaf/foaf/Ciudad.xml')/ciudades/ciudad[./RangoKM > " + minimoKM + "] return $ciudad");
                ec.printResultSequence(xqrs1);
                break;

            case 2:
                XQResultSequence xqrsCoche = ec.executeQuery("for $coche in /doc('/db/foaf/foaf/Coches.xml')/coches/coche return $coche");
                ec.printResultSequence(xqrsCoche);

                System.out.println("Escribe el tipo de carroceria por la que quieres listar los vehiculos");
                String tipoCarroceria = sc.next();

                XQResultSequence xqrsCoche2 = ec.executeQuery("for $coche in /doc('/db/foaf/foaf/Coches.xml')/coches/coche[./Carroceria > " + tipoCarroceria + "] return $coche");
                ec.printResultSequence(xqrsCoche2);
                break;

            case 3:
                XQResultSequence xqrsMarca = ec.executeQuery("for $vehiculo in /doc('/db/foaf/foaf/Marca.xml')/vehiculos/vehiculo return $vehiculo");
                ec.printResultSequence(xqrsMarca);

                System.out.println("Escribe la cantidad de unidades de Vehiculos para ver que marcas tienen esa cantidad o más");
                int numUnidades = sc.nextInt();

                XQResultSequence xqrsMarca2 = ec.executeQuery("for $vehiculo in /doc('/db/foaf/foaf/Marca.xml')/vehiculos/vehiculo[./unidades < " + numUnidades + "] return $vehiculo");
                ec.printResultSequence(xqrsMarca2);
                break;

            case 4:
                XQResultSequence xqrsVendedor = ec.executeQuery("for $registro in /doc('/db/foaf/foaf/Vendedor.xml')/registros/registro return $registro");
                ec.printResultSequence(xqrsVendedor);

                System.out.println("Escribe si o no para ver cuantos vendedores profesionales o particulares podemos depender");
                boolean catVendedor = sc.nextBoolean();

                XQResultSequence xqrsVendedor2 = ec.executeQuery("for $registro in /doc('/db/foaf/foaf/Vendedor.xml')/registros/registro where $registro/Profesional = '" + catVendedor + "' or $registro/Particular = '" + catVendedor + "' return $registro");
                ec.printResultSequence(xqrsVendedor2);
                break;
        }
    }



}