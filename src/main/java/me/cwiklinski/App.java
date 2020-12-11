package me.cwiklinski;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.cwiklinski.configuration.Constants;
import me.cwiklinski.model.document.DocumentOrder;
import me.cwiklinski.service.XmlPojoConverter;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.setTitle(Constants.TITLE);
        stage.setScene(scene);
        stage.show();

        XmlPojoConverter xmlPojoConverter = new XmlPojoConverter(DocumentOrder.class);
        DocumentOrder documentOrder = new DocumentOrder();
        try {
            documentOrder = (DocumentOrder) xmlPojoConverter.UnmarshalMyFile(Constants.PATH_TO_FILE);
        } catch (JAXBException e) {
            // todo coś tam zrób
        } catch (FileNotFoundException e) {
            // todo coś tam zrób
        }

        System.out.println(documentOrder.toString());
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
