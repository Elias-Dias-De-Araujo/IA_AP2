package javaff.search;

import javaff.planning.State;
import java.util.Comparator;
import java.math.BigDecimal;

public class HGValueComparator implements Comparator {
	public int compare(Object obj1, Object obj2) {
		int r = 0;
		if ((obj1 instanceof State) && (obj2 instanceof State)) {
			State s1 = (State) obj1;
			State s2 = (State) obj2;
			BigDecimal d1 = s1.getHValue().add(s1.getGValue());
			BigDecimal d2 = s2.getHValue().add(s2.getGValue());
	
			r = d1.compareTo(d2);

			if (r == 0)
			{
				if (s1.hashCode() > s2.hashCode()) r = 1;
				else if (s1.hashCode() == s2.hashCode() && s1.equals(s2)) r=0;
				else r = -1;
			}
		}
		return r;
	}
}
