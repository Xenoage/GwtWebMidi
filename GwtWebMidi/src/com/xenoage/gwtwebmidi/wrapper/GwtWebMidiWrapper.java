package com.xenoage.gwtwebmidi.wrapper;

import com.google.gwt.core.client.JavaScriptObject;
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
		//test if Web MIDI is available
		if ($wnd.navigator && 'function' === typeof $wnd.navigator.requestMIDIAccess) {
			//init Web MIDI
			$wnd.navigator.requestMIDIAccess().then($wnd.onRequestMidiSuccess, $wnd.onRequestMidiError);
		}
		else {
			$wnd.onRequestMidiError({"name": "NotSupportedError"});
		}
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
			listener.onInitError(new Exception(get(error, "name").toString()));
	}
	

	public static native String attrString(JavaScriptObject jso, String attrName) /*-{
		return jso[attrName];
	}-*/;
	
	
	public static native double attrDouble(JavaScriptObject jso, String attrName) /*-{
		return jso[attrName];
	}-*/;
	
	
	public static native byte[] attrByteArray(JavaScriptObject jso, String attrName) /*-{
		return jso[attrName];
	}-*/;
	
	
	//TODO: MIDIOutputMap class
	public static native int length(Object sequence) /*-{
		return sequence.size;
	}-*/;
	
	
	public static native JavaScriptObject call(JavaScriptObject jso, String methodName) /*-{
		return jso[methodName]();
	}-*/;
	
	
	public static native JavaScriptObject call(JavaScriptObject jso, String methodName, Object arg0) /*-{
		return jso[methodName](arg0);
	}-*/;
	
	
	public static native JavaScriptObject get(JavaScriptObject jso, String propertyName) /*-{
		return jso[propertyName];
	}-*/;
	
	
	public static native JavaScriptObject get(JavaScriptObject sequence, int index) /*-{
		return sequence[index];
	}-*/;
	
	public static native void consoleLog(Object message) /*-{
    	console.log(message);
	}-*/;

}
