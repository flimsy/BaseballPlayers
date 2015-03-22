public class BaseballPlayer implements Comparable<BaseballPlayer> {

	private int Number;
	private String lastName, firstName;
	private float battingAverage;

	/**
	 * @param number
	 * @param lastName
	 * @param firstName
	 * @param battingAverage
	 */
	public BaseballPlayer(int number, String lastName, String firstName,
			float battingAverage) {
		super();
		Number = number;
		this.lastName = lastName;
		this.firstName = firstName;
		this.battingAverage = battingAverage;
		if (number > 100 || number < 0 || battingAverage > 1
				|| battingAverage < 0) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "BaseballPlayer [Number=" + Number + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", battingAverage="
				+ battingAverage + "]";
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return Number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		Number = number;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the battingAverage
	 */
	public float getBattingAverage() {
		return battingAverage;
	}

	/**
	 * @param battingAverage
	 *            the battingAverage to set
	 */
	public void setBattingAverage(float battingAverage) {
		this.battingAverage = battingAverage;
	}


	@Override
	public int compareTo(BaseballPlayer other) {
		  if (other.lastName.equals(lastName)) {
	            return firstName.compareToIgnoreCase(other.firstName);
	        }
	        return lastName.compareToIgnoreCase(other.lastName);
	}

}
