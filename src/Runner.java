import javax.swing.JFrame;
public class Runner
{
    public static void main(String args[])
    {
        Grid game = new Grid();
        JFrame frame = new JFrame("EngHack Game");
        
        frame.add(game);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

