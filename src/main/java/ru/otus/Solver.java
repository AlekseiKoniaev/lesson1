package ru.otus;

public class Solver {
	private static final Double EPSILON = 1.0e-10;

	public static Double[] solve(Double a, Double b, Double c) {

		if (
				a.equals(Double.NaN)
						|| b.equals(Double.NaN)
						|| c.equals(Double.NaN)
						|| a.equals(Double.NEGATIVE_INFINITY)
						|| b.equals(Double.NEGATIVE_INFINITY)
						|| c.equals(Double.NEGATIVE_INFINITY)
						|| a.equals(Double.POSITIVE_INFINITY)
						|| b.equals(Double.POSITIVE_INFINITY)
						|| c.equals(Double.POSITIVE_INFINITY)
						|| (a < EPSILON && a > -EPSILON)
		) {
			throw new IllegalArgumentException();
		}

		double discriminant = b * b - 4 * a * c;

		if (discriminant < -EPSILON) {
			return new Double[0];
		}

		if (discriminant < EPSILON && discriminant > -EPSILON) {
			double x = -b / (2 * a);
			return new Double[]{x, x};
		}

		if (discriminant > EPSILON) {
			double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
			return new Double[]{x1, x2};
		}

		return null;
	}
}
