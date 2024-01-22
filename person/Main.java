package list.person;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Adult dragos = createPerson();

        while (true) {
            System.out.println("---------- Meniu ----------");
            System.out.println("1. Alege card");
            System.out.println("2. Iesire");
            System.out.print("Alege o optiune: ");
            int optiune = scanner.nextInt();

            if (optiune == 1) {
                Card cardSelectat = selectCard(dragos);

                if (cardSelectat == null) {
                    continue;
                }

                System.out.println("---------- Operatiuni ----------");
                System.out.println("1. Retragere");
                System.out.println("2. Depunere");
                System.out.println("3. Verificare sold");
                System.out.print("Alege o operatiune: ");
                int optiuneOperatiune = scanner.nextInt();

                executeOperation(cardSelectat, optiuneOperatiune);
            } else if (optiune == 2) {
                break;
            } else {
                System.out.println("Optiune invalida!");
            }
        }

        scanner.close();
    }

    private static Adult createPerson() {
        Card ing = new Card("ING");
        Card brd = new Card("BRD");

        Adult dragos = new Adult("Dragos");
//        dragos.addCard(ing);
//        dragos.addCard(brd);

        return dragos;
    }

    private static Card selectCard(Adult person) {
        if (!person.hasCards()) {
            System.out.println("Nu ai niciun card. Vrei să creezi unul? (y/n)");
            char choice = scanner.next().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                System.out.print("Introdu numele cardului: ");
                String cardName = scanner.next();
                person.createCard(cardName);
                System.out.print("Introdu suma pe care vrei să o depui în cardul nou: ");
                double suma = scanner.nextDouble();
                person.getCardByName(cardName).depunere(suma);
                System.out.println("Card creat și sumă depusă cu succes!");
            }
            return null;
        }

        int index = 1;
        for (Card card : person.getCards()) {
            System.out.println(index + ". " + card.getNume());
            index++;
        }
        System.out.print("Alege cardul: ");
        int optiuneCard = scanner.nextInt();
        if (optiuneCard > 0 && optiuneCard <= person.getCards().size()) {
            return person.getCards().get(optiuneCard - 1);
        } else {
            System.out.println("Optiune invalida!");
            return null;
        }
    }

    private static void executeOperation(Card card, int option) {
        switch (option) {
            case 1:
                System.out.print("Introdu suma pe care vrei să o retragi: ");
                double sumaRetragere = scanner.nextDouble();
                if (card.plata(sumaRetragere)) {
                    System.out.println("Retragere efectuata cu succes!");
                } else {
                    System.out.println("Fondurile tale sunt insuficiente. Suma disponibila este: " + card.verificareCont());
                }
                break;
            case 2:
                System.out.print("Introdu suma pe care vrei să o depui: ");
                double sumaDepunere = scanner.nextDouble();
                card.depunere(sumaDepunere);
                System.out.println("Depunere efectuata cu succes!");
                break;
            case 3:
                System.out.println("Soldul cardului este: " + card.verificareCont());
                break;
            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }
}
