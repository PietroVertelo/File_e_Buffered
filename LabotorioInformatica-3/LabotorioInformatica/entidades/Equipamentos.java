package LabotorioInformatica.entidades;

public class Equipamentos {
    protected String Id;
    protected String marca;

    public Equipamentos(String id, String marca) {
        this.Id = id;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "id: "+Id+", marca: "+marca;
    }
}
