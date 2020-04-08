package com.jme3.system.osvr.osvrclientreporttypes;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class OSVR_EyeTrackerBlinkReport extends Structure {
	/** C type : OSVR_ChannelCount */
	public int sensor;
	/** C type : OSVR_EyeTrackerBlinkState */
	public byte state;
	public OSVR_EyeTrackerBlinkReport() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("sensor", "state");
	}
	/**
	 * @param sensor C type : OSVR_ChannelCount<br>
	 * @param state C type : OSVR_EyeTrackerBlinkState
	 */
	public OSVR_EyeTrackerBlinkReport(int sensor, byte state) {
		super();
		this.sensor = sensor;
		this.state = state;
	}
	public OSVR_EyeTrackerBlinkReport(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends OSVR_EyeTrackerBlinkReport implements Structure.ByReference {
		
	};
	public static class ByValue extends OSVR_EyeTrackerBlinkReport implements Structure.ByValue {
		
	};
}
