package com.xenoage.gwtwebmidi;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.user.client.DOM;
import com.xenoage.gwtwebmidi.wrapper.MidiAccess;
import com.xenoage.gwtwebmidi.wrapper.MidiInput;
import com.xenoage.gwtwebmidi.wrapper.MidiOutput;
import com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtWebMidiTest
	implements EntryPoint, WebMidiListener {

	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		log("Initializing Web MIDI...");
		//initialize the Web MIDI GWT Wrapper
		//after that, methods from this library can be called by external JS code
		GwtWebMidiWrapper.init(this);
	}


	private void log(String text) {
		PreElement log = PreElement.as(DOM.getElementById("log"));
		log.setInnerHTML(log.getInnerHTML() + text + "<br/>");
	}


	@Override public void onInitSuccess(MidiAccess midiAccess) {
		log("Web MIDI initialized.");
		//list input ports
		log("List of input ports:");
		if (midiAccess.getInputs().size() == 0)
			log("- (None)");
		for (MidiInput mi : midiAccess.getInputs())
			log("- " + mi.port.name);
		//list output ports
		log("List of output ports:");
		if (midiAccess.getOutputs().size() == 0)
			log("- (None)");
		for (MidiOutput mo : midiAccess.getOutputs())
			log("- " + mo.port.name);
		log("Playing a note on output port 0.");
		midiAccess.getOutputs().get(0).send(new int[]{0x90, 0x55, 0x7f}, GwtWebMidi.getPerformanceNow() + 0);
		midiAccess.getOutputs().get(0).send(new int[]{0x80, 0x55, 0x7f}, GwtWebMidi.getPerformanceNow() + 1000);
	}


	@Override public void onInitError(Exception ex) {
		log("Error: " + ex.getMessage());
	}

}
