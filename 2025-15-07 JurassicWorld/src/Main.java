import Model.Dinossauro;

import DAO.DinossauroDAO;

public class Main {
    public static void main(String[] args) {

        System.out.println("---TODOS OS DINOSSAUROS---");
        DinossauroDAO.listarTodos();

        System.out.println("---TODOS OS DINOSSAUROS CARNIVOROS---");
        DinossauroDAO.listarPorDieta("Carnivoro");

        System.out.println("---TODOS OS DINOSSAUROS SEGUROS ORDENADOS POR NOME---");
        DinossauroDAO.listarPorStatus("Seguro");

        DinossauroDAO.listarTodos();

        DinossauroDAO.deleteDino(2);




    }
}
