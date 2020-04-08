package com.jme3.system.osvr.osvrrendermanageropengl;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class OSVR_ViewportDescription extends Structure {
	/** Left side of the viewport in pixels */
	public double left;
	/** First pixel in the viewport at the bottom. */
	public double lower;
	/** Last pixel in the viewport at the top */
	public double width;
	/** Last pixel on the right of the viewport in pixels */
	public double height;
	public OSVR_ViewportDescription() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("left", "lower", "width", "height");
	}
	/**
	 * @param left Left side of the viewport in pixels<br>
	 * @param lower First pixel in the viewport at the bottom.<br>
	 * @param width Last pixel in the viewport at the top<br>
	 * @param height Last pixel on the right of the viewport in pixels
	 */
	public OSVR_ViewportDescription(double left, double lower, double width, double height) {
		super();
		this.left = left;
		this.lower = lower;
		this.width = width;
		this.height = height;
	}
	public OSVR_ViewportDescription(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends OSVR_ViewportDescription implements Structure.ByReference {
		
	};
	public static class ByValue extends OSVR_ViewportDescription implements Structure.ByValue {
		
	};
}
