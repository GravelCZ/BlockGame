package cz.GravelCZLP.BlockGame.Client;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.esotericsoftware.kryonet.Client;

import cz.GravelCZLP.BlockGame.Common.Packets.PacketPlayerLogout;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketStartLogin;

public class GameWindow extends Canvas {

	private static final long serialVersionUID = 3526633589235617871L;
	
	public boolean isConnected = false;
	public boolean isAuthWindowOpened = false;
	public boolean isChatWindowOpened = false;
	
	
	public ClientMain main;
	
	public ChatWindow chatWindow;
	
	@SuppressWarnings("static-access")
	public GameWindow(int width, int height, String title, final ClientMain game) {
		JFrame frame = new JFrame(title);
		
		Dimension dim = new Dimension(width, height);
		
		main = game;
		
		frame.setPreferredSize(dim);
		frame.setMaximumSize(dim);
		frame.setMaximumSize(dim);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		JButton startGame = new JButton("Začít Hru !");
		startGame.setSize(360, 100);
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.startGameRender();
			}
		});
		frame.add(startGame);
		frame.add(game);
		frame.pack();
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
				if (!isAuthWindowOpened) {
					new AuthWindow(game);	
					isAuthWindowOpened = true;
				} else {
					JOptionPane.showMessageDialog(null, "Auth Okno již je Otevřeno", "Error: Již Otevřeno", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JMenuItem ochatw = new JMenuItem("Otevřít Chat okno");
		ochatw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isChatWindowOpened) {
					chatWindow = new ChatWindow();
					isChatWindowOpened = true;
				} else {
					JOptionPane.showMessageDialog(null, "Chat okno je již otevřeno", "Error: již otevřeno", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
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
	
	@SuppressWarnings("static-access")
	public void initGame(String player, Client c) {
		isConnected = true;
		main.c = c;
		PacketStartLogin login = new PacketStartLogin(player);
		c.sendTCP(login);
		
	}
}
