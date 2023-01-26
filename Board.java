
/**
 * Board
 */
import java.util.Arrays;

public class Board {
  public CardType[] path = new CardType[138];

  public Board() {
    // // insert specials

    path[8] = CardType.GINGERBREAD;
    path[19] = CardType.CANDYCANE;
    path[41] = CardType.GUMDROP;
    path[68] = CardType.PEANUT;
    path[91] = CardType.LOLLYPOP;
    path[101] = CardType.ICECREAM;

    // // color loop
    int colorIndex = 0;
    for (int i = 0; i < path.length; i++) {
      if (path[i] != null) {
        //System.out.println(path[i]);
        continue;
      }
      path[i] = CardType.values()[colorIndex];
      colorIndex++;
      if (colorIndex > 5) {
        colorIndex = 0;
      }

      //System.out.println(path[i]);
      

    }

    
  }

  //i think we need a function here that takes in players positions and moves them accordingly in the array path.

}