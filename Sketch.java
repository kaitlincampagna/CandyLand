import processing.core.PApplet;
import java.awt.event.KeyEvent;

public class Sketch extends PApplet {
  
	boolean start = false;
	int blueX = 90;
	int blueY = 430;
	int redX = 130;
	int redY = 430;
	String colour = "";
	// boolean updateBlue = true;
	// boolean updateRed = true;
	
	int turn = 0;
	
  public Board board = new Board();
  public Player[] humans = new Player[2];
	public Deck deck = new Deck(); //makes the game deck
	
	public void settings() {
  	size(900, 455);
	}

  public void setup() {
		imageMode(CENTER);
    image(loadImage("cover.jpg"), width/2, height/2);
		textSize(50);
		fill(0);
		textAlign(CENTER, CENTER);
		rectMode(CENTER);
		fill(255);
		rect(width/2, height/2, 600, 60, 28);
		fill(0);
		text("Click Here To Begin", width/2, height/2);
    
    deck.shuffleDeck();
    deck.shuffleDeck();
    humans[0] = new Human("Player1", deck, board);
    humans[1] = new Human("Player2", deck, board);
    
  }
  
  
  public void keyPressed(){
    if (keyCode == ENTER){
          turn++;
          System.out.println(turn);
       }
  }
    
  public void draw() {
    if (deck.emptyDeck()){
      deck.refillDeck();
      deck.shuffleDeck();
      deck.shuffleDeck();
    }
		if (mousePressed) {
			if (start && turn%2 == 0) {
        blueX = mouseX;
				blueY = mouseY;
        //if they click on the deck image
        if (mouseX>=810 && mouseX<=900){
          if (mouseY>=370 && mouseY<= 450){
            
            print("blue draw\n");
            //humans[0].drawTop();
						Card topCard = humans[0].drawTop();
            System.out.println(topCard.getCardType());
            displayCard(topCard);
            humans[0].playerPos = humans[0].moveToColour(topCard, humans[0].playerPos);
             humans[0].playerPos = humans[0].bridgePassage(humans[0].playerPos);
             
             System.out.println("/nPos:"+ humans[0].playerPos);
            deck.discardCard(topCard);
            
          }
          
        }
			}

      else if (start && turn%2 == 1) {
				
				redX = mouseX;
				redY = mouseY;
				 
        //if they click on the deck image
        if (mouseX>=810 && mouseX<=900){
          if (mouseY>=370 && mouseY<= 450){
            print("red draw\n");
						Card topCard = humans[1].drawTop();
            System.out.println(topCard.getCardType());
            
            displayCard(topCard);
            
            humans[1].playerPos = humans[1].moveToColour(topCard, humans[1].playerPos);
            humans[1].playerPos = humans[1].bridgePassage(humans[1].playerPos);
            
            System.out.println("/nPos:"+ humans[1].playerPos);
            deck.discardCard(topCard);
            
          }
        }
			}
			start = true;
		}
		if (start) {
    	image(loadImage("board.jpg"), width/2, height/2);
      image(loadImage("pile.png"), 840, 400, 150, 150 );
			displayPlayers();
      if (!colour.equals("")) {
      	image(loadImage(colour + ".jpg"),850 , 310, 80, 60);
			}
      if (humans[0].playerPos >= 133 && humans[0].playerPos <=138){
       image(loadImage("bluewin.jpg"), width/2, height/2, 900, 455);
      }
      if (humans[1].playerPos >= 133 && humans[1].playerPos <=138){
       image(loadImage("redwin.jpg"), width/2, height/2, 900, 455);
      }
			
		}
  }
   
  
  

	public void displayPlayers() {
    image(loadImage("blueplayer.png"), blueX, blueY, 60, 60);
    image(loadImage("redplayer.png"), redX, redY, 60, 60);
		
	}

  public void displayCard(Card topCard) {
		print("card type is " + topCard.getCardType());
    if (topCard.getCardType() == CardType.RED){
      
			colour = "red";
    }
    else if (topCard.getCardType() == CardType.PURPLE){
       
			colour = "purple";
    }
    else if (topCard.getCardType() == CardType.BLUE){
      
			colour = "blue";
    }
    else if (topCard.getCardType() == CardType.GREEN){
      
			colour = "green";
    }
    else if (topCard.getCardType() == CardType.YELLOW){
      
			colour = "yellow";
    }
    else if (topCard.getCardType() == CardType.ORANGE){
      
			colour = "orange";
    }
    else if (topCard.getCardType() == CardType.CANDYCANE){
      
			colour = "candycane";
    }
    else if (topCard.getCardType() == CardType.GUMDROP){
      
			colour = "gumdrop";
    }
    else if (topCard.getCardType() == CardType.LOLLYPOP){
      
			colour = "lolly";
    }
    else if (topCard.getCardType() == CardType.PEANUT){
      
			colour = "peanut";
    }
   
    else if (topCard.getCardType() == CardType.ICECREAM){
      
			colour = "icecream";
    } 
    else if (topCard.getCardType() == CardType.GINGERBREAD){
      
			colour = "gingerbread";
    }
	}
}
