package cz.GravelCZLP.BlockGame.Client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatWindow {

	private JTextArea chat;
	
	public ChatWindow() {
		JFrame textChat = new JFrame("Chat Window");
		
		JScrollPane pane = new JScrollPane();
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTextArea chatArea = new JTextArea(10,1);
		pane.getViewport().setView(chatArea);	
		
		chat = chatArea;
		
		textChat.add(pane, BorderLayout.CENTER);
		textChat.pack();
	}
	
	public void addMessage(String name, String msg) {
		String toAppend = "[" + name + "]" + ": " + msg;
		chat.append(toAppend + "\n");
	}
}
