package gui;

import worldSim.WorldManager;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class WorldFieldJPanel extends JPanel{
    private JLabel text;

    public WorldFieldJPanel(int x, int y, WorldManager worldManager)
    {
        RightMouseMenu rightMouseMenu = new RightMouseMenu(x,y,worldManager);
        addMouseListener(rightMouseMenu);
        setBackground(Color.gray);
        text=new JLabel();
        add(text);
    }

    public void clearField()
    {
        text.setText("");
        setBackground(Color.gray);
    }

    public void setText(String newText)
    {
        text.setText(newText);
        setBackground(Color.LIGHT_GRAY);
    }
}

