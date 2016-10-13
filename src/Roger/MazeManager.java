package Roger;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class MazeManager {
	
	static int MAZESIZE = 12;
	static int Map[];
	static int column = MAZESIZE;
	static int count = 0;
	static PathButton []buttonMap;
	static JFrame F = new JFrame("968212 JIE ZHOU  MAZE");
	static JPanel P = new JPanel();
	
	public static void main(String arg[]){
		
		
		F.setBounds(500, 25, 1000, 1000);
		F.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		F.setContentPane(P);
		P.setLayout(new GridLayout(MAZESIZE,MAZESIZE));
		
		JMenuBar MenuBar = new JMenuBar();
		JMenu Menu = new JMenu("Select Option");
		JMenuItem Run = new JMenuItem("Run");
		JMenuItem Reset = new JMenuItem("Reset");
		Menu.add(Run);
		Run.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0;i < (MAZESIZE*MAZESIZE); i++)
				{		
					buttonMap[i].setGame(true);
				}	
				SolveMaze S = new SolveMaze(buttonMap);
			}
			
		});
		Menu.add(Reset);
		Reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setGame();
			}
		});
		MenuBar.add(Menu);
		F.setJMenuBar(MenuBar);
		
		setGame();
		
		F.setVisible(true);
//		for(int k = 0;k < (MAZESIZE*MAZESIZE); k++)
//		{
//			System.out.print(Map[k]+" ");
//		}
	}
	
	public static void setGame()
	{
        P.removeAll();
		Map = new int [MAZESIZE*MAZESIZE];
		count = 0;
		try{
			Scanner S = new Scanner(new File("src/Data.txt"));
			while(S.hasNextLine())
			{				
				String Line = S.nextLine();
				Scanner Data = new Scanner(Line);
				while(Data.hasNextInt())
				{
					Map[count] = Data.nextInt();
					count++;
				}
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		buttonMap = new PathButton[MAZESIZE*MAZESIZE];
		
		for(int i = 0;i < (MAZESIZE*MAZESIZE); i++)
		{		
			buttonMap[i] = new PathButton(Map[i]);
			F.getContentPane().add(buttonMap[i]);
			P.updateUI();
		}
	}

}
