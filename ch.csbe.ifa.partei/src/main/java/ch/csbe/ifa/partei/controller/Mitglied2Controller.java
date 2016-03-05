package ch.csbe.ifa.partei.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

import ch.csbe.ifa.partei.dao.AmtDao;
import ch.csbe.ifa.partei.dao.Database;
import ch.csbe.ifa.partei.dao.MitgliedDao;
import ch.csbe.ifa.partei.helper.Session;
import ch.csbe.ifa.partei.model.Amt;
import ch.csbe.ifa.partei.model.Mitglied;
import ch.csbe.ifa.partei.view.MitgliedForm;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Mitglied2Controller extends Controller {

	private Controller iface;

	@FXML
	public void initialize() {
		iface = this;
		erfassen.setContent(new MitgliedForm(iface));
		Database.getInstance().openSession();
		mitglieder();
		aemter();
		Database.getInstance().closeSession();
	}

	public void mitglieder() {
		MitgliedDao mitglieddao = new MitgliedDao();
		List<Mitglied> mitglieder = mitglieddao.list();
		first.setCellValueFactory(new PropertyValueFactory<Mitglied, String>("vorname"));
		last.setCellValueFactory(new PropertyValueFactory<Mitglied, String>("name"));
		id.setCellValueFactory(new PropertyValueFactory<Mitglied, String>("id"));
		wohnort.setCellValueFactory(new PropertyValueFactory<Mitglied, String>("ort"));
		mitgliedtable.getItems().setAll(mitglieder);

		mitgliedtable.setRowFactory(new Callback<TableView<Mitglied>, TableRow<Mitglied>>() {
			@Override
			public TableRow<Mitglied> call(TableView<Mitglied> tableView) {
				final TableRow<Mitglied> row = new TableRow<>();
				final ContextMenu contextMenu = new ContextMenu();
				final MenuItem removeMenuItem = new MenuItem("Remove");
				removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Database.getInstance().openSession();
						mitglieddao.remove(row.getItem());
						mitgliedtable.getItems().remove(row.getItem());
					}
				});
				final MenuItem editMenuItem = new MenuItem("Edit");
				editMenuItem.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						Session.getInstance("first").getMap().put("mitglied", row.getItem());
						Tab t = new Tab("Bearbeiten " + row.getItem().getName());
						t.setContent(new MitgliedForm(iface));
						tabpane.getTabs().add(t);
						tabpane.getSelectionModel().select(tabpane.getTabs().size() - 1);
					}
				});

				contextMenu.getItems().add(editMenuItem);
				contextMenu.getItems().add(removeMenuItem);
				row.contextMenuProperty()
						.bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(contextMenu));
				return row;
			}
		});

	}

	public void aemter() {
		AmtDao amtdao = new AmtDao();
		List<Amt> aemter = amtdao.list();
		
		ebene.setCellValueFactory(new PropertyValueFactory<Amt, String>("ebene"));
		bezeichnung.setCellValueFactory(new PropertyValueFactory<Amt, String>("bezeichnung"));
		wahldatum.setCellValueFactory(new PropertyValueFactory<Amt, Date>("wahldatum"));
		DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		wahldatum.setCellFactory((column -> {
		    return new TableCell<Amt, Date>() {
		        @Override
		        protected void updateItem(Date item, boolean empty) {
		            super.updateItem(item, empty);		
		            if (item == null || empty) {
		                setText(null);
		            } else {
		            	Instant instant = Instant.ofEpochMilli(item.getTime());
		                setText(myDateFormatter.format(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()));
		            }
		        }
		    };
		}));
		
		amttable.getItems().setAll(aemter);

		amttable.setRowFactory(new Callback<TableView<Amt>, TableRow<Amt>>() {
			@Override
			public TableRow<Amt> call(TableView<Amt> tableView) {
				final TableRow<Amt> row = new TableRow<>();
				final ContextMenu contextMenu = new ContextMenu();
				final MenuItem removeMenuItem = new MenuItem("Remove");
				removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
//						Database.getInstance().openSession();
//						mitglieddao.remove(row.getItem());
//						mitgliedtable.getItems().remove(row.getItem());
					}
				});
				final MenuItem editMenuItem = new MenuItem("Edit");
				editMenuItem.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
//						Session.getInstance("first").getMap().put("mitglied", row.getItem());
//						Tab t = new Tab("Bearbeiten " + row.getItem().getName());
//						t.setContent(new MitgliedForm(iface));
//						tabpane.getTabs().add(t);
//						tabpane.getSelectionModel().select(tabpane.getTabs().size() - 1);
					}
				});

				contextMenu.getItems().add(editMenuItem);
				contextMenu.getItems().add(removeMenuItem);
				row.contextMenuProperty()
						.bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(contextMenu));
				return row;
			}
		});

	}

}
