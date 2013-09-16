package com.xenoage.gwtwebmidi.wrapper;

import static com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper.attrString;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIPort}
 * 
 * @author Andreas Wenger
 */
public final class MidiPort {
	
	public final String id;
	public final String manufacturer;
	public final String name;
	public final MidiPortType type;
	public final String version;
  //public final EventHandler ondisconnect;
	
	
	/**
	 * Constructs a {@link MidiPort} from the given JS counterpart.
	 */
	MidiPort(JavaScriptObject jso) {
		this.id = attrString(jso, "id");
		this.manufacturer = attrString(jso, "manufacturer");
		this.name = attrString(jso, "name");
		this.type = MidiPortType.fromString(attrString(jso, "type"));
		this.version = attrString(jso, "version");
	}

}
