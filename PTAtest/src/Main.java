import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		int count = scanner.nextInt();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer strtoken = new StreamTokenizer(reader);
		strtoken.nextToken();
		int[] arr = new int[(int) strtoken.nval];
		for (int i = 0; i < arr.length; i++) {
			strtoken.nextToken();
			arr[i] = (int) strtoken.nval;
		}

		int temp = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		scanner.close();
		int introverted = 0;
		int introvertedCnt = arr.length / 2;
		int outgoing = 0;
		int outgoingCnt = arr.length / 2;

		int diff = 0;
		if (arr.length % 2 == 0) {
			for (int i = 0; i < arr.length / 2; i++) {
				introverted += arr[i];
			}
			for (int i = arr.length / 2; i < arr.length; i++) {
				outgoing += arr[i];
			}
		} else {
			for (int i = 0; i < arr.length / 2; i++) {
				introverted += arr[i];
			}
			for (int i = arr.length / 2 + 1; i < arr.length; i++) {
				outgoing += arr[i];
			}
			if (outgoing - (introverted + arr[arr.length / 2]) > outgoing + arr[arr.length / 2] - introverted) {
				introverted += arr[arr.length / 2];
				introvertedCnt += 1;
			} else {
				outgoing += arr[arr.length / 2];
				outgoingCnt += 1;
			}
		}
		diff = outgoing - introverted;
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		pw.println("Outgoing #: " + outgoingCnt);
		pw.println("Introverted #: " + introvertedCnt);
		pw.println("Diff = " + diff);
		pw.flush();

	}

}
