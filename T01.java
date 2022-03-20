package Simulacion;

import java.util.Random;
import java.util.Scanner;
public class T01 {
	public static void main(String Args[]) {
		int A�os = 0, Peso = 0, Dinero = 0, PesoT = 0;
		double NR;
		boolean SobreCarga = false;
		Scanner S = new Scanner(System.in);
		boolean C = true;
		do{
			try {
				C = true;
				System.out.println("Escribe los a�os");
				A�os = S.nextInt();
				C = false;
			}catch(Exception e) {
				S = new Scanner(System.in);
			}
		}while(C || A�os<1);
		for(int x = 0; x<(A�os*260);x++) {
			PesoT = 0;
			SobreCarga = false;
			for(int y = 0; y<5; y++) {
				NR = GenerarNumero();
				if(NR == 0.5) {
					Peso = 210;
				}else {
					if(NR < 0.5) {
						Peso = (int) (190 + Math.sqrt(800*NR));
					}else {
						Peso = (int) (230 - Math.sqrt(800*(1-NR)));
					}
				}
				//PesoT = PesoT + Peso;
				PesoT+=Peso;
				if(PesoT > 1000 && !SobreCarga) {
					SobreCarga = true;
					Dinero = Dinero + 200;
				}
				System.out.println((y==0?(x+1)+"":Huecos((x+"").length()))+" | " + (y+1) + " | " + NR + " | " + Peso + " | " + PesoT + " | " + (SobreCarga?"Si":"No") + " | " + Dinero);
			}
		}
		System.out.println("----------------------------------------------");
		System.out.println("Costos promedio anual = " + (Dinero/A�os));
		if((Dinero/A�os)<60000) {
			System.out.println("Es mejor rentar");
		}
	}

	private static double GenerarNumero() {
		Random R = new Random();
		return R.nextDouble();
	}
	private static String Huecos(int E) {
		String H = "";
		for(int x=0; x<E; x++) {
			H = H + " ";
		}
		return H;
	}
}
