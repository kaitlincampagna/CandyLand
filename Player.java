/**
 * Player
 */

import java.util.ArrayList;

public abstract class Player{
  public String name;
  protected Deck deck;
	private Board board;
  public int playerPos = 0;
  
  public static ArrayList<Player> players = new ArrayList<Player>();

  public Player(String name, Deck deck, Board board) {
    this.name = name;
    this.deck = deck;
		this.board = board;

    Player.players.add(this);
  }

  /**
   * Draws top card from deck
   * 
   */
  public Card drawTop() {
    Card topCard = this.deck.drawCard();
    return topCard;
  }
  
  
  
  public int moveToSpecialSpot(Card topCard){
  //if special card is drawn, player is moved to appropriate location in the path array 
    if (topCard.getCardType() == CardType.GINGERBREAD){
      playerPos = 8;
    }
    else if (topCard.getCardType() == CardType.CANDYCANE){
      playerPos = 19;
    }
    else if (topCard.getCardType() == CardType.GUMDROP){
      playerPos = 41;
    }
    else if (topCard.getCardType() == CardType.PEANUT){
      playerPos = 68;
    }
    else if (topCard.getCardType() == CardType.LOLLYPOP){
      playerPos = 91;
    }
    else if (topCard.getCardType() == CardType.ICECREAM){
      playerPos = 101;
    }
    return playerPos;
  }
  
   public int bridgePassage(int playerPos){
     //if a player is at a certain spot in the array, they will cross the bridge and move to a different spot in the array.
     if (playerPos == 4){
       playerPos = 58; //rainbow trail
     }
     else if (playerPos == 34){
       playerPos = 44; //gumdrop pass
     }
     return playerPos; 
   }
  


  

  public int moveToColour(Card topCard, int playerPos){
    for (int i = playerPos; i <= 138; i++){
      if (topCard.getCardType() == CardType.GINGERBREAD){
      playerPos = 8;
      break;
      }
      else if (topCard.getCardType() == CardType.CANDYCANE){
        playerPos = 19;
        break; 
      }
      else if (topCard.getCardType() == CardType.GUMDROP){
        playerPos = 41;
        break;
      }
      else if (topCard.getCardType() == CardType.PEANUT){
        playerPos = 68;
        break;
      }
      else if (topCard.getCardType() == CardType.LOLLYPOP){
        playerPos = 91;
        break;
      }
      else if (topCard.getCardType() == CardType.ICECREAM){
        playerPos = 101;
        break;
      }
      else if (topCard.getCardType() == board.path[i]){
        playerPos = i;
        break;
      }
    }
		return playerPos;
  }

  public boolean winSquare(int playerPos){
    //checks if a player has made it to the final rainbow square
    return playerPos == 133;
  }
	
  public abstract void getMove();




  

  

  
}