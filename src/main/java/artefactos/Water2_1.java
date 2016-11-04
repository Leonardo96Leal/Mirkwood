/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;
import static gui.Map.LINES;
import gui.SymbolsMirk;

/**
 *
 * @author Trainerpl022
 */
public class Water2_1 extends MapObject {

    TextColor.RGB foreColor = new RGB(51, 102, 255);
    TextColor.RGB bkgColor = new RGB(51, 88, 230);
    public Water2_1() {
        super(SymbolsMirk.WATER[2], null, null);
        setForegroundColor(foreColor);
        setBackgroundColor(bkgColor);
        setWalkthrough(false);
    }

}
