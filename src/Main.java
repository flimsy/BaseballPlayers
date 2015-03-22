import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JFrame;

public class Main {

	public static String inFileName = "player.txt";
	private static BaseballPlayer players[] = new BaseballPlayer[4];

	// Gui stuff
	static JFrame myFrame;
	static Container cPane;
	static TextArea unsorted, sorted;

	public static void main(String[] args) {
		try {
			readFile(new File(inFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		initialize();

	}

	public static void initialize() {
		unsorted = new TextArea();
		sorted = new TextArea();
		myFrame = new JFrame();
		myFrame.setSize(400, 400);
		myFrame.setLocation(200, 200);
		myFrame.setTitle("Player");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cPane = myFrame.getContentPane();
		cPane.add(unsorted, BorderLayout.EAST);
		cPane.add(sorted, BorderLayout.WEST);
		// prints out array in order that it was collected
		for (BaseballPlayer player : players) {
			System.out.println(player.toString());
			unsorted.append(player.toString() + "\n");
		}

		// sorts array and then prints it out
		BaseballPlayer sortedPlayers[] = players;
		System.out.println();
		Arrays.sort(sortedPlayers);
		for (BaseballPlayer player : sortedPlayers) {
			System.out.println(player.toString());
			sorted.append(player.toString() + "\n");
		}
		myFrame.pack();
		myFrame.setVisible(true);

	}

	private static void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] variables = line.split(",");
			players[i++] = new BaseballPlayer(Integer.parseInt(variables[0]),
					variables[1], variables[2], Float.parseFloat(variables[3]));
		}
		br.close();
	}

}
