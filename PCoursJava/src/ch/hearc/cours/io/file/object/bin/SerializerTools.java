
package ch.hearc.cours.io.file.object.bin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializerTools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/


	public static byte[] serializer(Serializable serializable) throws IOException
		{
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(baos);
		ObjectOutputStream oos= new ObjectOutputStream(bos);

		oos.writeObject(serializable);

		oos.close();
		bos.close();
		baos.close();

		// flux ferm� mais donn�es toujours existante
		return baos.toByteArray();
		}

	public static Serializable deSerializer(byte[] tabBytes) throws IOException, ClassNotFoundException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tabBytes);
		BufferedInputStream bis = new BufferedInputStream(bais);
		ObjectInputStream ois= new ObjectInputStream(bis);

		Serializable object=(Serializable)ois.readObject();

		ois.close();
		bis.close();
		bais.close();

		return object;
		}

	public static Serializable clone(Serializable serializable) throws ClassNotFoundException, IOException
		{
		return deSerializer(serializer(serializable));
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
	}