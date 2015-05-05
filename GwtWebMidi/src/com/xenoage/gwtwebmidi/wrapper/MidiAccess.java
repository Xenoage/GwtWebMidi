package com.xenoage.gwtwebmidi.wrapper;

import static com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper.call;
import static com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper.get;
import static com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper.length;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * See {@link http://webaudio.github.io/web-midi-api/#idl-def-MIDIAccess}.
 * 
 * @author Andreas Wenger
 */
public final class MidiAccess {
	
	private List<MidiInput> inputs = new ArrayList<MidiInput>();
	private List<MidiOutput> outputs = new ArrayList<MidiOutput>();
	
	
	/**
	 * Constructs a {@link MidiAccess} from the given JS counterpart.
	 */
	MidiAccess(JavaScriptObject jso) {
		//list input ports
		JavaScriptObject jsInputs = get(jso, "inputs");
		for (int i = 0; i < length(jsInputs); i++)
			inputs.add(new MidiInput(call(jsInputs, "get", i))); //TODO: key may be anything, not just 0,1,2...
		//list output ports
		JavaScriptObject jsOutputs = get(jso, "outputs");
		for (int i = 0; i < length(jsOutputs); i++)
			outputs.add(new MidiOutput(call(jsOutputs, "get", i))); //TODO: key may be anything, not just 0,1,2...
	}
	
	
	public List<MidiInput> getInputs() {
		return inputs;
	}
	
	
	public List<MidiOutput> getOutputs() {
		return outputs;
	}
	
	
	public MidiInput getInput(int port) {
		throw new UnsupportedOperationException();
	}
	
	
	public MidiOutput getOutput(int port) {
		throw new UnsupportedOperationException();
	}

}
