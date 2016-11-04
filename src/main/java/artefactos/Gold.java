/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import gui.Map;
import gui.SymbolsMirk;

/**
 *
 * @author UserPL022Pc12
 */
public class Gold extends MapObject { 
    TextColor.RGB foreColor = new TextColor.RGB(255, 255, 0);
    //TextColor.RGB bkgColor = new TextColor.RGB(51, 88, 230);
    public Gold(){
        super(SymbolsMirk.GOLD, null, null);
        setForegroundColor(foreColor);
        setBackgroundColor(Map.bkgColor);
        setVisible(false);
        //setValor(_rand.nextInt(20));
    }
    
}
