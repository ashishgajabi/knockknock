package net.readify.knockknock.api.service.impl;

import org.springframework.stereotype.Service;

import net.readify.knockknock.api.service.TriangleType;

/**
 * @author Ashish Gajabi
 * Service to identify type of triangle based on provided dimension
 */
@Service
public class TriangleTypeImpl implements TriangleType {

	@Override
	public String getTriangleType(int a, int b, int c) {
		return getType(a, b, c);
	}

	static String getType(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return Triangle.ERROR.type;
		}
		if (a + b < c || a + c < b || b + c < a) {
			return Triangle.ERROR.type;
		}
		if (a == b && b == c) {
			return Triangle.EQUILATERAL.type;
		} else if ((a == b) || (b == c) || (c == a)) {
			return Triangle.ISOSCELES.type;
		} else if (a != b && b != c && c != a) {
			return Triangle.SCALENE.type;
		} else {
			return Triangle.ERROR.type;
		}
	}

	enum Triangle {
		ISOSCELES("Isosceles"), EQUILATERAL("Equilateral"), SCALENE("Scalene"), ERROR("Error");

		public String type;

		Triangle(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return this.type;
		}
	}
}
