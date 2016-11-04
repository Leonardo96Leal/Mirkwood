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
public class LayerFoes extends MapLayer {

    private final int orcs = 10;
    private final int spider = 10;

    public LayerFoes() {
        generateOrcs();
        generateSpider();
    }

    public void generateOrcs() {
        for (int i = 0; i < orcs; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)] = new script.Orc();
        }
    }
    public void generateSpider() {
        for (int i = 0; i < spider; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)] = new script.Spider();
        }

    }
}
