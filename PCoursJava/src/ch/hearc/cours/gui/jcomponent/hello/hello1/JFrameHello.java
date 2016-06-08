
package ch.hearc.cours.gui.jcomponent.hello.hello1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameHello extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameHello()
		{
		geometrie();
		controle();
		apparence();
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

	private void geometrie()
		{
		bouton1 = new JButton("Coucou1");
		bouton2 = new JButton("Coucou2");
		bouton3 = new JButton("Coucou3");

		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		// v1
		//this.getContentPane().setLayout(layout);
		// v2
		this.setLayout(layout);

		//v1
		//			{
		//			this.getContentPane().add(bouton1);
		//			this.getContentPane().add(bouton2);
		//			this.getContentPane().add(bouton3);
		//			}
		// v2
			{
			this.add(bouton1);
			this.add(bouton2);
			this.add(bouton3);
			}

		}

	private void controle()
		{
		bouton1.setToolTipText("salut 1");
		bouton2.setToolTipText("salut 2");
		bouton3.setToolTipText("salut 3");

		bouton1.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println("clic bouton 1");
				}
			});

		ActionListener actionListener = new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JButton source = (JButton)e.getSource();
				if (source == bouton2)
					{
					System.out.println("clic bouton 2");
					}
				else if (source == bouton3)
					{
					System.out.println("clic bouton 3");
					}
				}
			};

		bouton2.addActionListener(actionListener);
		bouton3.addActionListener(actionListener);

		}

	private void apparence()
		{
		//bouton
			{
			bouton1.setBackground(Color.CYAN);
			bouton1.setForeground(new Color(255, 255, 255));
			//bouton1.setOpaque(false);
			}
		//JFrame
			{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.setResizable(false);
			//this.setUndecorated(true);
			this.getContentPane().setBackground(Color.blue);
			this.setTitle("Hello");
			this.setLocation(0, 0);
			this.setSize(300, 200);
			this.setVisible(true); // derni�re chose du constructeur
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;

	}