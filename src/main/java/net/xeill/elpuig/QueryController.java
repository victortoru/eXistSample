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
        }
    }
}

