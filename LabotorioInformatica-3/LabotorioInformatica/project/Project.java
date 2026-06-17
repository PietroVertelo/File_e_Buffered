package LabotorioInformatica.project;

import LabotorioInformatica.entidades.Computador;
import LabotorioInformatica.entidades.Equipamentos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    static void main(String[] args) {

        String Entrada = "C:\\Users\\Aluno_Tarde\\entrada\\inventario.txt";
        ArrayList<Equipamentos> equipamentos = new ArrayList<>();
        ArrayList<String> error = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(Entrada))) {

            String inv;
            while ((inv = br.readLine()) != null) {
                br.readLine();
                if (inv.charAt(0) == 'E') {
                    String[] vectL = inv.split(",");
                    Equipamentos equipamento = new Equipamentos(vectL[1], vectL[2]);
                    equipamentos.add(equipamento);
                } else if (inv.charAt(0) == 'C') {
                    String[] vectL = inv.split(",");
                    Computador computador = new Computador(vectL[1], vectL[2], vectL[3], vectL[4]);
                    equipamentos.add(computador);
                } else {
                    error.add("Equipamento (" + inv + ") não identificado.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho do seu arquivo: ");
        String path = sc.nextLine();

        String pathEquipamentos = path + "\\relatorio_valido.txt";
        String pathErrors = path + "\\log_erros.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathEquipamentos))) {

            for (Equipamentos equip : equipamentos) {
                bw.write(equip.toString());
                bw.newLine();
            }
            System.out.println("Relatório criado.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathErrors))){

            for (String e : error) {
                bw.write(e);
                bw.newLine();
            }

            System.out.println("Log criado.");
        }
        catch (IOException e) {}
    }
}