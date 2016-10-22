package cz.GravelCZLP.BlockGame.Client;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.esotericsoftware.kryonet.Client;

import cz.GravelCZLP.BlockGame.Client.Input.KeyInput;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketPlayerLogout;

public class GameWindow extends Canvas {

	private static final long serialVersionUID = 3526633589235617871L;
	
	public GameWindow(int width, int height, String title, final ClientMain game) {
		JFrame frame = new JFrame(title);
		
		Dimension dim = new Dimension(width, height);
		
		frame.setPreferredSize(dim);
		frame.setMaximumSize(dim);
		frame.setMaximumSize(dim);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new KeyInput(game));
		frame.add(game);
		frame.pack();
		game.start();
		new AuthWindow(game);
		JMenuBar menubar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenu chat = new JMenu("Chat");
		JMenu about = new JMenu("About");
		
		JMenuItem ocw = new JMenuItem("Otevřít okno pro připojení");
		ocw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.c != null) {
					game.c.sendTCP(new PacketPlayerLogout(game.thePlayer.uuid));
					game.c.close();
				}
				new AuthWindow(game);
			}
		});
		JMenuItem ochatw = new JMenuItem("Otevřít Chat okno");
		JMenuItem authors = new JMenuItem("Autoři");
		JMenuItem close = new JMenuItem("Zavřít");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.c != null) {
					game.c.sendTCP(new PacketPlayerLogout(game.thePlayer.uuid));
					game.c.close();
				}
				System.exit(0);
			}
		});
		
		gameMenu.add(ocw);
		gameMenu.add(close);
		chat.add(ochatw);
		about.add(authors);
		menubar.add(gameMenu);
		menubar.add(chat);
		menubar.add(about);
		frame.setJMenuBar(menubar);
		frame.setVisible(true);
	}
	
	public void initGame(String player, Client c) {
		
	}
}
