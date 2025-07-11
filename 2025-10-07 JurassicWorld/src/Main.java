import Conexao.Actions;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Main {

    public static void comandosJaFeitos() {
        Actions.createDinossauros("Paralelepipidis", "Carnívoro", 123, 23, "Contido");
        Actions.createDinossauros("Trirexodon", "Carnívoro", 1580, 45, "Em fuga");
        Actions.createDinossauros("Espinhossauro", "Carnívoro", 2150, 892, "Em laboratório");
        Actions.createDinossauros("Diplodocano", "Herbívoro", 1130, 986, "Seguro");
        Actions.createDinossauros("Velocimimus", "Herbívoro", 320, 201, "Contido");
        Actions.deleteDinossauro(5);
        Actions.updateDinossauro(4, "Em laboratório");
    }

    public static void main(String[] args) {
        Actions.read("Dinossauros", null);
    }
}
