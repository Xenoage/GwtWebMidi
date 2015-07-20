package com.xenoage.gwtwebmidi.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIInput}
 * 
 * @author Andreas Wenger
 */
public final class MidiInput {

	private final JavaScriptObject jsoPort;
	public final MidiPort port;
	
	public List<MidiInputListener> listeners;
	
	
	/**
	 * Constructs a {@link MidiInput} from the given JS counterpart.
	 */
	MidiInput(JavaScriptObject jsoPort) {
		this.jsoPort = jsoPort;
		this.port = new MidiPort(jsoPort);
		this.listeners = new ArrayList<MidiInputListener>();
	}
	
	/**
	 * Registers a listener for input events.
	 * The input port is opened when the first listener is registered.
	 */
	public void addListener(MidiInputListener listener) {
		//on the first listener, open the port
		listenForEvents(jsoPort);
		//register listener
		if (false == listeners.contains(listener))
			listeners.add(listener);
	}
	
	private native void listenForEvents(JavaScriptObject jsoPort) /*-{
		var thisObject = this;
		jsoPort.onmidimessage = function(event) {
			thisObject.@com.xenoage.gwtwebmidi.wrapper.MidiInput::onMidiMessage(*)(event);
		};
	}-*/;

	private void onMidiMessage(JavaScriptObject jso) {
		MidiMessageEvent event = new MidiMessageEvent(jso);
		for (MidiInputListener listener : listeners)
			listener.onMidiMessage(event);
	}
	
	/**
	 * Removes the given listener for input events.
	 */
	public void removeListener(MidiInputListener listener) {
		//remove listener
		listeners.remove(listener);
		//when the last listener was removed, to not listen for events any more
		if (listeners.size() == 0)
			ignoreEvents(jsoPort);
	}
	
	private native void ignoreEvents(JavaScriptObject jsoPort) /*-{
		jsoPort.onmidimessage = null;
	}-*/;

}
