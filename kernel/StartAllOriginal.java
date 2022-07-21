package kernel;

import java.io.File;
import java.util.List;

public class StartAllOriginal {
	
	public static final String SEP = File.separator;

	public static void main(String[] args) {		
		String rootMps=args[0];
		String rootRisultati=args[1];
		int numberConf = Integer.parseInt(args[3]);
		File fileRootMps = new File(rootMps);
		for(String modello: fileRootMps.list()) {
			
			System.out.println(modello);
			String modelloMps = rootMps + modello + SEP;
			String modelloRisultati = rootRisultati + modello + SEP;
			File fileModelloRisultati = new File(modelloRisultati);
			fileModelloRisultati.mkdir();
			File fileModelloMps = new File(modelloMps);			
			for(String istanza: fileModelloMps.list()) {
				String pathConfig = args[2];
				System.out.println("loop " + istanza);
				String istanzaMps = modelloMps + istanza;
				for(int i=1; i<=numberConf; i++) {
					Configuration config = ConfigurationReader.read(pathConfig, i);	
					String istanzaRisultati = modelloRisultati +istanza + "_" + config.getName() + SEP;
					istanzaRisultati = istanzaRisultati.replace(".mps", "");
					File fileIstanzaRisultati = new File(istanzaRisultati);
					fileIstanzaRisultati.mkdir();
					KernelSearch ks = new KernelSearch(istanzaMps, istanzaRisultati, config);
					ks.start();
				}
			}
			
		}

	}

}