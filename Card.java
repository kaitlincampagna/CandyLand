/**
 * Card
 */

public class Card {
  
  private CardType type;
  
  //constructor
  public Card (CardType type){
    this.type = type;
  }
   /**
   * prints card just for testing purposes
   * 
   * @return void
   */
  public void printCard(){
    System.out.printf("Card(colour= %s)\n",type);
  }
 /**
   * gets the type of card 
   * 
   * @return CardType
   */
  public CardType getCardType(){
    return type;
  }
  
}