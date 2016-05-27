package net.danielmelcer.cheekers.game;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

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
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Local Game", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Local Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, "2, 2, fill, fill");
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gc = new GameController(Board.getDefaultBoard(), new HumanPlayer(), new HumanPlayer(), new GUIBoard(Board.getDefaultBoard()));
				Thread t = new Thread(gc::startGame);
				t.start();
				buttonStartGame();
			}
		});
		panel.add(btnStartGame);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Network Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1, "2, 4, fill, fill");
		
		btnHostGame = new JButton("Host Game");
		btnHostGame.setEnabled(false);
		panel_1.add(btnHostGame);
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.setEnabled(false);
		panel_1.add(btnJoinGame);
		
		btnStopCurrentGame = new JButton("Stop Current Game");
		btnStopCurrentGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameThread.interrupt();
				gc.getGui().dispose();
			}
		});
		btnStopCurrentGame.setEnabled(false);
		contentPane.add(btnStopCurrentGame, "2, 6");
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
