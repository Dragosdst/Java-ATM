package list.person;

import java.util.ArrayList;
import java.util.List;

class Adult extends Person {
    private List<Card> carduri;

    public Adult(String name) {
        super(name);
        this.carduri = new ArrayList<>();
    }

    public void addCard(Card card) {
        carduri.add(card);
    }

    public List<Card> getCarduri() {
        return carduri;
    }

    public boolean hasCards() {
        return !this.carduri.isEmpty();
    }

    public List<Card> getCards() {
        return this.carduri;
    }

    public void createCard(String cardName) {
        Card newCard = new Card(cardName);
        this.addCard(newCard);
    }

    public Card getCardByName(String cardName) {
        for (Card card : carduri) {
            if (card.getNume().equals(cardName)) {
                return card;
            }
        }
        return null;
    }
}
