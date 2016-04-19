package brugerautorisation.transport.soap;

import brugerautorisation.data.Bruger;
import brugerautorisation.data.Brugerdatabase;
import javax.jws.WebService;

@WebService(endpointInterface = "brugerautorisation.transport.soap.Brugeradmin")
public class BrugeradminImpl implements Brugeradmin {
	Brugerdatabase db;

	@Override
	public Bruger hentBruger(String brugernavn, String adgangskode) {
		return db.hentBruger(brugernavn, adgangskode);
	}

	@Override
	public Bruger �ndrAdgangskode(String brugernavn, String adgangskode, String nyAdgangskode) {
		Bruger b = db.hentBruger(brugernavn, adgangskode);
		b.adgangskode = nyAdgangskode;
		db.gemTilFil();
		return b;
	}

	@Override
	public Object getEkstraFelt(String brugernavn, String adgangskode, String feltnavn) {
		return db.hentBruger(brugernavn, adgangskode).ekstraFelter.get(feltnavn);
	}

	@Override
	public void setEkstraFelt(String brugernavn, String adgangskode, String feltnavn, Object v�rdi) {
		db.hentBruger(brugernavn, adgangskode).ekstraFelter.put(feltnavn, v�rdi);
	}
}
