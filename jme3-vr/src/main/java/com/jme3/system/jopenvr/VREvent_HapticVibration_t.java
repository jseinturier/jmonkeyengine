package com.jme3.system.jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:1402</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VREvent_HapticVibration_t extends Structure {
	public long containerHandle;
	public long componentHandle;
	public float fDurationSeconds;
	public float fFrequency;
	public float fAmplitude;
	public VREvent_HapticVibration_t() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("containerHandle", "componentHandle", "fDurationSeconds", "fFrequency", "fAmplitude");
	}
	public VREvent_HapticVibration_t(long containerHandle, long componentHandle, float fDurationSeconds, float fFrequency, float fAmplitude) {
		super();
		this.containerHandle = containerHandle;
		this.componentHandle = componentHandle;
		this.fDurationSeconds = fDurationSeconds;
		this.fFrequency = fFrequency;
		this.fAmplitude = fAmplitude;
	}
	public VREvent_HapticVibration_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VREvent_HapticVibration_t implements Structure.ByReference {
		
	};
	public static class ByValue extends VREvent_HapticVibration_t implements Structure.ByValue {
		
	};
}
