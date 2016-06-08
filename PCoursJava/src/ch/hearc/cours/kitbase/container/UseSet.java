
package ch.hearc.cours.kitbase.container;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UseSet
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
		int n = 20;
		//Set<Integer> setValeurs = new HashSet<Integer>(n);
		Set<Integer> setValeurs = new TreeSet<Integer>();
		peupler(setValeurs, n);
		peupler(setValeurs, n);
		print(setValeurs);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void print(Set<Integer> setValeurs)
		{

		// V1
			{
			for(Integer elementI:setValeurs)
				{
				System.out.println(elementI);
				}
			}

		System.out.println();

		//V2
			{
			Iterator<Integer> it = setValeurs.iterator();
			while(it.hasNext())
				{
				System.out.println(it.next());
				}
			}

		System.out.println();

		//V3
			{
			System.out.println(setValeurs.toString());
			}

		System.out.println();

		//V4
			{
			System.out.println(setValeurs);
			}
		}

	private static void peupler(Set<Integer> setValeurs, int n)
		{
		for(int i = 0; i < n; i++)
			{
			setValeurs.add(i);
			}
		}
	}