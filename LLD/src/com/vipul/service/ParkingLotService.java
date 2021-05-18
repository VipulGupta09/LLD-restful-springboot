package com.vipul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vipul.exception.ParkingLotException;
import com.vipul.model.Car;
import com.vipul.model.ParkingLot;
import com.vipul.model.Slot;
import com.vipul.model.parking.strategy.ParkingStrategy;

/**
 * Service for enable the functioning of a parking lot. This will have all the
 * business logic of how the parking service will operate.
 */
public class ParkingLotService {

	private ParkingLot parkingLot;
	private ParkingStrategy parkingStrategy;

	/**
	 * Allots a parking lot into the parking service. Throwns
	 * {@link ParkingLotException} if there is already a parking lot alloted to the
	 * service previously.
	 *
	 * @param parkingLot      Parking lot to be alloted.
	 * @param parkingStrategy Strategy to be used while parking.
	 */
	public void createParkingLot(final ParkingLot parkingLot, final ParkingStrategy parkingStrategy) {
		if (this.parkingLot != null)
			throw new ParkingLotException("Parking Lot already exits.");

		this.parkingLot = parkingLot;
		this.parkingStrategy = parkingStrategy;

		for (int i = 1; i <= parkingLot.getCapacity(); i++) {
			parkingStrategy.addSlot(i);
		}
	}

	/**
	 * Parks a {@link Car} into the parking lot. {@link ParkingStrategy} is used to
	 * decide the slot number and then the car is parked into the {@link ParkingLot}
	 * into that slot number.
	 *
	 * @param car Car to be parked.
	 * @return Slot number in which the car is parked.
	 */
	public Integer park(final Car car) {
		validateParkingLotExists();
		final Integer nextFreeSlot = parkingStrategy.getNextslot();
		parkingLot.park(car, nextFreeSlot);
		parkingStrategy.removeSlot(nextFreeSlot);
		return nextFreeSlot;

	}

	/**
	 * Unparks a car from a slot. Freed slot number is given back to the parking
	 * strategy so that it becomes available for future parkings.
	 *
	 * @param slotNumber Slot number to be freed.
	 */
	public void makeSlotFree(final Integer slotNumber) {
		validateParkingLotExists();
		parkingLot.makeSlotFree(slotNumber);
		parkingStrategy.addSlot(slotNumber);
	}

	/**
	 * Gets the list of all the slots which are occupied.
	 */
	public List<Slot> getOccupiedSlot() {
		validateParkingLotExists();
		final List<Slot> occupiedSlotsList = new ArrayList<Slot>();
		final Map<Integer, Slot> allslots = parkingLot.getSlots();

		for (int i = 1; i < parkingLot.getCapacity(); i++) {
			if (allslots.containsKey(i)) {
				final Slot slot = allslots.get(i);
				if (!slot.isSlotFree()) {
					occupiedSlotsList.add(slot);
				}
			}
		}
		return occupiedSlotsList;
	}

	/**
	 * Helper method to validate whether the parking lot exists or not. This is used
	 * to validate the existence of parking lot before doing any operation on it.
	 */
	private void validateParkingLotExists() {
		if (parkingLot == null)
			throw new ParkingLotException("Parking Lot does not exist to Park.");
	}

	/**
	 * Gets all the slots in which a car with given color is parked.
	 *
	 * @param color Color to be searched.
	 * @return All matching slots.
	 */
	public List<Slot> getSlotsForColor(final String color) {
		final List<Slot> occupiedList = getOccupiedSlot();
		List<Slot> list = occupiedList.stream().filter(slot -> slot.getParkedCar().getColor().equals(color))
				.collect(Collectors.toList());
		return list;
	}

}
