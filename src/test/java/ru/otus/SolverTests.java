package ru.otus;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SolverTests {

	@Test
	void solve_noRoots() {
		Double[] result = Solver.solve(1.0, 0.0, .01);
		assertArrayEquals(new Double[0], result);
	}

	@Test
	void solve_oneRoot() {
		Double[] result = Solver.solve(1.0, 0.0, -1.0);
		assertArrayEquals(new Double[]{1.0, -1.0}, result);
	}

	@Test
	void solve_twoRoots() {
		Double[] result = Solver.solve(1.0, 2.0, 1.0 - 1.0e-15);
		assertArrayEquals(new Double[]{-1.0, -1.0}, result);
	}


	@Test
	void solve_aCoefficientNotNull() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(0.0, 1.0, 1.0));
	}

	@Test
	void solve_aCoefficientNotNaN() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(Double.NaN, 1.0, 1.0));
	}

	@Test
	void solve_aCoefficientNotPositiveInfinity() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(Double.POSITIVE_INFINITY, 1.0, 1.0));
	}

	@Test
	void solve_aCoefficientNotNegativeInfinity() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(Double.NEGATIVE_INFINITY, 1.0, 1.0));
	}


	@Test
	void solve_bCoefficientNotNaN() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(1.0, Double.NaN, 1.0));
	}

	@Test
	void solve_bCoefficientNotPositiveInfinity() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(1.0, Double.POSITIVE_INFINITY, 1.0));
	}

	@Test
	void solve_bCoefficientNotNegativeInfinity() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(1.0, Double.NEGATIVE_INFINITY, 1.0));
	}


	@Test
	void solve_cCoefficientNotNaN() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(1.0, 1.0, Double.NaN));
	}

	@Test
	void solve_cCoefficientNotPositiveInfinity() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(1.0, 1.0, Double.POSITIVE_INFINITY));
	}

	@Test
	void solve_cCoefficientNotNegativeInfinity() {
		assertThrows(IllegalArgumentException.class, () -> Solver.solve(1.0, 1.0, Double.NEGATIVE_INFINITY));
	}
}
