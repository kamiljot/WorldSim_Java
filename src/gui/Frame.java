package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import worldSim.WorldManager;

public class Frame extends JFrame{

    private WorldManager worldManager;

    public WorldManager getWorldManager()
    {
        return worldManager;
    }


    private final SimulatorArea area;

    public Frame(int x, int y, WorldManager worldManager)
    {
        super("Virtual World");
        this.worldManager=worldManager;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(900, 830);
        setLayout(new FlowLayout());
        KeyListenerFrame escExit = new KeyListenerFrame();
        addKeyListener(escExit);
        area = new SimulatorArea(x, y, worldManager);
        add(area);
        area.setBackground(new Color(0, 0, 0));
        area.setLocation(0, 0);
        area.setPreferredSize(new Dimension(700,700));
        setVisible(true);
    }

    public void setFieldText(String text, int x, int y)
    {
        area.setFieldText(text, x, y);
    }

    public void clearSimArea()
    {
        area.clearArea();
    }
}


