package asp3;

public class CriptografiaCesar {
	 public String cifrar(String texto, int chave) {
	        StringBuilder textoCifrado = new StringBuilder();

	        for (char caractere : texto.toCharArray()) {
	            if (Character.isLetter(caractere)) {
	                char inicioAlfabeto = Character.isLowerCase(caractere) ? 'a' : 'A';
	                textoCifrado.append((char) ((caractere - inicioAlfabeto + chave) % 26 + inicioAlfabeto));
	            } else {
	                textoCifrado.append(caractere);
	            }
	        }

	        return textoCifrado.toString();
	    }

	    public String decifrar(String texto, int chave) {
	        StringBuilder textoDecifrado = new StringBuilder();

	        for (char caractere : texto.toCharArray()) {
	            if (Character.isLetter(caractere)) {
	                char inicioAlfabeto = Character.isLowerCase(caractere) ? 'a' : 'A';
	                textoDecifrado.append((char) ((caractere - inicioAlfabeto - chave + 26) % 26 + inicioAlfabeto));
	            } else {
	                textoDecifrado.append(caractere);
	            }
	        }

	        return textoDecifrado.toString();
	    }
}
