package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Model.Centroid;
import Model.Container;
import View.Panel;

public class MainController {

    private Panel panel;
    private Container container = new Container();
    private Painter painter;

    public MainController(Panel panel) {

        this.panel = panel;
        this.painter = new Painter(panel.getGraph(), container);
        addActionListeners();

    }

    private void addActionListeners() {

        panel.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    int K = panel.getK();
                    makeCentroids(K);

                    int maxIterations = panel.getMaxIterations();
                    setMaxIterations(maxIterations);
                    
                    panel.getOutData().setText(container.startKMeans());
                    painter.paint();
                } 
                catch(Exception exception) {
                    panel.getOutData().setText("Need more info.");
                }
                
            }
        });

        for(int i = 0; i < panel.getArrayPickers().length; i++) {

            final int index = i + 1;
            panel.getArrayPickers()[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    loadCSV(index);
                    painter.firstPaint();
                }    
            });
        }
    }

    public void loadCSV(int CSVNumber) {

        new CSVLoader(CSVNumber, container);
    }

    private void makeCentroids(int K) { 

        Random random = new Random();
        Centroid[] centroids = new Centroid[K];
        
        for(int i = 0; i < K; i++) {
            
            int centroidX = random.nextInt(100);
            int centroidY = random.nextInt(100);
            Centroid centroid = new Centroid(centroidX, centroidY, i + 2);
            centroids[i] = centroid;
        }

        container.setCentroids(centroids);
    }

    private void setMaxIterations(int maxIterations) {

        container.setMaxIterations(maxIterations);
    }
}