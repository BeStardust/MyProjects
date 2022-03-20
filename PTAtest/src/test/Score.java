package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Score {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Student> stus = new ArrayList<Student>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer strToken = new StreamTokenizer(reader);
		strToken.nextToken();
		int stuNum = (int) strToken.nval;
		strToken.nextToken();
		int scoreNum = (int) strToken.nval;
		strToken.nextToken();
		int outNum = (int) strToken.nval;
		for (int i = 0; i < stuNum; i++) {
			int scores[] = new int[scoreNum];
			for (int j = 0; j < scoreNum; j++) {
				strToken.nextToken();
				scores[j] = (int) strToken.nval;
			}
			stus.add(new Student(calculate(scores)));
//			System.out.printf("%.3f ", stus.get(i).getAve());
		}

		double out[] = new double[stus.size()];
		for (int i = 0; i < stus.size(); i++) {
			out[i] = stus.get(i).getAve();
		}
		for (int i = 0; i < out.length-1; i++) {
			for (int j = i; j < out.length-1; j++) {
				if (out[j]>out[j+1]) {
					double temp;
					temp=out[j];
					out[j]=out[j+1];
					out[j+1]=temp;
				}
			}
		}
		for (int i = out.length-outNum; i < out.length; i++) {
			System.out.printf("%.3f", out[i]);
			if (i<out.length-1) {
				System.out.printf(" ");
			}
		}
	

	}

	private static double calculate(int score[]) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		int max = score[0];
		for (int i = 1; i < score.length; i++) {
			if (score[i] > max) {
				max = score[i];
			}
		}
		int min = score[0];
		for (int i = 1; i < score.length; i++) {
			if (score[i] < min) {
				min = score[i];
			}
		}
		double ave = (double) (sum - max - min) / (score.length - 2);
		return ave;
	}
}

class Student {
	public double ave;

	public Student() {
		super();
	}

	public Student(double ave) {
		super();
		this.ave = ave;
	}

	public double getAve() {
		return ave;
	}

	public void setAve(double ave) {
		this.ave = ave;
	}
}