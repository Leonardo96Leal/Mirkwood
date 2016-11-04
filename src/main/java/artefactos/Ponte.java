/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import gui.SymbolsMirk;

/**
 *
 * @author UserPL022Pc12
 */
public class Ponte extends MapObject {
    TextColor.RGB bkgColor = new TextColor.RGB(51, 88, 230);
    TextColor.RGB foreColor = new TextColor.RGB(255, 255, 255);
    public Ponte(){
        super(SymbolsMirk.PONTE, null, null);
        setBackgroundColor(bkgColor);
        setForegroundColor(foreColor);
    }
    
}
