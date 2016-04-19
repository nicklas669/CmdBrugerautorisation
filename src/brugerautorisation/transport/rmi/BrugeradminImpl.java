package brugerautorisation.transport.rmi;
import brugerautorisation.data.Bruger;
import brugerautorisation.data.Brugerdatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BrugeradminImpl extends UnicastRemoteObject implements Brugeradmin
{
	Brugerdatabase db;

	public BrugeradminImpl() throws java.rmi.RemoteException
	{
	}

	@Override
	public Bruger hentBruger(String brugernavn, String adgangskode) throws RemoteException {
		return db.hentBruger(brugernavn, adgangskode);
	}

	@Override
	public Bruger ÆndrAdgangskode(String brugernavn, String adgangskode, String nyAdgangskode) throws RemoteException {
		Bruger b = db.hentBruger(brugernavn, adgangskode);
		b.adgangskode = nyAdgangskode;
		db.gemTilFil();
		return b;
	}

	@Override
	public Object getEkstraFelt(String brugernavn, String adgangskode, String feltnavn) throws RemoteException {
		return db.hentBruger(brugernavn, adgangskode).ekstraFelter.get(feltnavn);
	}

	@Override
	public void setEkstraFelt(String brugernavn, String adgangskode, String feltnavn, Object værdi) throws RemoteException {
		db.hentBruger(brugernavn, adgangskode).ekstraFelter.put(feltnavn, værdi);
	}
}