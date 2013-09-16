package com.xenoage.gwtwebmidi.wrapper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.xenoage.gwtwebmidi.WebMidiListener;


/**
 * This class provides access to the Web MIDI API.
 * 
 * @author Andreas Wenger
 */
public class GwtWebMidiWrapper {

	private static WebMidiListener listener;


	/**
	 * Initializes the Web MIDI API wrapper.
	 * @param listener  The listener which is notified about success or failure
	 */
	public static void init(WebMidiListener listener) {
		GwtWebMidiWrapper.listener = listener;
		initJS();
	}


	/**
	 * Registers some Java methods on the DOM document, so that they can be
	 * called from the JS side, and then inits Web MIDI.
	 */
	public static native void initJS() /*-{
		//navigator.requestMIDIAccess() callbacks
		$wnd.onRequestMidiSuccess = $entry(@com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper::onRequestMidiSuccess(Lcom/google/gwt/core/client/JavaScriptObject;));
		$wnd.onRequestMidiError = $entry(@com.xenoage.gwtwebmidi.wrapper.GwtWebMidiWrapper::onRequestMidiError(Lcom/google/gwt/core/client/JavaScriptObject;));
		//init Web MIDI
		$wnd.navigator.requestMIDIAccess().then($wnd.onRequestMidiSuccess, $wnd.onRequestMidiError);
	}-*/;


	/**
	 * Success callback for <code>navigator.requestMIDIAccess()</code>.
	 */
	public static void onRequestMidiSuccess(JavaScriptObject jso) {
		MidiAccess midiAccess = new MidiAccess(jso);
		if (listener != null)
			listener.onInitSuccess(midiAccess);
	}


	/**
	 * Error callback for <code>navigator.requestMIDIAccess()</code>.
	 */
	public static void onRequestMidiError(JavaScriptObject error) {
		if (listener != null)
			listener.onInitError(error);
	}
	
	
	public static native JavaScriptObject call(JavaScriptObject jso, String methodName) /*-{
		return jso[methodName]();
	}-*/;
	
	
	public static native String attrString(JavaScriptObject jso, String attrName) /*-{
		return jso[attrName];
	}-*/;
	
	
	public static native int length(JavaScriptObject sequence) /*-{
		return sequence.length;
	}-*/;
	
	
	public static native JavaScriptObject get(JavaScriptObject sequence, int index) /*-{
		return sequence[index];
	}-*/;

}
