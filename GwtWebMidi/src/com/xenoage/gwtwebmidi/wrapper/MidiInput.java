package com.xenoage.gwtwebmidi.wrapper;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIInput}
 * 
 * @author Andreas Wenger
 */
public final class MidiInput {

	//TODO EventHandler onmidimessage;
	public final MidiPort port;
	
	
	/**
	 * Constructs a {@link MidiInput} from the given JS counterpart.
	 */
	MidiInput(JavaScriptObject jso) {
		this.port = new MidiPort(jso);
	}
	
}
