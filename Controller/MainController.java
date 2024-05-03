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
    private boolean KMeans = true;

    public MainController(Panel panel) {

        this.panel = panel;
        this.painter = new Painter(panel.getGraph(), container);
        addActionListeners();

    }

    private void addActionListeners() {

        panel.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (KMeans) {
                    try {
                        int K = panel.getK();
                        makeCentroids(K);
    
                        int maxIterations = panel.getMaxIterations();
                        container.setMaxIterations(maxIterations);
                        
                        panel.getOutData().setText(container.startClustering(KMeans));
                        painter.paint(true);
                    } 
                    catch(Exception exception) {
                        panel.getOutData().setText("Need more info.");
                    }
                }
                else {
                    try {

                        int minimumPoints = panel.getK();
                        container.setMinimumPoints(minimumPoints);
    
                        int epsilon = panel.getMaxIterations();
                        container.setEpsilon(epsilon);
                        
                        panel.getOutData().setText(container.startClustering(KMeans));
                        painter.paint(false);
                    } 
                    catch(Exception exception) {
                        panel.getOutData().setText("Need more info.");
                    }
                }
                
                
            }
        });

        panel.getKMeansButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (!panel.getKMeansButton().isSelected()) {
                    panel.getKMeansButton().setSelected(true);
                    return;
                }
                panel.getDBSCANButton().setSelected(false);
                panel.getAxis().switchIcon(true);
                KMeans = true;
                
            }
        });

        panel.getDBSCANButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (!panel.getDBSCANButton().isSelected()) {
                    panel.getDBSCANButton().setSelected(true);
                    return;
                }
                panel.getKMeansButton().setSelected(false);
                panel.getAxis().switchIcon(false);
                KMeans = false;
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

    private void loadCSV(int CSVNumber) {

        new CSVLoader(CSVNumber, container, panel.getOutData());
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
}