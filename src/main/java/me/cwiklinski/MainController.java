package me.cwiklinski;

import animatefx.animation.AnimationFX;
import animatefx.animation.Bounce;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import me.cwiklinski.configuration.Constants;
import me.cwiklinski.configuration.DAOConfiguration;
import me.cwiklinski.exception.FileIsNotDirectoryException;
import me.cwiklinski.exception.LackOfFilesException;
import me.cwiklinski.model.document.DocumentOrder;
import me.cwiklinski.model.document.Order;
import me.cwiklinski.service.JDBCPostgreSQLConnect;
import me.cwiklinski.service.XmlPojoConverter;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class MainController {

    private Alert alertDialog;
    public AnimationFX bounceOne;
    public AnimationFX bounceTwo;
    public AnimationFX bounceThree;

    @FXML
    public Label version;

    @FXML
    public Label fileName;

    @FXML
    public Circle circleOne;

    @FXML
    public Circle circleTwo;

    @FXML
    public Circle circleThree;

    @FXML
    public void initialize() {
        version.setText(Constants.VERSION);
    }

    @FXML
    private void runForrestGump() {
        ConvertService convertTask = new ConvertService();
        convertTask.start();

    }

    class ConvertService extends Service<Void> {

        XmlPojoConverter xmlPojoConverter;
        File[] files;

        public ConvertService() {
            this.xmlPojoConverter = new XmlPojoConverter();
            files = new File[0];

        }

        @Override
        protected Task<Void> createTask() {
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    init();
                    return null;
                }

                @Override
                protected void succeeded() {
                    super.succeeded();
                    stopLoading();
                    showAlert("Udało się", "Zapisano obiekty do bazy", "Ilość zapisanych obiektów: " + files.length, Alert.AlertType.INFORMATION);
                    changeFileLabel("");
                }

                @Override
                protected void failed() {
                    super.failed();
                    stopLoading();
                    changeFileLabel("");
                }

                @Override
                protected void running() {
                    super.running();
                    animateLoading();
                }
            };
            return task;
        }

        public void init() {
            xmlPojoConverter = new XmlPojoConverter();
            try {
                //Pobranie wszystkich nazw plików
                files = xmlPojoConverter.getAllFilesNames(Path.of(Constants.ROOT_PATH).toFile());
            } catch (FileNotFoundException throwables) {
                showAlert("Błąd", "Problem z konwersją pliku", throwables.getMessage(), Alert.AlertType.ERROR);
            } catch (FileIsNotDirectoryException throwables) {
                showAlert("Błąd", "Obiekt nie jest folderem", throwables.getMessage(), Alert.AlertType.ERROR);
            } catch (LackOfFilesException throwables) {
                showAlert("Błąd", "Brak plików", throwables.getMessage(), Alert.AlertType.ERROR);
            }

            //Wypisanie wszytskich plików w folderze
            Arrays.stream(files).forEach(e -> System.out.println(e.getName()));

            //Pętla po nazwach plików i ich przekonwertowanie
            Arrays.stream(files).forEach(file -> {
                convertFile(Path.of(Constants.ROOT_PATH, file.getName()).toString());
                changeFileLabel(file.getName());
            });
        }

        private void changeFileLabel(String name) {
            Platform.runLater(() -> {
                fileName.setText(name);
            });
        }

        private void convertFile(String file) {
            Order order = new Order();
            try {
                order = xmlPojoConverter.UnmarshalMyFile(file);
                xmlPojoConverter.archiveMyFile(Path.of(file).toFile());
            } catch (JAXBException throwables) {
                showAlert("Błąd", "Problem z konwersją pliku", throwables.getMessage(), Alert.AlertType.ERROR);
            } catch (FileNotFoundException throwables) {
                showAlert("Błąd", "Brak pliku DD", throwables.getMessage(), Alert.AlertType.ERROR);
                throwables.printStackTrace();
            }
            saveToDatabase(order);
        }

        private void saveToDatabase(Order order) {
            Connection conn = null;
            try {
                conn = new JDBCPostgreSQLConnect().getConnection();
            } catch (SQLException throwables) {
                showAlert("Błąd", "Nie można otworzyć połączenia", throwables.getMessage(), Alert.AlertType.ERROR);
            }

            for (DocumentOrder documentOrder : order.getDocumentOrders()) {
                try (PreparedStatement statement = conn.prepareStatement(DAOConfiguration.INSERT_DOCUMENT_SQL)) {
                    statement.setString(1, documentOrder.getOrderHeader().getVendorOrderNumber());
                    statement.setDate(2, Date.valueOf(documentOrder.getOrderHeader().getOrderDate()));
                    statement.setString(3, documentOrder.getOrderParties().getBuyer().getILN());
                    statement.setString(4, documentOrder.getOrderLines().getLine().getLineItem().getEAN());
                    statement.setInt(5, documentOrder.getOrderLines().getLine().getLineItem().getOrderedQuantity());
                    statement.setDate(6, Date.valueOf(documentOrder.getOrderLines().getLine().getLineItem().getExpectedDeliveryDate()));
                    statement.executeUpdate();
                } catch (SQLException throwables) {
                    showAlert("Błąd", "Nie można utworzyć kwerendy", throwables.getMessage(), Alert.AlertType.ERROR);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    showAlert("Błąd", "Nie można zamknąć połączenia", throwables.getMessage(), Alert.AlertType.ERROR);
                }
            }
        }

        private void showAlert(String title, String header, String content, Alert.AlertType type) {
            Platform.runLater(() -> {
                alertDialog = new Alert(type);
                alertDialog.setTitle(title);
                alertDialog.setHeaderText(header);
                alertDialog.setContentText(content);
                alertDialog.showAndWait();
            });

        }

        private void animateLoading() {
            Platform.runLater(() -> {
                bounceOne = new Bounce(circleOne).setCycleDuration(4).setCycleCount(44).setDelay(Duration.valueOf("100ms"));
                bounceTwo = new Bounce(circleTwo).setCycleDuration(4).setCycleCount(44).setDelay(Duration.valueOf("200ms"));
                bounceThree = new Bounce(circleThree).setCycleDuration(4).setCycleCount(44).setDelay(Duration.valueOf("150ms"));
                circleOne.setVisible(true);
                circleTwo.setVisible(true);
                circleThree.setVisible(true);
                bounceOne.play();
                bounceTwo.play();
                bounceThree.play();
            });

        }

        private void stopLoading() {
            Platform.runLater(() -> {
                bounceOne.stop();
                bounceTwo.stop();
                bounceThree.stop();
                circleOne.setVisible(false);
                circleTwo.setVisible(false);
                circleThree.setVisible(false);
            });
        }

    }


}

