package com.heroku.rlegendi.pokr.strategies.simple;

/**
 * Package private class for simple strategy hand odds evaluation.
 * 
 * @author rlegendi
 */
class Hand {
	final String hand;
	final String desc;
	final double probabilityOfOccurrence;

	public Hand(final String hand, final String desc,
			final double probabilityOfOccurrence) {
		super();
		this.hand = hand;
		this.desc = desc;
		this.probabilityOfOccurrence = probabilityOfOccurrence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		long temp;
		temp = Double.doubleToLongBits(probabilityOfOccurrence);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Hand other = (Hand) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (Double.doubleToLongBits(probabilityOfOccurrence) != Double
				.doubleToLongBits(other.probabilityOfOccurrence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hand [hand=" + hand + ", desc=" + desc
				+ ", probabilityOfOccurrence=" + probabilityOfOccurrence + "]";
	}
}
