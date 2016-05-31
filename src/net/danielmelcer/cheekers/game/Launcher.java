package net.danielmelcer.cheekers.game;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import net.danielmelcer.cheekers.board.Board;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Launcher extends JFrame {

	private JPanel contentPane;
	private JButton btnStartGame;
	private JButton btnHostGame;
	private JButton btnJoinGame;
	private JButton btnStopCurrentGame;
	
	private GameController gc;
	private Thread gameThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher frame = new Launcher();
					frame.setMinimumSize(new Dimension(300,300));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Launcher() {
		setTitle("Cheekers Launcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{418, 0};
		gbl_contentPane.rowHeights = new int[]{108, 103, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnStopCurrentGame = new JButton("Stop Current Game");
		btnStopCurrentGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameThread.interrupt();
				gc.getGui().dispose();
				buttonEndGame();
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Local Game", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Local Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 0.5;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gc = new GameController(Board.getDefaultBoard(), new HumanPlayer(), new HumanPlayer(), new GUIBoard(Board.getDefaultBoard()));
				gameThread = new Thread(()->{
					gc.startGame();
					buttonEndGame();
				});
				gameThread.start();
				buttonStartGame();
			}
		});
		panel.add(btnStartGame);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Network Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 0.5;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		
		btnHostGame = new JButton("Host Game");
		btnHostGame.setEnabled(false);
		panel_1.add(btnHostGame);
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.setEnabled(false);
		panel_1.add(btnJoinGame);
		btnStopCurrentGame.setEnabled(false);
		GridBagConstraints gbc_btnStopCurrentGame = new GridBagConstraints();
		gbc_btnStopCurrentGame.anchor = GridBagConstraints.NORTH;
		gbc_btnStopCurrentGame.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStopCurrentGame.gridx = 0;
		gbc_btnStopCurrentGame.gridy = 2;
		contentPane.add(btnStopCurrentGame, gbc_btnStopCurrentGame);
	}
	
	private void buttonStartGame(){
		btnStartGame.setEnabled(false);
		btnStopCurrentGame.setEnabled(true);
	}
	
	private void buttonEndGame(){
		btnStartGame.setEnabled(true);
		btnStopCurrentGame.setEnabled(false);
	}
	
	
}
