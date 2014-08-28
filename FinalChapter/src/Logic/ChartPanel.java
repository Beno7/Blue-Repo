/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Win 7
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartPanel extends JPanel {

    private double[] values;

    private String[] names;

    private String title;

    public ChartPanel(double[] v, String[] n, String t) {
        names = n;
        values = v;
        title = t;
    }

    public ChartPanel() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (values == null || values.length == 0) {
            return;
        }
        double minValue = 0;
        double maxValue = 0;
        for (int i = 0; i < values.length; i++) {
            if (minValue > values[i]) {
                minValue = values[i];
            }
            if (maxValue < values[i]) {
                maxValue = values[i];
            }
        }

        Dimension d = getSize();
        int clientWidth = d.width;
        int clientHeight = d.height;
        int barWidth = clientWidth / values.length;

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

        int titleWidth = titleFontMetrics.stringWidth(title);
        int y = titleFontMetrics.getAscent();
        int x = (clientWidth - titleWidth) / 2;
        g.setFont(titleFont);
        g.drawString(title, x, y);

        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue) {
            return;
        }
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        y = clientHeight - labelFontMetrics.getDescent();
        g.setFont(labelFont);

        for (int i = 0; i < values.length; i++) {
            int valueX = i * barWidth + 1;
            int valueY = top;
            int height = (int) (values[i] * scale);
            if (values[i] >= 0) {
                valueY += (int) ((maxValue - values[i]) * scale);
            } else {
                valueY += (int) (maxValue * scale);
                height = -height;
            }

            g.setColor(Color.GREEN);
            g.fillRect(valueX, valueY, barWidth - 2, height);
            g.setColor(Color.black);
            g.drawRect(valueX, valueY, barWidth - 2, height);
            int labelWidth = labelFontMetrics.stringWidth(names[i]);
            x = i * barWidth + (barWidth - labelWidth) / 2;
            g.drawString(names[i], x, y);
        }
    }

    public void start(ArrayList<Item> b, ArrayList<Integer> count) {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        double[] values = new double[0];
        String[] names = new String[0];
        switch(b.size()){
            case 0:
                values = new double[0];
                names = new String[0];
                break;
            case 1:
                values = new double[1];
                names = new String[1];
                break;
            case 2:
                values = new double[2];
                names = new String[2];
                break;
            case 3:
                values = new double[3];
                names = new String[3];
                break;
            case 4:
                values = new double[4];
                names = new String[4];
                break;
            case 5:
                values = new double[5];
                names = new String[5];
                break;
        }
        int max = count.get(0);
        for (int i = 0; i < b.size(); i++) {
            values[i] = count.get(i);
            names[i] = b.get(i).getName()+" "+b.get(i).getBrandName();
        }

        f.getContentPane().add(new ChartPanel(values, names, "Fast Moving Products"));

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        f.addWindowListener(wndCloser);
        f.setVisible(true);

    }

   // public static void main(String[] argv) {
       // ChartPanel ch = new ChartPanel();
        //ch.start();
   // }
}
