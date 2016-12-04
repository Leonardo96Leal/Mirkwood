package gui;

import gui.artifacts.Tree;
import java.util.EnumSet;
import java.util.Random;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;
import com.googlecode.lanterna.gui2.ComponentRenderer;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import gui.artifacts.LayerColor;
import gui.artifacts.LayerRiver;
import gui.artifacts.MapLayer;
import gui.artifacts.MapObject;
import gui.artifacts.ViewMap;
import java.util.ArrayList;

import script.Characters;
import script.Foe;
import script.Hero;

public class Map extends Panel {
// mudanca

   public static final int COLUMNS = 256;
   public static final int LINES = 256;
   public static final int COL = 10, LIN = 5;
   public static int colv, linv;
   public static int colf = 0, linf = 0;
   public static int coli = 0, lini = 0;

   public static final int TREECOUNT = 0;
   public static final int BRANCHESCOUNT = 0;

   int[] playerpos = new int[]{2, 2};

   Tree[] treespos = new Tree[TREECOUNT];
   Tree[] branchespos = new Tree[BRANCHESCOUNT];
   public static RGB bkgColor = new TextColor.RGB(165, 127, 61);
   MapObject mo;
   
   ArrayList<MapLayer> _layers;

   Characters _chars;

   EmptySpace land;

   public Map(Characters chars) {
      super();

      /*
                Create the respective layers
       */
      _layers = new ArrayList<MapLayer>();
      _layers.add(new LayerRiver());

      _chars = chars;
      getBasePane();

//		mRand = new Random();
//		generateWater();
      generateTrees();

      land = new EmptySpace(new TextColor.RGB(165, 127, 61)) {
         protected ComponentRenderer<EmptySpace> createDefaultRenderer() {
            return new ComponentRenderer<EmptySpace>() {

               public TerminalSize getPreferredSize(EmptySpace component) {
                  TerminalPosition ppos = _chars.getHero().get_position();
                  while (linf == 0 && colf == 0) {

                     if (ppos.getColumn() + COL < COLUMNS) {
                        colf = ppos.getColumn() + COL;
                     } else {
                        colf = COLUMNS;
                     }

                     if (ppos.getRow() + LIN < LINES) {
                        linf = ppos.getRow() + LIN;
                     } else {
                        linf = LINES;
                     }

                     if (coli == 0 && lini == 0) {
                        if (ppos.getColumn() - COL > 0) {
                           coli = ppos.getColumn() - COL;
                        }
                        if (ppos.getRow() - LIN > 0) {
                           lini = ppos.getRow() - LIN;
                        }
                     }
                  }
                  //System.out.println(TerminalSize.ZERO);
                  //TerminalPosition.TOP_LEFT_CORNER;
                  return new TerminalSize(TerminalPosition.TOP_LEFT_CORNER.getColumn() + Map.colf, TerminalPosition.TOP_LEFT_CORNER.getRow() + Map.linf);

                  //return new TerminalSize(COLUMNS, LINES);
               }

               /*public TerminalSize withRelative() {
                  return new TerminalSize(Map.coli, Map.lini);
               }*/

 /*public ViewMap getMap(EmptySpace component) {
                  TerminalPosition ppos = _chars.getHero().get_position();
                  while (linf == 0 && colf == 0) {
                     linf = ppos.getRow() + 5;
                     colf = ppos.getColumn() + 10;
                  }
                  return new ViewMap(coli, lini, colf, linf);
               }*/
               public void drawComponent(TextGUIGraphics graphics, EmptySpace component) {
                  /*
						 * Fill background
                   */

                  graphics.setBackgroundColor(bkgColor);
                  /*for (int i = 0; i < COLUMNS; i++) {
                     for (int j = 0; j < LINES; i++) {
                        if (i < 124 && j < 124) {
                           
                           TerminalPosition moupos = new TerminalPosition(i, j);
                           graphics.setBackgroundColor(new TextColor.RGB(153, 76, 0));
                        } else if (i > 132 && j > 132 && i < 256 && j < 256) {
                           TerminalPosition ocepos = new TerminalPosition(i, j);
                           graphics.setBackgroundColor(new TextColor.RGB(165, 102, 204));
                        } else if (j > 132 && j < 256 && i < 124) {
                           TerminalPosition lavpos = new TerminalPosition(i, j);
                           graphics.setBackgroundColor(new TextColor.RGB(204, 0, 0));
                        } else if (i > 132 && i < 256 && j < 124) {
                           TerminalPosition despos = new TerminalPosition(i, j);
                           graphics.setBackgroundColor(new TextColor.RGB(204, 204, 0));
                        } else if (i < 124 && j < 124) {
                           TerminalPosition nonpos = new TerminalPosition(i, j);
                           graphics.setBackgroundColor(new TextColor.RGB(128, 128, 128));
                        }
                     }
                  }*/
                  graphics.setModifiers(EnumSet.of(SGR.BOLD));
                  graphics.fill(' ');
                  //new TextColor.RGB(204, 204, 0); //Desert
                  //new TextColor.RGB(153, 76, 0); // Mountain 
                  //new TextColor.RGB(165, 102, 204); //Ocean 
                  //new TextColor.RGB(204, 0, 0); //Lava

                  /*
						 * Creates the trees and branches
                   */
                  for (Tree t : treespos) {
                     graphics.setForegroundColor(t.getColor());
                     graphics.putString(t.getmPosition().getColumn(), t.getmPosition().getRow(), String.valueOf(t.getmTree()));
                  }
                  for (Tree t : branchespos) {
                     graphics.setForegroundColor(t.getColor());
                     graphics.putString(t.getmPosition().getColumn(), t.getmPosition().getRow(), String.valueOf(t.getmTree()));
                  }

                  /*
						 * Creates the objects of layers
                   */
                  for (MapLayer ml : _layers) {
                     for (int i = coli; i < colf; i++) {
                        for (int j = lini; j < linf; j++) {
                           mo = ml.getMaplayer()[i][j];
                           if (mo != null) {
                              graphics.setForegroundColor(mo.getForegroundColor());
                              graphics.setBackgroundColor(mo.getBackgroundColor());
                              graphics.putString(mo.getPosition(), String.valueOf(mo.getSymbol()));
                           }
                        }
                     }
                  }

                  /*
						 * Draw characters
                   */
                  Hero h = _chars.getHero();
                  graphics.setBackgroundColor(h.get_bkgColor());
                  graphics.setForegroundColor(h.get_foregroundColor());
                  graphics.setCharacter(h.get_position(), h.get_face());

                  graphics.setModifiers(EnumSet.of(SGR.BLINK));
                  Foe f = _chars.getFoe();
                  graphics.setBackgroundColor(f.get_bkgColor());
                  graphics.setForegroundColor(f.get_foregroundColor());
                  graphics.setCharacter(f.get_position(), f.get_face());
               }
            };
         }
      };

      addComponent(land);

   }

