
package ch.hearc.cours.moo.heritage.animal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Zoo implements Iterable<Animals>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Zoo(String nom)
		{
		this.nom = nom;
		this.list = new LinkedList<Animals>();
		}

	public Zoo(Zoo source)
		{
		this(source.nom); // copie superficielle autoris�e car string inalt�rable

		for(Animals animals:source)
			{
			//this.list.add(new Animals(animals)); !! INTERDIT ANIMAL ABSTRAIT NON INSTANCIABLE
			this.list.add(animals.cloneOf());
			// la ligne au dessus fonctionne parceque derri�re animal se cache
			// un objet qui as �t� instanci�, donc un objet non abstrait
			// dont les m�thodes abstraites ont �t� impl�ment�es (dont cloneOf)

			// type local de animals : Animals
			// type effectif de animals : Ne sera connu que lors de l'exec.
			// et sera forc�ment une classe concr�te (feuille de la hierarchie)
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public boolean add(Animals a)
		{
		return list.add(a);
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Zoo [nom=");
		builder.append(this.nom);
		builder.append(", list=");
		builder.append(this.list);
		builder.append("]");
		return builder.toString();
		}

	public String mange()
		{
		StringBuilder builder = new StringBuilder();
		for(Animals animals:this)
			{
			builder.append(animals.mange() + "\n");
			}
		return builder.toString();
		}

	@Override
	public Iterator<Animals> iterator()
		{
		return list.iterator();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private String nom;

	// tools
	private List<Animals> list;

	}