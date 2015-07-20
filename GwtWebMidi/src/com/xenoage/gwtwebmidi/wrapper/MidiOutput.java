package com.xenoage.gwtwebmidi.wrapper;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIOutput}
 * 
 * @author Andreas Wenger
 */
public final class MidiOutput {
	
	private final JavaScriptObject jso;
	public final MidiPort port;

	
	/**
	 * Constructs a {@link MidiOutput} from the given JS counterpart.
	 */
	MidiOutput(JavaScriptObject jso) {
		this.jso = jso;
		this.port = new MidiPort(jso);
	}
	
	public void send(int[] data) {
		send(data, 0);
	}

	public void send(int[] data, double timestamp) {
		if (data.length == 3) //TODO: at the moment, we support only messages with 3 bytes (problem with GWT types) 
			jsSend(jso, data[0], data[1], data[2], timestamp);
	}
	
	public native void jsSend(JavaScriptObject jso, int data1, int data2, int data3, double timestamp) /*-{
		jso.send(new Uint8Array([data1, data2, data3]), timestamp);
	}-*/;

}
