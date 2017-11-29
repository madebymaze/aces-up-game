package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static models.Suit.*;

public class Card implements Serializable {
    public final int value;
    public final Suit suit;
    public final String htmlString;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit, @JsonProperty("htmlString") String htmlString) {
        this.value = value;
        this.suit = suit;
        this.htmlString = htmlString;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String str = "";
        switch (value) {
            case 11:
                str = "J ";
                break;
            case 12:
                str = "Q ";
                break;
            case 13:
                str = "K ";
                break;
            case 14:
                str = "A ";
                break;
            default:
                str = value + " ";
                break;
        }
        switch (suit) {
            case Hearts:
                str = str + "\u2665";
                break;
            case Spades:
                str = str + "\u2660";
                break;
            case Diamonds:
                str = str + "\u2666";
                break;
            case Clubs:
                str = str + "\u2663";
                break;
        }
        return str;
    }

    public static String getHtmlString(int value, Suit suit) {
        String str = "";
        if (suit == Suit.Hearts) {
            str += "<span class=\"redCard\">\u2665</span>";

        } else if (suit == Suit.Spades) {
            str += "<span class=\"blackCard\">\u2660</span>";

        } else if (suit == Suit.Diamonds) {
            str += "<span class=\"redCard\">\u2666</span>";

        } else if (suit == Suit.Clubs) {
            str += "<span class=\"blackCard\">\u2663</span>";

        } else if (suit == Suit.Coins) {
            str += "<span class=\"blackCard\">\u2663</span>";

        } else if (suit == Suit.Cups) {
            str += "<span class=\"blackCard\">\u2663</span>";

        } else if (suit == Suit.Swords) {
            str += "<span class=\"blackCard\">\u2663</span>";

        } else if (suit == Suit.Jokers) {
            str += "<span class=\"blackCard\">\u2663</span>";

        }

    str += "<sub class=\"cardID\">";
        if (value == 11) {
            str += "J";

        } else if (value == 12) {
            str += "Q";

        } else if (value == 13) {
            str += "K";

        } else if (value == 14) {
            str += "A";

        } else {
            str += value;

        }
    str += "</sub>";

    return str;

    }
}
