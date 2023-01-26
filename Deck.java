/**
 * Deck
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck{
  private ArrayList<Card> deck = new ArrayList<Card>();
  public ArrayList<Card> discard = new ArrayList<Card>();

  public Deck() {
    for (int i = 0; i < 6; i++){
      for(int j = 0; j < 10; j++){
				this.deck.add(new Card(CardType.values()[i]));
			}
    }
    for (int i = 6; i < 12; i++){
       this.deck.add(new Card(CardType.values()[i]));
    }
  }

  public void printDeck() {
    for (Card card : this.deck) {
      card.printCard();
    }
  }

  /**
   * Draws a card from the deck
   * 
   * @return Card drawn
   */
  public Card drawCard() {
    Card card = this.deck.get(this.deck.size() - 1);
    this.deck.remove(this.deck.size() - 1);
    return card;
  }
  
   /**
   * shuffles the deck arraylist
   * 
   * @return void
   */
  public void shuffleDeck(){
    int iterations = 10 * this.deck.size();
    for (int i = 0; i < iterations; i++) {
      int high = 66;

      Random r = new Random();
      int randomNumber = r.nextInt(high);

      int randomNumber2 = r.nextInt(high);

      Card card1 = this.deck.get(randomNumber);
      this.deck.set(randomNumber, this.deck.get(randomNumber2));
      this.deck.set(randomNumber2, card1);
    }
  }

  public void discardCard(Card topCard) {
    this.discard.add(topCard);//moves the drawn card to the discard pile
  }
   /**
   * checks if the deck is empty
   * 
   * @return boolean
   */

  public boolean emptyDeck(){
    return this.deck.size() == 0;
  }

   /**
   * moves cards from discard arraylist to deck arraylist once deck arraylist is empty
   * 
   * @return void
   */

  public void refillDeck(){
    //moves cards in discard pile to the deck
    for (int i = 0; i < discard.size(); i++){
      this.deck.add(discard.get(i));
    }
    discard.clear();
      
  }






    
  




    
}