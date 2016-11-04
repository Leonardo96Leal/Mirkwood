/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import static gui.Map.COLUMNS;
import static gui.Map.LINES;

/**
 *
 * @author UserPL022Pc12
 */
public class LayerGold extends MapLayer {
    int gold=15;
    public LayerGold(){
        for (int i = 0; i < gold; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)]=new Gold();
        }
    }
    
}
