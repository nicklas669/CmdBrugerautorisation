package brugerautorisation;
import java.io.*;
public class Serialisering
{
	public static void gem(Serializable obj, String filnavn) throws IOException
	{
		System.out.println("Gemmer filen "+filnavn);
		FileOutputStream datastrÝm = new FileOutputStream(filnavn);
		ObjectOutputStream objektstrÝm = new ObjectOutputStream(datastrÝm);
		objektstrÝm.writeObject(obj);
		objektstrÝm.close();
	}

	public static Serializable hent(String filnavn) throws Exception
	{
		System.out.println("Indl√¶ser filen "+filnavn);
		FileInputStream datastrÝm = new FileInputStream(filnavn);
		ObjectInputStream objektstrÝm = new ObjectInputStream(datastrÝm);
		Serializable obj = (Serializable) objektstrÝm.readObject();
		objektstrÝm.close();
		return obj;
	}
}