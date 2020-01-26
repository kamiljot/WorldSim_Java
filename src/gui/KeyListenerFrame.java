package gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import worldSim.DifferentWorldSizeException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListenerFrame implements KeyListener{
    @Override
    public void keyPressed(KeyEvent event)
    {
        Frame father=(Frame)event.getSource();
        switch (event.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
                father.dispose();
                return;

            case KeyEvent.VK_S:
            {
                try {
                    father.getWorldManager().save();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(KeyListenerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case KeyEvent.VK_L:
            {
                try {
                    father.getWorldManager().load();
                } catch (DifferentWorldSizeException ex) {
                    Logger.getLogger(KeyListenerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case KeyEvent.VK_SPACE:
                father.getWorldManager().newTurn();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent event)
    {

    }

    @Override
    public void keyTyped(KeyEvent event)
    {

    }
}
