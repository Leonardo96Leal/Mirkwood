/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import static gui.Map.COLUMNS;
import static gui.Map.LINES;
import static gui.Map.bkgColor;
import gui.SymbolsMirk;

/**
 *
 * @author UserPL022Pc12
 */
public class LayerWater extends MapLayer {

    int[] waterpos = new int[LINES];
    int col = _rand.nextInt(COLUMNS);
    int lin = _rand.nextInt(LINES);
    public LayerWater() {
        super();
        generateWoter();
        generateWater();
    }

    public void generateWater() {
        //graphics.setForegroundColor(new TextColor.RGB(30, 150, 200));
        for (int i = 0; i < waterpos.length; i++) {
            /*graphics.setBackgroundColor(new TextColor.RGB(30, 150, 100));
            graphics.putString(waterpos[i], i, String.valueOf(SymbolsMirk.WATER[2]));
            graphics.setBackgroundColor(bkgColor);
            graphics.putString(waterpos[i] - 1, i, String.valueOf(SymbolsMirk.WATER[1]));
            graphics.putString(waterpos[i] + 1, i, String.valueOf(SymbolsMirk.WATER[1]));
            graphics.putString(waterpos[i] - 2, i, String.valueOf(SymbolsMirk.WATER[0]));
            graphics.putString(waterpos[i] + 2, i, String.valueOf(SymbolsMirk.WATER[0]));*/
           
            this.objectos[waterpos[i]][i]=new Water2_1();
            this.objectos[waterpos[i]-1][i]=new Water1();
            this.objectos[waterpos[i]+1][i]=new Water1();
            this.objectos[waterpos[i]-2][i]=new Water0();
            this.objectos[waterpos[i]+2][i]=new Water0();
            if(lin==i){
                this.objectos[waterpos[i]][i]=new Ponte();
            }
            
        }
    }


    
    public void generateWoter() {
        
        for (int i = 0; i < LINES; i++) {
            waterpos[i] = col + (_rand.nextInt(2) - 1);
        }
    }

}
