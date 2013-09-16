package com.xenoage.gwtwebmidi.wrapper;

/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIPortType}
 * 
 * @author Andreas Wenger
 */
public enum MidiPortType {
	Input,
	Output;
	
	
	public static MidiPortType fromString(String s) {
		for (MidiPortType v : values())
			if (v.toString().equalsIgnoreCase(s))
				return v;
		return null;
	}
	
}
