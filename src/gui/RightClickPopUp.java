package gui;

import worldSim.Position;
import worldSim.WorldManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightClickPopUp extends JPopupMenu{
    public int menuLength;

    JMenuItem[] menuItems;

    public RightClickPopUp(int x, int y, WorldManager worldManager)
    {
        this.menuLength = 8;

        menuItems = new JMenuItem[menuLength];
        menuItems[0] = new JMenuItem("Cheetah");
        menuItems[1] = new JMenuItem("Hedgehog");
        menuItems[2] = new JMenuItem("Sheep");
        menuItems[3] = new JMenuItem("Turtle");
        menuItems[4] = new JMenuItem("Wolf");
        menuItems[5] = new JMenuItem("Grass");
        menuItems[6] = new JMenuItem("DeadlyNightshade");
        menuItems[7] = new JMenuItem("Guarana");
        for(int i=0;i<menuLength;i++)
        {
            add(menuItems[i]);
            menuItems[i].addActionListener(new NewOrganismActionListener(x,y,worldManager,menuItems[i].getText()));
        }
    }

}
