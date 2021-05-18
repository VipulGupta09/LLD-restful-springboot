package com.vipul.model;

import java.util.HashMap;
import java.util.Map;

import com.vipul.exception.InvalidSlotException;
import com.vipul.exception.ParkingLotException;
import com.vipul.exception.SlotAlreadyOccupiedException;

/**
 * Model object to represent the functioning of parking lot.
 */
public class ParkingLot {

	private static int MAX_CAPACITY = 10000;
	private int capacity;
	private Map<Integer, Slot> slots;

	public ParkingLot(int capacity) {
		if (capacity > MAX_CAPACITY || capacity < 1)
			throw new ParkingLotException("Invalid Capacity given for parking lot..");
		this.capacity = capacity;
		this.slots = new HashMap<Integer, Slot>();
	}

	public int getCapacity() {
		return capacity;
	}

	public Map<Integer, Slot> getSlots() {
		return slots;
	}

	/**
	 * Helper method to get the {@link Slot} object for a given slot number. If slot
	 * does not exists, then it will create new slot before giving it back.
	 * 
	 * @param slotNumber Slot number.
	 * @return Slot.
	 */
	private Slot getSlot(final Integer slotNumber) {
		if (slotNumber > MAX_CAPACITY || slotNumber < 1) {
			throw new InvalidSlotException();
		}
		final Map<Integer, Slot> allSlots = getSlots();
		if (!allSlots.containsKey(slotNumber)) {
			allSlots.put(slotNumber, new Slot(slotNumber));
		}
		return allSlots.get(slotNumber);
	}

	/**
	 * Parks a car into a given slot
	 * 
	 * @param car        Car to be parked
	 * @param slotNumber slot number in which it has to be parked
	 * @return {@link Slot} if the parking succeeds. If the slot is already occupied
	 *         then {@link SlotAlreadyOccupiedException} is thrown
	 */
	public Slot park(final Car car, final Integer slotNumber) {
		final Slot slot = getSlot(slotNumber);
		if (!slot.isSlotFree()) {
			throw new SlotAlreadyOccupiedException();
		}
		slot.assignCar(car);
		return slot;
	}

	/**
	 * Makes the slot free from the current parked car.
	 * 
	 * @param slotNumber slot to be freed
	 * @return Freed slot.
	 * 
	 */
	public Slot makeSlotFree(final Integer slotNumber) {
		final Slot slot = getSlot(slotNumber);
		slot.unassignCar();
		return slot;
	}

}
