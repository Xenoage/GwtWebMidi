package com.xenoage.gwtwebmidi.wrapper;

/**
 * Interface for {@link MidiMessageEvent} listeners.
 * 
 * @author Andreas Wenger
 */
public interface MidiInputListener {

	void onMidiMessage(MidiMessageEvent event);
	
}
