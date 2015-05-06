package com.xenoage.gwtwebmidi;

import com.xenoage.gwtwebmidi.wrapper.MidiAccess;


/**
 * Listener for Web MIDI events.
 * 
 * @author Andreas Wenger
 */
public interface WebMidiListener
{
	
	/**
	 * This method is called when access to Web MIDI was requested successfully.
	 * @param midiAccess  the access object to Web MIDI
	 */
	public void onInitSuccess(MidiAccess midiAccess);
	
	
	/**
	 * This method is called when access to Web MIDI was not possible.
	 * @param ex  the error object with further details
	 */
	public void onInitError(Exception ex);

}
