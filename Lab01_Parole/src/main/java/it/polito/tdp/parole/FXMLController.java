package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;
	boolean tempi;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea secondaTxtArea;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	private Button cancelButton;

	@FXML
	void cancellaParola(ActionEvent event) {
		
		String parolaNuova = txtResult.getSelectedText();
		
		elenco.deleteParole(parolaNuova);
		
		for (String s : elenco.getElenco())
			if (parolaNuova.contains(s))
				elenco.deleteParole(s);

		String testoFinale = "";
		for (String s : elenco.getElenco())
			if (testoFinale.equals(""))
				testoFinale += s;
			else
				testoFinale += "\n" + s;

		txtResult.setText(testoFinale);
		if (tempi == false) {
			secondaTxtArea.appendText("Tempo di elaborazione: " + System.nanoTime() + " nanosecondi");
			tempi = true;
		} else
			secondaTxtArea.appendText("\nTempo di elaborazione: " + System.nanoTime() + " nanosecondi");
		return;
	}

	@FXML
	void doInsert(ActionEvent event) {

		String parolaNuova = txtParola.getText();
		elenco.addParola(parolaNuova);

		String testoFinale = "";
		for (String s : elenco.getElenco())
			if (testoFinale.equals(""))
				testoFinale += s;
			else
				testoFinale += "\n" + s;

		txtResult.setText(testoFinale);

		if (tempi == false) {
			secondaTxtArea.appendText("Tempo di elaborazione: " + System.nanoTime() + " nanosecondi");
			tempi = true;
		} else
			secondaTxtArea.appendText("\nTempo di elaborazione: " + System.nanoTime() + " nanosecondi");

		return;
	}

	@FXML
	void doReset(ActionEvent event) {
		elenco.reset();
		txtResult.setText("");
		secondaTxtArea.appendText("\nTempo di elaborazione: " + System.nanoTime() + " nanosecondi");

		if (tempi == false) {
			secondaTxtArea.appendText("Tempo di elaborazione: " + System.nanoTime() + " nanosecondi");
			tempi = true;
		} else
			secondaTxtArea.appendText("\nTempo di elaborazione: " + System.nanoTime() + " nanosecondi");

		return;
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'Scene.fxml'.";
		assert secondaTxtArea != null : "fx:id=\"secondaTxtArea\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
		tempi = false;
	}
}
