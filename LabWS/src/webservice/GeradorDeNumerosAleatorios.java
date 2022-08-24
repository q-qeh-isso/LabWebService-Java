package webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeNumerosAleatorios {
	
	public List<Integer> gerar(int maximo, int quantidade){
		Random rand = new Random();
		List<Integer> numeros = new ArrayList<Integer>();
		while(quantidade > 0){
			numeros.add(rand.nextInt(maximo)+1);
			quantidade--;
		}
		return numeros;
	}

}
