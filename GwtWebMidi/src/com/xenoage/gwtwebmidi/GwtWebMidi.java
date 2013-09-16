package com.xenoage.gwtwebmidi;

import com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper;



/**
 * Main class of the Xenoage Web MIDI GWT Library.
 * 
 * @author Andreas Wenger
 */
public class GwtWebMidi {
	
	/**
	 * Initializes the Web MIDI GWT library. Call this method before using any
	 * methods in this class.
	 * @param listener  The listener which is notified about success or failure
	 */
	public static void init(WebMidiListener listener) {
		GwtWebMidiWrapper.init(listener);
	}
	
	
	/**
	 * Gets the value of window.performance.now().
	 */
	public static native double getPerformanceNow() /*-{
		return window.performance.now();
	}-*/ ;
	

}
