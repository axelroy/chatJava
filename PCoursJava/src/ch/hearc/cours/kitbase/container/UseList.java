
package ch.hearc.cours.kitbase.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseList
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
		int n = 10;
		List<Integer> listValeurs = new ArrayList<Integer>(n); // Optimiser la taille en mettant N (possible de faire plus grand)
		//List<Integer> listValeurs = new LinkedList<Integer>();
		peupler(listValeurs, n);
		print(listValeurs);

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void print(List<Integer> listValeurs)
		{
		//V1 : Mus�e des horreurs!! : complexit� quadratique
			{
			int n = listValeurs.size();
			for(int i = 0; i < n; i++)
				{
				System.out.println(listValeurs.get(i));
				}
			}

		System.out.println();

		//V2
			{
			for(Integer elementI:listValeurs)
				{
				System.out.println(elementI);
				}
			}

		System.out.println();

		//V3
			{
			Iterator<Integer> it = listValeurs.iterator();
			while(it.hasNext())
				{
				Integer elementI = it.next();
				System.out.println(elementI);
				}
			}

		System.out.println();

		//V4
			{
			System.out.println(listValeurs.toString());
			}

		System.out.println();

		//V5
			{
			System.out.println(listValeurs);
			}
		}

	private static void peupler(List<Integer> listValeurs, int n)
		{
		for(int i = 0; i < n; i++)
			{
			listValeurs.add(i); // Syntaxe raccourcie
			//listValeurs.add(new Integer(i));
			}
		}
	}