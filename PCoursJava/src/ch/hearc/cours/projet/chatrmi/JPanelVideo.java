
package ch.hearc.cours.projet.chatrmi;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import ch.hearc.cours.projet.tools.Tools;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class JPanelVideo extends JPanel implements PanelVideo_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVideo() throws RemoteException
		{
		webCam = Webcam.getDefault();

		Dimension[] nonStandardResolutions = new Dimension[] { WebcamResolution.PAL.getSize(), WebcamResolution.HD720.getSize(), new Dimension(1920, 1080), new Dimension(1280, 720), };

		webCam.setCustomViewSizes(nonStandardResolutions);
		webCam.setViewSize(WebcamResolution.HD720.getSize());

		dimensionImageYou = new Dimension(1280, 720);
		dimensionImageMe = Tools.getScaledDimension(WebcamResolution.HD720.getSize(), AREA_ME);

		webCam.open();

		imageMe = webCam.getImage();
		imageYou = null;

		PcChat pcChat = PcChat.getInstance();
		RemotePanelVideo = pcChat.getRemotePanelVideo();

		geometry();
		control();
		appearance();

		rmiUrl = new RmiURL(Id.idRmi2, RmiTools.getLocalHost(), ChatPreferences.getPort());
		RmiTools.shareObject(this, rmiUrl);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void putImage(ImageIcon imageIcon) throws RemoteException
		{
		imageYou = imageIcon.getImage();
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transformInitial = g2d.getTransform();
		draw(g2d);
		g2d.setTransform(transformInitial);
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

	private void draw(Graphics2D g2d)
		{
		if (imageYou == null)
			{
			g2d.drawImage(imageYou, (this.getWidth() - dimensionImageYou.width) / 2, (this.getHeight() - dimensionImageYou.height) / 2, dimensionImageYou.width, dimensionImageYou.height, null);
			}
		g2d.drawImage(imageMe, 0, 0, dimensionImageMe.width, dimensionImageMe.height, null);
		}

	private void geometry()
		{

		// JComponent : Instanciation

		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add

		}

	private void control()
		{
		Thread thread = new Thread(new Runnable()
			{


			@Override
			public void run()
				{
				while(!Thread.currentThread().isInterrupted())
					{
					try
						{
						Thread.sleep(20);
						}
					catch (InterruptedException e)
						{
						// TODO Auto-generated catch block
						e.printStackTrace();
						}

					imageMe = webCam.getImage();

					try
						{
						RemotePanelVideo.putImage(new ImageIcon(imageMe));
						}
					catch (RemoteException e)
						{
						// TODO Auto-generated catch block
						e.printStackTrace();
						}

					JPanelVideo.this.repaint();

					}

				}
			});

		thread.start();

		addComponentListener(new ComponentAdapter()
			{


			@Override
			public void componentResized(ComponentEvent e)
				{
				dimensionImageYou = Tools.getScaledDimension(WebcamResolution.HD720.getSize(), JPanelVideo.this.getSize());
				}
			});
		}

	private void appearance()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Webcam webCam;
	private Dimension dimensionImageMe;
	private Dimension dimensionImageYou;

	// Input
	private Image imageYou;
	private Image imageMe;

	// Output
	private PanelVideo_I RemotePanelVideo;

	public static final Dimension AREA_ME = new Dimension(300, 300);
	public final RmiURL rmiUrl;

	}
