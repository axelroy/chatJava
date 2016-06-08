
package ch.hearc.cours.projet.gui.connexion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ch.hearc.cours.projet.chatrmi.PcChat;

public class JPanelConnexion extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelConnexion()
		{
		// load preferences
		ChatPreferences.load();

		topFrame = (JFrameConnexion) SwingUtilities.getWindowAncestor(this);

		geometry();
		control();
		appearance();
		}

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

	private void geometry()
		{
		// JComponent : Instanciation
		ipField = new JTextField(ChatPreferences.getIp());
		portField = new JTextField(Integer.toString(ChatPreferences.getPort()));
		ipLabel = new JLabel("Adresse IP : ");
		portLabel = new JLabel("Port : ");
		buttonValidate = new JButton("Valider");
		// Layout : Specification
			{
			FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
			setLayout(layout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(ipLabel);
		add(ipField);
		add(portLabel);
		add(portField);
		add(buttonValidate);
		}

	private void control()
		{
		buttonValidate.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				ChatPreferences.setIp(ipField.getText());
				ChatPreferences.setPort(Integer.parseInt(portField.getText()));
				ChatPreferences.save();

				PcChat pcChat = PcChat.getInstance();
				Thread chatThread = new Thread(pcChat);
				chatThread.start();

				//JPanelConnexion.this.topFrame.dispose();
				}
			});
		}

	private void appearance()
		{
		ipField.setPreferredSize(new Dimension(150, 20));
		portField.setPreferredSize(new Dimension(150, 20));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTextField ipField;
	private JTextField portField;
	private JLabel ipLabel;
	private JLabel portLabel;
	private JButton buttonValidate;
	private JFrameConnexion topFrame;

	}