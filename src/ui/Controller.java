package ui;

import core.ContentReader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javafx.concurrent.Worker.State;
import netscape.javascript.JSObject;


public class Controller {
    @FXML
    WebView webView;

    @FXML
    protected void initialize() throws Exception{

        new ContentReader().getChannels();
        // process page loading
        webView.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov,
                                        State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            JSObject win =
                                    (JSObject) webView.getEngine().executeScript("window");
                            win.setMember("app", new ContentReader());
                            webView.getEngine().executeScript("init();");
                        }
                    }
                }
        );

        webView.getEngine().load(getClass().getResource("webview\\index.html").toURI().toString());
    }
}
