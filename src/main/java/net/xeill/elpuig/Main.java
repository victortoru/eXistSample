package net.xeill.elpuig;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;

public class Main {

    public static void main(String[] args) throws XQException {
        Menu menu = new Menu();
        QueryController queryController = new QueryController();

        int option = menu.mainMenu();
        while (option > 0 && option < 4) {
            switch (option) {
                    case 1:
                        queryController.ListarElemento();
                        break;

                    case 2:
                        queryController.ListarCondicion();
                        break;

                    case 3:
                        break;

                    case 7:
                        break;
            }
                System.out.println("Introduce alguna opción anterior");
                break;

            }
            option = menu.mainMenu();
        }

    }

