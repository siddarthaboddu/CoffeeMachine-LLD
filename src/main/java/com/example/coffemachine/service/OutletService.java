package com.example.coffemachine.service;

import com.example.coffemachine.exception.InvalidOutletException;
import com.example.coffemachine.exception.OutletInUseException;
import com.example.coffemachine.exception.OutletNotInUseException;

/**
 * controls outlets
 * @author siddu
 *
 */
public class OutletService {

	boolean[] outlets;

	public OutletService(long outletCount) {
		outlets = new boolean[(int)outletCount + 1];
	}

	/**
	 * acquires the specified outlet
	 * @param outlet is the {@link Integer} which is the number of {@code outlet}
	 * @return {@code true} when acquired specified outlet
	 * @throws InvalidOutletException when passed outlet value is invalid
	 * @throws OutletInUseException trying to acquire already acquired outlet
	 */
	public synchronized void acquireOutlet(int outlet) {
		if (outlet < 1 || outlet >= outlets.length) {
			throw new InvalidOutletException("Invalid Outlet : " + outlet);
		}
		if (outlets[outlet]) {
			throw new OutletInUseException("Outlet in use : " + outlet);
		}

		outlets[outlet] = true;
	}

	/**
	 * releases the specified outlet, so it can be acquired again
	 * @param outlet is the {@link Integer} which is the number of {@code outlet}
	 * @throws InvalidOutletException when passed outlet value is invalid
	 * @throws  OutletNotInUseException when trying to release already released outlet
	 */ 
	public synchronized void releaseOutlet(int outlet) {
		if (outlet < 1 || outlet > outlets.length) {
			throw new InvalidOutletException("Invalid Outlet : " + outlet);
		}
		if (!outlets[outlet]) {
			throw new OutletNotInUseException("Outlet not in use : " + outlet);
		}

		outlets[outlet] = false;

	}
}