   public void generateTrees() {
      for (int i = 0; i < TREECOUNT; i++) {
         treespos[i] = Tree.factoryRandomTree(COLUMNS, LINES);
      }

      for (int i = 0; i < BRANCHESCOUNT; i++) {
         branchespos[i] = Tree.factoryRandomBranch(COLUMNS, LINES);
      }
   }

   public void refreshLand() {
      land.invalidate();
   }

   public void updatePlayer(KeyStroke keyStroke) {
      TerminalPosition ppos = _chars.getHero().get_position();
      Hero player = _chars.getHero();
      switch (keyStroke.getCharacter()) {
         case 'w': {
            TerminalPosition npos = new TerminalPosition(ppos.getColumn(), ppos.getRow() - 1);
            if (isPositionAvailable(npos)) {
               player.set_position(npos);
               if (npos.getRow() - LIN < 0) {
                  lini = 0;
                  linf--;
               } else if (npos.getRow() + LIN > LINES) {
                  lini--;
                  linf = LINES;
               } else {
                  lini--;
                  linf--;
               }
            }
            break;
         }
         case 's': {
            TerminalPosition npos = new TerminalPosition(ppos.getColumn(), ppos.getRow() + 1);
            if (isPositionAvailable(npos)) {
               player.set_position(npos);
               if (npos.getRow() - LIN < 0) {
                  lini = 0;
                  linf++;
               } else if (npos.getRow() + LIN >= LINES) {
                  lini++;
                  linf = LINES;
               } else {
                  lini++;
                  linf++;
               }
            }
            break;
         }
         case 'a': {
            TerminalPosition npos = new TerminalPosition(ppos.getColumn() - 1, ppos.getRow());
            if (isPositionAvailable(npos)) {
               player.set_position(npos);
               if (npos.getColumn() - COL < 0) {
                  coli = 0;
                  colf--;
               } else if (npos.getColumn() + COL > COLUMNS) {
                  coli--;
                  colf = COLUMNS;
               } else {
                  coli--;
                  colf--;
               }
            }
            break;
         }

         case 'd': {
            TerminalPosition npos = new TerminalPosition(ppos.getColumn() + 1, ppos.getRow());
            if (isPositionAvailable(npos)) {
               player.set_position(npos);
               if (npos.getColumn() - COL < 0) {
                  coli = 0;
                  colf++;
               } else if (npos.getColumn() + COL > COLUMNS) {
                  coli++;
                  colf = COLUMNS;
               } else {
                  coli++;
                  colf++;
               }
            }
            break;
         }

         default:
            System.out.println(keyStroke.getCharacter().toString());
            break;
      }

      refreshLand();
   }

   private boolean isPositionAvailable(TerminalPosition pos) {
      /*
             * Bounds
       */

      if (pos.getColumn() < 0) {
         return false;
      } else if (pos.getColumn() > COLUMNS - 1) {
         return false;
      } else if (pos.getRow() < 0) {
         return false;
      } else if (pos.getRow() > LINES - 1) {
         return false;
      }

      for (MapLayer ml : _layers) {
         for (int i = coli; i < colf; i++) {
            for (int j = lini; j < linf; j++) {
               MapObject mo = ml.getMaplayer()[i][j];
               if (mo != null) {
                  if (mo.getPosition().getColumn() == pos.getColumn()
                          && mo.getPosition().getRow() == pos.getRow()
                          && !mo.isFree()) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }

   /*
	 * @Override protected void onAfterDrawing(TextGUIGraphics graphics) { //
	 * TODO Auto-generated method stub super.onAfterDrawing(graphics);
	 * graphics.setForegroundColor(TextColor.ANSI.CYAN);
	 * graphics.setBackgroundColor(TextColor.ANSI.BLUE);
	 * graphics.setModifiers(EnumSet.of(SGR.BOLD)); graphics.fill(' ');
	 * graphics.putString(3, 0, "Text GUI in 100% Java"); }
    */
}
