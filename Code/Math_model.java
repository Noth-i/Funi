package ckr.com;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Math_model {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double s = 0;
		int r = 0;
		int review_sum = 0;	
		double aver = 0;
		String[] time = new String[3000];		//��������
		double[] score = new double[3000];		//����ÿ�����־�ֵ
		int[] review = new int[3000];			//����ÿ�����۵�����
		int[] sum_review = new int[3000];				//���������������ۼ�
		double[] sum = new double[3000];
		double[] average = new double[3000];		//�����ۼ�ÿ�����־�ֵ��ľ�ֵ
		String[] average_str = new String[3000];
		
		File pacifierT = new File("D:/America.C/hair_dryer_fitting/hair_dryer_time.txt");		//��������
		File pacifierS = new File("D:/America.C/hair_dryer_fitting/hair_dryer_score.txt");		//�������־�ֵ
		File pacifierR = new File("D:/America.C/hair_dryer_fitting/hair_dryer_review.txt");
		File result_average = new File("D:/America.C/hair_dryer_fitting/result_average.txt");
		//����
		int count = 0;	
		try {
			FileReader frt = new FileReader(pacifierT);
			BufferedReader bufr = new BufferedReader(frt);
			String t = null;
			while(count < 2307) {
				t = bufr.readLine();
				time[count] = t;
				count++;
			}
			bufr.close();
			frt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//ÿ�����־�ֵ
		count = 0; 			//��������
		try {
			FileReader frs = new FileReader(pacifierS);
			BufferedReader bufr = new BufferedReader(frs);
			String str = null;
			while(count < 2307) {
				str = bufr.readLine();
				s = Double.valueOf(str);
				score[count] = s;
				count++;
			}
			bufr.close();
			frs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//��������
		count = 0; 			//��������
		try {
			FileReader frr = new FileReader(pacifierR);
			BufferedReader bufr = new BufferedReader(frr);
			String str = null;
			while(count < 2307) {
				str = bufr.readLine();
				r = Integer.valueOf(str);
				review[count] = r;
				count++;
			}
			bufr.close();
			frr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		sum[0] = score[0] * review[0]; 
		sum_review[0] = review[0]; 
		for(int i = 1;i < count;i++) {
			sum[i] = sum[i-1] + score[i]*review[i];
			sum_review[i] = sum_review[i-1] + review[i];
		}
		
		for(int i = 0;i < count;i++) {
			average[i] = sum[i]/sum_review[i];
		}
		
		for(int i = 0;i < count;i++) {
			Double b = new Double(average[i]);
			average_str[i] = b.toString();
		}
		
		try {
			FileWriter fw = new FileWriter(result_average);
			BufferedWriter bufw = new BufferedWriter(fw);
			for(int i = 0;i < count;i++) {
				bufw.write(average_str[i]);
				bufw.newLine();
			}
			bufw.close();
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/* ������
		int c = 1;
		for(int i = 0;i < count;i++) {
			if(c%10==0) {
				System.out.println(average[i]);
				c++;
			}else {
				System.out.print(average[i] + " ");
				c++;
			}
		}*/
	}

}
