
package ch.hearc.cours.projet.chatrmi.states;

import ch.hearc.cours.projet.chatrmi.ChatManager;
import ch.hearc.cours.projet.chatrmi.gui.connexionframe.JFrameConnexion;


public class ConnectionState implements Statement_I
	{
	public ConnectionState()
		{
		frameConnexion = new JFrameConnexion();
		}


	@Override
	public void leave()
		{
		frameConnexion.dispose();
		}

	@Override
	public void next(ChatManager chatManager)
		{
		chatManager.SetState(new ConnectingState());
		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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


	private JFrameConnexion frameConnexion;
	}
