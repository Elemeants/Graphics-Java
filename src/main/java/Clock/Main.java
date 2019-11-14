package Clock;

import java.awt.BasicStroke;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import static java.awt.geom.Arc2D.OPEN;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {
    private JPanel contentPane;
    private Clock clock;
    private Graphics2D grphs;
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public Main() {
        this.clock = new Clock(new ClockData(23, 55, 40));
        clock.setClockCallback((ClockData data) -> {
            System.out.println(data.toString());
            this.repaint();
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clock");
        setResizable(false);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
    }
    
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        grphs = (Graphics2D) g;
        
        ConfigGraphics();
        DrawSeconds();
        DrawMinutes();
        DrawHours();
    }
    
    public void ConfigGraphics() {
        grphs.setColor(WHITE);
        grphs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        grphs.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        grphs.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        grphs.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        grphs.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        grphs.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        grphs.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        grphs.setStroke(new BasicStroke(10));
    }
    
    private void DrawSeconds() {
        double angle = (double)6 * (clock.getData().getSeconds() + 1);
        Shape arc = new Arc2D.Double(125, 125, 200, 200, 0, angle, OPEN);
        grphs.draw(arc);
    }
    
    private void DrawMinutes() {
        double angle = (double)6 * clock.getData().getMinutes();
        Shape arc = new Arc2D.Double(100, 100, 250, 250, 0, angle, OPEN);
        grphs.draw(arc);
    }
    
    private void DrawHours(){
        double angle = (double)15 * clock.getData().getHours();
        Shape arc = new Arc2D.Double(75, 75, 300, 300, 0, angle, OPEN);
        grphs.draw(arc);
    }
} 
