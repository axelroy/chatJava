
package ch.hearc.cours.io.file.data.bin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import ch.hearc.cours.io.file.data.Tools;

public class UseFileBin
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		try
			{
			main();
			}
		catch (IOException e)
			{
			System.err.println("erreur sur le fichier");
			e.printStackTrace();
			}
		}

	public static void main() throws IOException
		{
		int n = 10;
		String fileName = "file.bin";
		float[] tabSource = Tools.create(n);
		write(tabSource, fileName);
		float[] tabCopy = read(fileName);
		Tools.print(tabSource);
		Tools.print(tabCopy);
		Tools.delete(fileName);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static float[] read(String fileName) throws IOException
		{
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);

		List<Float> list = new LinkedList<Float>();
		try
			{
			while(true)
				{
				float valeur = dis.readFloat();
				list.add(valeur);
				}
			}
		catch (EOFException e)
			{
			//Fin du fichier
			}
		float[] tab = Tools.toArray(list);
		dis.close();
		bis.close();
		fis.close();

		return tab;
		}

	private static void write(float[] tabSource, String fileName) throws IOException
		{
		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);

		for(float element:tabSource)
			{
			dos.writeFloat(element);
			}

		dos.close();
		bos.close();
		fos.close();
		}
	}