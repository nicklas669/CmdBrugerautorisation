
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;

import java.net.URL;
import java.rmi.Naming;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class CmdBrugerautorisation {

	public static void main(String[] args) throws Exception {
		// Tjek om der er givet 2 argumenter
		if (args.length < 2) {
			System.out.println(
					"Not enough arguments given! You should give two arguments - the username "
					+ "and the password to try and log in with.");
			System.exit(1);
		}

		String username = args[0];
		String password = args[1];

		// RMI
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

		// SOAP
//		URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
//		QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
//		Service service = Service.create(url, qname);
//		brugerautorisation.transport.soap.Brugeradmin ba = service.getPort(brugerautorisation.transport.soap.Brugeradmin.class);

		// Forsøg at hente en bruger i autorisationsmodulet (derved tjekkes om brugernavn og password matcher)
		try {
			Bruger b = ba.hentBruger(username, password);
			System.out.println("SUCCESS: Login var korrekt!");
		} catch (Exception e) {
			System.out.println("FEJL: " + e.getMessage());
		}
		System.exit(0);
	}
}
