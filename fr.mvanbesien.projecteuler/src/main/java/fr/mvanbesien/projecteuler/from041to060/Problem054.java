package fr.mvanbesien.projecteuler.from041to060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem054 implements Callable<Long> {

	private static enum Suit {
		CLUB, DIAMOND, HEART, SPADE;

		public static Suit get(char c) {
			switch (c) {
			case 'C':
				return CLUB;
			case 'D':
				return DIAMOND;
			case 'H':
				return HEART;
			case 'S':
				return SPADE;
			default:
				return null;
			}
		}
	}

	private static class Card implements Comparable<Card> {

		public Card(String code) {
			this.value = "23456789TJQKA".indexOf(code.charAt(0)) + 2;
			this.suit = Suit.get(code.charAt(1));
		}

		private int value;

		private Suit suit;

		@Override
		public int compareTo(Card arg0) {
			return value - arg0.value;
		}

	}

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem054().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int scoreP1 = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				Problem054.class.getResourceAsStream("/Problem054.txt")));

		while (reader.ready()) {

			// Dealing the cards
			String[] cards = reader.readLine().split(" ");
			Card[] handP1 = new Card[] { new Card(cards[0]), new Card(cards[1]), new Card(cards[2]),
					new Card(cards[3]), new Card(cards[4]) };
			Arrays.sort(handP1);
			Card[] handP2 = new Card[] { new Card(cards[5]), new Card(cards[6]), new Card(cards[7]),
					new Card(cards[8]), new Card(cards[9]) };
			Arrays.sort(handP2);

			// Cheking points

			int royalFlush = getRoyalFlush(handP1) - getRoyalFlush(handP2);
			if (royalFlush == 0) {
				int straightFlush = getStraightFlush(handP1) - getStraightFlush(handP2);
				if (straightFlush == 0) {
					int fourOfAKind = getFourOfAKind(handP1) - getFourOfAKind(handP2);
					if (fourOfAKind == 0) {
						int fullHouse = getFullHouse(handP1) - getFullHouse(handP2);
						if (fullHouse == 0) {
							int flush = getFlush(handP1) - getFlush(handP2);
						if (flush == 0) {
							int straight = getStraight(handP1) - getStraight(handP2);
							if (straight == 0) {
								int threeOfAKind = getThreeOfAKind(handP1) - getThreeOfAKind(handP2);
								if (threeOfAKind == 0) {
									int twoPairs = getTwoPairs(handP1) - getTwoPairs(handP2);
									if (twoPairs == 0) {
										int onePair = getOnePair(handP1) - getOnePair(handP2);
										if (onePair == 0) {
											int highCards = getHighCards(handP1) - getHighCards(handP2);
											scoreP1 += highCards > 0 ? 1 : 0;
										} else
											scoreP1 += onePair > 0 ? 1 : 0;
									} else
										scoreP1 += twoPairs > 0 ? 1 : 0;
								} else
									scoreP1 += threeOfAKind > 0 ? 1 : 0;
							} else
								scoreP1 += straight > 0 ? 1 : 0;
						} else
							scoreP1 += flush > 0 ? 1 : 0;
						} else
							scoreP1 += fullHouse > 0 ? 1 : 0;
					} else
						scoreP1 += fourOfAKind > 0 ? 1 : 0;
				} else
					scoreP1 += straightFlush > 0 ? 1 : 0;
			} else
				scoreP1 += royalFlush > 0 ? 1 : 0;

		}
		return (long) scoreP1;
	}

	private int getRoyalFlush(Card[] hand) {
		if (hand[0].value == 10 && getStraightFlush(hand) > -1)
			return 1;
		return 0;
	}

	private int getStraightFlush(Card[] hand) {
		int flush = getFlush(hand);
		int straight = getStraight(hand);

		if (flush > -1 && straight > -1)
			return straight;
		return 0;
	}

	private int getFourOfAKind(Card[] hand) {
		for (int i = 0; i < 2; i++) {
			if (hand[i].value == hand[i + 1].value && hand[i].value == hand[i + 2].value
					&& hand[i].value == hand[i + 3].value)
				return hand[i].value;
		}
		return 0;
	}

	private int getFullHouse(Card[] hand) {
		if (hand[1].value != hand[2].value) {
			if (hand[0].value == hand[1].value && hand[2].value == hand[3].value && hand[2].value == hand[4].value)
				return 100 * hand[2].value + hand[0].value;
		} else {
			if (hand[0].value == hand[1].value && hand[0].value == hand[2].value && hand[3].value == hand[4].value)
				return 100 * hand[0].value + hand[3].value;
		}
		return 0;
	}

	private int getFlush(Card[] hand) {
		Suit suit = hand[0].suit;
		for (int i = 1; i < hand.length; i++) {
			if (suit != hand[i].suit)
				return 0;
		}
		return 1;
	}

	private int getStraight(Card[] hand) {
		for (int i = 1; i < hand.length; i++)
			if (hand[i].value - hand[i - 1].value != 1)
				return 0;
		return hand[hand.length - 1].value;
	}

	private int getThreeOfAKind(Card[] hand) {
		for (int i = 0; i < 3; i++) {
			if (hand[i].value == hand[i + 1].value && hand[i].value == hand[i + 2].value)
				return hand[i].value;
		}
		return 0;
	}

	private int getTwoPairs(Card[] hand) {
		List<Integer> pairValues = new ArrayList<>();
		for (int i = 1; i < hand.length; i++) {
			if (hand[i - 1].value == hand[i].value)
				pairValues.add(new Integer(hand[i].value));
		}
		int result = 0;
		while (pairValues.size() > 0) {
			Integer max = Collections.max(pairValues);
			result = 100 * result + max;
			pairValues.remove(max);
		}
		return result;
	}

	private int getOnePair(Card[] hand) {
		for (int i = 0; i < 4; i++) {
			if (hand[i].value == hand[i + 1].value)
				return hand[i].value;
		}
		return 0;
	}

	private int getHighCards(Card[] hand) {
		int total = 0;
		for (int i = hand.length - 1;i >= 0;i--) {
			total = total * 100 + hand[i].value;
		}
		return total;
	}

}
