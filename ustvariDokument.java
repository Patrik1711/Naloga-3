import java.io.*;
import java.util.*;
import java.lang.*;

public class ustvariDokument {
	
	private Formatter x;
	
	public void odpriDokument() {
		String fileName="klici.csv";
		File file = new File(fileName);
		
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(";");
				
				String TipCDR = values[0];
				String stevilkaA = values[1];
				String stevilkaB = values[2];
				String casKlica = values[3];
				String trajanje = values[4];
				x.format("%s%s%s%s%s","" +TipCDR +";",""+ stevilkaA +";",""+ stevilkaB +";",""+ casKlica +";",""+ trajanje +"\n");
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ustvariDokument() {
		// TODO Auto-generated method stub
		try {
			x = new Formatter ("klici.cdr");
		}
		catch (Exception e) {
			System.out.println("Prišlo je do napake.");
		}
	}
	public void dodajPodatke() {
		// TODO Auto-generated method stub
		
		String fileName="klici.cdr";
		File klici1 = new File(fileName);
		
		Map<String, List<String>> klic = new HashMap<>();
		List<String> list = new ArrayList<>();
		try {
			Scanner inputStream = new Scanner(klici1);
			
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(";");
				
				klici k1= new klici(values[0],values[1],values[2],values[3],values[4]);
				
				klic.computeIfAbsent(values[0], k -> new ArrayList<>()).add(k1.tipCDR + ";"+ k1.stevilkaA +";" + k1.stevilkaB+ ";"+ k1.casKlica + ";" +k1.trajanje);
					
			}
			System.out.println("Izpis vseh podatkov: "+ klic +"\n");
			System.out.println("Izpis podatko po kljuèu 201: "+ klic.get("201")+"\n");
			System.out.println("Izpis podatko po kljuèu 202:  "+ klic.get("202"));
			
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void zapriDokument() {
		// TODO Auto-generated method stub
		x.close();
	}
	
	
	public class klici {
		String tipCDR;
		String stevilkaA;
		String stevilkaB;
		String casKlica; 
		String trajanje;
		
		
		
		klici(String t,String sa,String sb,String ck,String tr){
			this.tipCDR=t;
			this.stevilkaA=sa;
			this.stevilkaB=sb;
			this.casKlica=ck;
			this.trajanje=tr;
		}
		
	}
}


