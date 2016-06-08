
package ch.hearc.cours.rmi.pcsecret;

import java.rmi.RemoteException;

import ch.hearc.cours.rmi.pchorloge.Horloge;
import ch.hearc.cours.rmi.pchorloge.Horloge_I;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcSecret implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PcSecret()
		{
		// Rien
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		serverSide();
		clientSide();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void serverSide()
		{
		try
			{
			new Secret();
			}
		catch (RemoteException e)
			{
			System.err.println("[PcSecret]: serverSide: instanciation secret.");
			e.printStackTrace();
			}
		}

	private void clientSide()
		{
		try
			{
			Horloge_I horloge = connect();
			work(horloge);
			}
		catch (RemoteException e)
			{
			System.err.println("[PcSecret]: clientSide(): erreur de connexion.");
			//			e.printStackTrace();
			}
		}

	private void work(Horloge_I horloge) throws RemoteException
		{
		System.out.println(horloge.getTime());
		}

	private Horloge_I connect() throws RemoteException
		{
		RmiURL rmiUrl = new RmiURL(Horloge.RMI_ID, RmiTools.getLocalHost(), Horloge.RMI_PORT);
		int delayMs = 500;
		int nbTentatives = 100;
		Horloge_I horloge = (Horloge_I)RmiTools.connectionRemoteObjectBloquant(rmiUrl, delayMs, nbTentatives);
		return horloge;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}