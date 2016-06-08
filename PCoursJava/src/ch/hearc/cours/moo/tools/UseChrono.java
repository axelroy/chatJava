
package ch.hearc.cours.moo.tools;

public class UseChrono
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		try
			{
			Chrono chronometre = new Chrono();
			Thread.sleep(2500); // unit� temporelle : ms
			chronometre.stop();
			System.out.println("Temps ecoule = " + chronometre.toString() + "ms");
			}
		catch (InterruptedException ex)
			{
			ex.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}