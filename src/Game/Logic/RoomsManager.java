package Game.Logic;

import javax.swing.*;

public class RoomsManager {
    private ImageIcon bgThemeplate = new ImageIcon("src/Game/Sources/Rooms/Themeplate_Rooms.png");
    public ImageIcon CurrentRoom;
    public RoomsManager(){
        this.CurrentRoom = this.bgThemeplate;
    }
}
