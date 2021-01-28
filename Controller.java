package karta_pacjenta;

import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;


public class Controller implements Initializable {

    ArrayList<Pacjent> pacjenci = new ArrayList<>();
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private TextArea pole_imie, pole_nazwisko, pole_wiek;

    @FXML
    private Button dodaj_do, drukuj;

    @FXML
    private ChoiceBox<String> sortowanie;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dane_sortowania();
    }

    public void dane_sortowania() {
        list.removeAll(list);
        String s_imie = "Imienia";
        String s_nazwisko = "Nazwiska";
        String s_wiek = "Wieku";
        String s_kolejnosc = "Kolejności dodania";
        list.addAll(s_imie, s_nazwisko, s_wiek, s_kolejnosc);
        sortowanie.getItems().addAll(list);
    }

    public void dodaj_pacjenta(ActionEvent event) {
        try {
            pacjenci.add(new Pacjent(pole_imie.getText(), pole_nazwisko.getText(), Integer.parseInt(pole_wiek.getText())));
        } catch (Exception e) {

        }
    }

    public void drukuj_pacjentow(ActionEvent event) {
        try {
            String value = (String) sortowanie.getValue();
            if (value == "Imienia") {
                sortowanie_imie();
            } else if (value == "Nazwiska") {
                sortowanie_nazwisko();
            } else if (value == "Wieku") {
                sortowanie_wiek();
            } else {
                sortowanie_kolejnosc();
            }
        } catch (Exception e) {

        }
    }

    public void sortowanie_imie() {
        pacjenci.sort(Comparator.comparing(Pacjent::getImie));
        for(int i = 0; i < pacjenci.size(); i++) {
            System.out.print(pacjenci.toString());
        }
    }

    public void sortowanie_nazwisko() {
        pacjenci.sort(Comparator.comparing(Pacjent::getNazwisko));
        for(int i = 0; i < pacjenci.size(); i++) {
            System.out.print(pacjenci.toString());
        }
    }

    public void sortowanie_wiek() {
        pacjenci.sort(Comparator.comparing(Pacjent::getWiek));
        for(int i = 0; i < pacjenci.size(); i++) {
            System.out.print(pacjenci.toString());
        }
    }

    public void sortowanie_kolejnosc() {
        for(Pacjent p : pacjenci) {
            System.out.print(pacjenci.toString());
        }
    }

}
