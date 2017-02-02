/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainhost;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application
{

    private AtomicInteger isScaling;
    private int           widthCount;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockup3.fxml"));
        MainWindow mainWindow = new MainWindow(primaryStage);
        loader.setController(mainWindow);
        Parent root = loader.load();
        primaryStage.setTitle("Host Controller");
        Scene theScene = new Scene(root, MainWindow.BASE_WIDTH, MainWindow.BASE_HEIGHT);
        isScaling = new AtomicInteger(0);
        widthCount = 0;

        /*MessagePipeline pipe = MessagePipeline.getInstance();
        Thread pipeThread = new Thread(pipe);
        pipeThread.start();//runs in background, not connected yet*/

        System.getProperties().setProperty("swing.jlf.contentPaneTransparent","true");

        primaryStage.widthProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public synchronized void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                //if(widthCount >= 0)
                scaleWindow(newValue.doubleValue(), true, primaryStage);
                //widthCount++;
            }
        });
        primaryStage.heightProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public synchronized void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                //if(widthCount < 0)
                scaleWindow(newValue.doubleValue(), false, primaryStage);
                //widthCount--;
            }
        });
        primaryStage.setScene(theScene);
        primaryStage.show();
    }

    private synchronized void scaleWindow(double newValue, boolean isWidth, Stage primaryStage)
    {
        if(isScaling.get() == 0 && primaryStage.getWidth() > 0 && primaryStage.getHeight() > 0)
        {
            isScaling.set(2);
            if (isWidth)
                primaryStage.setHeight(newValue * MainWindow.WIDTH_TO_HEIGHT_RATIO + MainWindow.HEIGHT_OFFSET);
            else
                primaryStage.setWidth(newValue * MainWindow.HEIGHT_TO_WIDTH_RATIO + MainWindow.WIDTH_OFFSET);
        }
        else if(isScaling.get() > 0)
            isScaling.getAndDecrement();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

