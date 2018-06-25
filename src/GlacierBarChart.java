import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;

import java.util.Arrays;

/**
 * @author Till Wischniewski
 * @version 1.01
 */

public class GlacierBarChart extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        // Bar Chart Gletscher rückgang 2017

        // x axis Gletscher
        CategoryAxis xAxis = new CategoryAxis();

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Hornkees", "Zettalunitzkee",
                "Schlachtkees", "Perterze", "Daunkogelferner", "Wasserfallwinkelkees", "Schalfferner",
                "Bachfallenferner", "Frosnitzkees", "Westliches Trippkees")));

        //y axis rückgang in metern
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Rückgang in Metern");

        //Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Comparision height loss glacier 2017");

        //XYChart objects
        XYChart.Series<String, Number> gh = new XYChart.Series<>();
        gh.setName("Austrian Glacier");
        gh.getData().add(new XYChart.Data<>("Hornkees", -65.0));
        gh.getData().add(new XYChart.Data<>("Zettalunitzkee", -51.0));
        gh.getData().add(new XYChart.Data<>("Schlachtkees", -50.0));
        gh.getData().add(new XYChart.Data<>("Perterze", -44.3));
        gh.getData().add(new XYChart.Data<>("Daunkogelferner", -44.0));
        gh.getData().add(new XYChart.Data<>("Wasserfallwinkelkees", -39.4));
        gh.getData().add(new XYChart.Data<>("Schalfferner", -39.1));
        gh.getData().add(new XYChart.Data<>("Bachfallenferner", -37.7));
        gh.getData().add(new XYChart.Data<>("Frosnitzkees", -36.0));
        gh.getData().add(new XYChart.Data<>("Westliches Trippkees", -35.4));

        //Data to bar chart
        barChart.getData().addAll(gh);
        barChart.getXAxis().setTickLabelRotation(-90);

        Group root = new Group(barChart);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setTitle("Till's First Bar Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}