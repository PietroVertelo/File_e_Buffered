package diarioDeJogos.registro;

import java.io.*;
import java.util.Scanner;

public class Registro {
    static void main(String[] args) {

        String[] nome = new String[]{"PLantas vs Zombies", "Rain World", "Elden Ring", "CS2", "Final Fantasy 7"};
        Scanner sc = null;

        String jogo = "C:\\Users\\Aluno_Tarde\\SalvarJogos\\jogos.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jogo));) {

            for (String nomes : nome) {
                bw.write(nomes);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(jogo))) {
            String game;
            while ((game = br.readLine()) != null) {
                System.out.println(game);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}