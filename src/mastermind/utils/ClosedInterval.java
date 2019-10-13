package mastermind.utils;

class ClosedInterval {

	private int min;

	private int max;

	ClosedInterval(int min, int max) {
		assert min <= max;
		this.min = min;
		this.max = max;
	}

	boolean includes(int value) {
		return this.min <= value && value <= this.max;
	}

}
