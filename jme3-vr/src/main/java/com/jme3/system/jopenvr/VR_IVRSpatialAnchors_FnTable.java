package com.jme3.system.jopenvr;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:2373</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VR_IVRSpatialAnchors_FnTable extends Structure {
	/** C type : CreateSpatialAnchorFromDescriptor_callback* */
	public VR_IVRSpatialAnchors_FnTable.CreateSpatialAnchorFromDescriptor_callback CreateSpatialAnchorFromDescriptor;
	/** C type : CreateSpatialAnchorFromPose_callback* */
	public VR_IVRSpatialAnchors_FnTable.CreateSpatialAnchorFromPose_callback CreateSpatialAnchorFromPose;
	/** C type : GetSpatialAnchorPose_callback* */
	public VR_IVRSpatialAnchors_FnTable.GetSpatialAnchorPose_callback GetSpatialAnchorPose;
	/** C type : GetSpatialAnchorDescriptor_callback* */
	public VR_IVRSpatialAnchors_FnTable.GetSpatialAnchorDescriptor_callback GetSpatialAnchorDescriptor;
	/** <i>native declaration : headers\openvr_capi.h:2369</i> */
	public interface CreateSpatialAnchorFromDescriptor_callback extends Callback {
		int apply(Pointer pchDescriptor, IntByReference pHandleOut);
	};
	/** <i>native declaration : headers\openvr_capi.h:2370</i> */
	public interface CreateSpatialAnchorFromPose_callback extends Callback {
		int apply(int unDeviceIndex, int eOrigin, SpatialAnchorPose_t pPose, IntByReference pHandleOut);
	};
	/** <i>native declaration : headers\openvr_capi.h:2371</i> */
	public interface GetSpatialAnchorPose_callback extends Callback {
		int apply(int unHandle, int eOrigin, SpatialAnchorPose_t pPoseOut);
	};
	/** <i>native declaration : headers\openvr_capi.h:2372</i> */
	public interface GetSpatialAnchorDescriptor_callback extends Callback {
		int apply(int unHandle, Pointer pchDescriptorOut, IntByReference punDescriptorBufferLenInOut);
	};
	public VR_IVRSpatialAnchors_FnTable() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("CreateSpatialAnchorFromDescriptor", "CreateSpatialAnchorFromPose", "GetSpatialAnchorPose", "GetSpatialAnchorDescriptor");
	}
	/**
	 * @param CreateSpatialAnchorFromDescriptor C type : CreateSpatialAnchorFromDescriptor_callback*<br>
	 * @param CreateSpatialAnchorFromPose C type : CreateSpatialAnchorFromPose_callback*<br>
	 * @param GetSpatialAnchorPose C type : GetSpatialAnchorPose_callback*<br>
	 * @param GetSpatialAnchorDescriptor C type : GetSpatialAnchorDescriptor_callback*
	 */
	public VR_IVRSpatialAnchors_FnTable(VR_IVRSpatialAnchors_FnTable.CreateSpatialAnchorFromDescriptor_callback CreateSpatialAnchorFromDescriptor, VR_IVRSpatialAnchors_FnTable.CreateSpatialAnchorFromPose_callback CreateSpatialAnchorFromPose, VR_IVRSpatialAnchors_FnTable.GetSpatialAnchorPose_callback GetSpatialAnchorPose, VR_IVRSpatialAnchors_FnTable.GetSpatialAnchorDescriptor_callback GetSpatialAnchorDescriptor) {
		super();
		this.CreateSpatialAnchorFromDescriptor = CreateSpatialAnchorFromDescriptor;
		this.CreateSpatialAnchorFromPose = CreateSpatialAnchorFromPose;
		this.GetSpatialAnchorPose = GetSpatialAnchorPose;
		this.GetSpatialAnchorDescriptor = GetSpatialAnchorDescriptor;
	}
	public VR_IVRSpatialAnchors_FnTable(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VR_IVRSpatialAnchors_FnTable implements Structure.ByReference {
		
	};
	public static class ByValue extends VR_IVRSpatialAnchors_FnTable implements Structure.ByValue {
		
	};
}
