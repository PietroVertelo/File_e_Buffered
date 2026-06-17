package sistema.application;

import sistema.entities.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String path = "C:\\usuarioLista\\usuarios.csv.txt";
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Neymar","neymarcs2@gmail.com","35"));
        usuarios.add(new Usuario("KaKá","kakajuventos@gmail.com","44"));
        usuarios.add(new Usuario("Ayrton Senna","ayrtoncarros@gmail.com","34"));
        usuarios.add(new Usuario("Deco","peladeirosdocabana@gmail.com","52"));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Usuario usuario : usuarios){
                String escrita = usuario.getNome()+";"+usuario.getEmail()+";"+usuario.getIdade();
                bw.write(escrita);
                bw.newLine();
            }
        } catch (IOException erro) {
            System.out.println("Erro: "+erro.getMessage());
            erro.printStackTrace();
        }
        List<Usuario> listaAtualizada = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha = br.readLine();
            while (linha!=null){
                String[] formatacao = linha.split(";");
                System.out.println(linha);
                linha = br.readLine();

                String nome = formatacao[0];
                String email = formatacao[1];
                String idade = formatacao[2];

                Usuario usuarioFormatado = new Usuario(nome,email,idade);
                listaAtualizada.add(usuarioFormatado);
            }
        }catch (IOException e){
            System.out.println("Erro: "+e.getMessage());
            e.printStackTrace();
        }
        for (Usuario users : listaAtualizada){
            users.exibirInfo();
        }

    }
}
