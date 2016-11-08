/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;


import static gui.Map.LINES;


/**
 *
 * @author UserPL022Pc12
 */
public class LayerOrcs extends MapLayer {
    
    public LayerOrcs() {
        super();
        generateOrcs();
    }
    public void generateOrcs(){
         for(int i=0;i<LINES;i++){
             if(i%2 ==0){
            this.objectos[4][i]=new script.Orc();
             }}
    }
}
