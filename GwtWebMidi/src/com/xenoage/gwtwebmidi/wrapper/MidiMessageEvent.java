package com.xenoage.gwtwebmidi.wrapper;

import static com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper.attrByteArray;
import static com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper.attrDouble;

import java.util.Arrays;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIMessageEvent}
 * 
 * @author Andreas Wenger
 */
public final class MidiMessageEvent {
	
	public final double receivedTime;
	public final byte[] data;
	
	/**
	 * Constructs a {@link MidiMessageEvent} from the given JS counterpart.
	 */
	MidiMessageEvent(JavaScriptObject jso) {
		this.receivedTime = attrDouble(jso, "receivedTime");
		this.data = attrByteArray(jso, "data");
	}

	@Override public String toString() {
		return "MidiMessageEvent [receivedTime=" + receivedTime + ", data=" + Arrays.toString(data) +
			"]";
	}
	
}
