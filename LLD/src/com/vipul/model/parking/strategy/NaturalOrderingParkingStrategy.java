package com.vipul.model.parking.strategy;

import java.util.TreeSet;

import com.vipul.exception.NoFreeSlotAvailableException;

/**
 * Parking strategy in which the natural ordering numbers are used for deciding
 * the slot numbers. For example, 1st car will be parked in slot 1, then next in
 * slot 2, then in slot 3, and so on.
 */
public class NaturalOrderingParkingStrategy implements ParkingStrategy {

	TreeSet<Integer> slotTreeSet;

	public NaturalOrderingParkingStrategy() {
		this.slotTreeSet = new TreeSet<>();
	}

	public NaturalOrderingParkingStrategy(TreeSet<Integer> slotTreeSet) {
		this.slotTreeSet = slotTreeSet;
	}

	@Override
	public void addSlot(Integer slotNumber) {
		this.slotTreeSet.add(slotNumber);

	}

	@Override
	public void removeSlot(Integer slotNumber) {
		this.slotTreeSet.remove(slotNumber);

	}

	@Override
	public Integer getNextslot() {
		if (slotTreeSet.isEmpty()) {
			throw new NoFreeSlotAvailableException();
		}
		return this.slotTreeSet.first();
	}

}
