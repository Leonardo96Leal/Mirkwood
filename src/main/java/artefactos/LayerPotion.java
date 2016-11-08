/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import static gui.Map.COLUMNS;
import static gui.Map.LINES;
import static gui.Map.TREECOUNT;

/**
 *
 * @author UserPL022Pc12
 */
public class LayerPotion extends MapLayer {
    public LayerPotion(){
        super();
        generatePotion();
    }
    public void generatePotion(){
        for(int i=0;i<10;i++){

            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)]=new Potion();
        }
    }
}
