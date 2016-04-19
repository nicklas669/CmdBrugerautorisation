package brugerautorisation.transport.rmi;

import brugerautorisation.Diverse;
import brugerautorisation.data.Bruger;
import java.rmi.Naming;

public class Brugeradminklient {
	public static void main(String[] arg) throws Exception {
//		Brugeradmin ba =(Brugeradmin) Naming.lookup("rmi://localhost/brugeradmin");
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

    //ba.sendGlemtAdgangskodeEmail("jacno", "Dette er en test, husk at skifte kode");
		//ba.ændrAdgangskode("jacno", "kodenj4gvs", "xxx");
                try {
                    Bruger b = ba.hentBruger("s144858", "MinNyeKode1234");
                    System.out.println("Fik bruger = " + b);
                    System.out.println("Data: " + Diverse.toString(b));
                } catch (IllegalArgumentException e) {
                    System.out.println("FEJL: "+e.getMessage());
                }
		// ba.sendEmail("jacno", "xxx", "Hurra det virker!", "Jeg er så glad");

                /*
		Object ekstraFelt = ba.getEkstraFelt("s144858", "kodez2xa8f", "s123456_testfelt");
		System.out.println("Fik ekstraFelt = " + ekstraFelt);
		ba.setEkstraFelt("s144858", "kodez2xa8f", "s123456_testfelt", "Hej fra Muhammed"); // Skriv noget andet her
                */
                //ba.ændrAdgangskode("s144858", "kodez2xa8f", "MinNyeKode1234");
	}
}
