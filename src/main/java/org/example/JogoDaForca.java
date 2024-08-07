package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JogoDaForca {

    private HangMan hangMan = new HangMan();
    private String palavra;
    private Set<Character> letras = new HashSet<>();

    private Scanner scanner = new Scanner(System.in);

    public JogoDaForca(){
        letras.add(' ');
        System.out.print("Informe a palavra: ");
        this.palavra = scanner.nextLine().toLowerCase();

        imprimirPalavra();

        System.out.println();

        char letra;
        while (!checaVitoria()){
            System.out.print("Informe uma letra: ");
            letra = Character.toLowerCase(scanner.next().charAt(0));
            letras.add(letra);

            if(!palavra.contains(""+letra)) hangMan.errou();

            System.out.println("\n-----------------------------------------------------------");
            hangMan.escreveBoneco();
            if(hangMan.erros >= 6) break;

            System.out.println();
            imprimirPalavra();
            imprimirLetras();
            System.out.println("-----------------------------------------------------------");

            System.out.println();
        }

        System.out.println();
        if (checaVitoria()){
            System.out.println("Parabéns, você ganhou");
            return;
        }

        System.out.println("Você perdeu. A palavra era: " + palavra);

    }

    public void imprimirLetras(){
        System.out.print("Letras ditas: ");
        letras.forEach(l -> {
            if(l != ' ') System.out.print(l + " ");
        });
        System.out.println();
    }

    public void imprimirPalavra(){
        for(int i = 0; i < palavra.length(); i ++){
            if(palavra.charAt(i) == ' ') System.out.print(" ");
            else if(letras.contains(palavra.charAt(i))) System.out.print(palavra.charAt(i));
            else System.out.print("_");
        }
        System.out.println();
    }

    public boolean checaVitoria(){
        boolean venceu = true;
        for (int i = 0; i < palavra.length(); i ++){
            if(!letras.contains(palavra.charAt(i))){
                venceu = false;
            }
        }
        return venceu;
    }

    public String getPalavra() {
        return palavra;
    }
}
