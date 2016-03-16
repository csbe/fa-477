package ch.csbe.ifa.partei.controller;

import java.util.Date;

import ch.csbe.ifa.partei.model.Amt;
import ch.csbe.ifa.partei.model.Mitglied;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public abstract class Controller {
	@FXML
	public TabPane tabpane;
	@FXML
	protected Tab erfassen;
	@FXML
	protected TableView<Mitglied> mitgliedtable;
	@FXML
	protected TableColumn<Mitglied, String> first;
	@FXML
	protected TableColumn<Mitglied, String> last;
	@FXML
	protected TableColumn<Mitglied, String> id;
	@FXML
	protected TableColumn<Mitglied, String> wohnort;
	
	
	@FXML
	protected TableView<Amt> amttable;
	@FXML
	protected TableColumn<Amt, Mitglied> mitgliedname;
	@FXML
	protected TableColumn<Amt, String> ebene;
	@FXML
	protected TableColumn<Amt, String> bezeichnung;
	@FXML
	protected TableColumn<Amt, Date> wahldatum;
	
}
