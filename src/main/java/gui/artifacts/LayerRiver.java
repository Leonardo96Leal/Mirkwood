/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.artifacts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import gui.Map;
import static gui.Map.COLUMNS;
import static gui.Map.LINES;
import gui.SymbolsMirk;

/**
 *
 * @author davidsanguinetti
 */
public class LayerRiver extends MapLayer {

    int[] waterpos = new int[LINES];
    TextColor.RGB waterColor = new TextColor.RGB(30, 150, 200);

    public LayerRiver() {
        generateRiver();
    }

    public void generateRiver() {
        //int col = _Rand.nextInt(COLUMNS);
        /*int col = 12;
        for (int i = 0; i < LINES; i++) {
            TerminalPosition tpos = new TerminalPosition(col + (_Rand.nextInt(2) - 1), i);
            addObject(new Water(tpos, Water.WaterType.DEEP));

            TerminalPosition tpos_shore1 = new TerminalPosition(tpos.getColumn() - 1, i);
            addObject(new Water(tpos_shore1, Water.WaterType.SHORE));

            TerminalPosition tpos_shore2 = new TerminalPosition(tpos.getColumn() + 1, i);
            addObject(new Water(tpos_shore2, Water.WaterType.SHORE));

            TerminalPosition tpos_nearshore1 = new TerminalPosition(tpos.getColumn() - 2, i);
            addObject(new Water(tpos_nearshore1, Water.WaterType.NEAR_SHORE));

            TerminalPosition tpos_nearshore2 = new TerminalPosition(tpos.getColumn() + 2, i);
            addObject(new Water(tpos_nearshore2, Water.WaterType.NEAR_SHORE));
        }*/
    }

}
