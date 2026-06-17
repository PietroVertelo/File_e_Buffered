package LabotorioInformatica.entidades;

public class Computador extends Equipamentos{

    String Processador;
    String QuatityMemoria;

    public Computador(String id, String marca, String processador, String QuatityMemoria) {
        super(id, marca);
        this.Processador = processador;
        this.QuatityMemoria = QuatityMemoria;
    }

    @Override
    public String toString() {
        return "id: "+Id+", marca: "+marca + " , processador: " + Processador+ " ,Quantidade de memoria: "+ QuatityMemoria;
    }
}
