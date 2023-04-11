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
                    queryController.();
                    break;

                case 2:
                    break;

                default:
            }
                System.out.println("Introdueixi una de les opcions anteriors");
                break;

            }
            option = menu.mainMenu();
        }

    }

