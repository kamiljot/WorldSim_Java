package worldSim;

import java.awt.EventQueue;

public class VirtualWorldMain {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WorldManager(20,20);
            }
        });
    }

}
