package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class test2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		int playerNum = scanner.nextInt();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer strtoken = new StreamTokenizer(reader);
		strtoken.nextToken();
		int playerNum = (int) strtoken.nval;
		reader.readLine();
		ArrayList<Player> players = new ArrayList<Player>();
		int sum = 0;
		for (int i = 0; i < playerNum; i++) {
			String strTemp = reader.readLine();
			String[] strArr = strTemp.split(" ");
//			players.add(new Player(scanner.next(), scanner.nextInt()));
			players.add(new Player(strArr[0], Integer.parseInt(strArr[1])));
			sum += players.get(i).getNum();
		}

		Player winnerPlayer = players.get(0);
		for (int i = 1; i < playerNum; i++) {
			if (Math.abs(winnerPlayer.getNum() - sum / playerNum / 2) > Math
					.abs(players.get(i).getNum() - sum / playerNum / 2)) {
				winnerPlayer = players.get(i);
			}
		}
		System.out.print(sum / playerNum / 2 + " " + winnerPlayer.getName());
//		scanner.close();
	}

}

class Player {
	public String name = "";
	public int num;

	public Player(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public Player() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
