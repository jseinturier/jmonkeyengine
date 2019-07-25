/*
 * Copyright (c) 2009-2018 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.system.awt;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.jme3.input.JoyInput;
import com.jme3.input.TouchInput;
import com.jme3.input.awt.AWTKeyInput;
import com.jme3.input.awt.AWTMouseInput;
import com.jme3.opencl.Context;
import com.jme3.renderer.Renderer;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import com.jme3.system.JmeSystem;
import com.jme3.system.SystemListener;
import com.jme3.system.Timer;

/**
 * A JMonkey {@link JmeContext context} that is dedicated to AWT component rendering.
 * <p>
 * This class is based on the <a href="http://www.oracle.com/technetwork/java/javase/overview/javafx-overview-2158620.html">JavaFX</a> original code provided by Alexander Brui (see <a href="https://github.com/JavaSaBr/JME3-JFX">JME3-FX</a>)
 * </p>
 * It is possible to specify a system renderer to use by setting the system property <i>jme3.system.renderer</i> with a value that specifies the renderer to use (These values can be obtained from {@link AppSettings} class).
 * @author Julien Seinturier - COMEX SA - <a href="http://www.seinturier.fr">http://www.seinturier.fr</a>
 * @author Alexander Brui (JavaSaBr)
 */
public class AWTContext implements JmeContext {

  private static final Logger logger = Logger.getLogger(JmeContext.class.getName());
	
  /**
   * The settings.
   */
  protected final AppSettings settings;

  /**
   * The key input.
   */
  protected final AWTKeyInput keyInput;

  /**
   * The mouse input.
   */
  protected final AWTMouseInput mouseInput;

  /**
   * The current width.
   */
  private volatile int width;

  /**
   * The current height.
   */
  private volatile int height;

  private String underlyingRenderer = null;
  
  /**
   * The background context.
   */
  protected JmeContext backgroundContext;

  public AWTContext() {
      this.keyInput = new AWTKeyInput(this);
      this.mouseInput = new AWTMouseInput(this);
      this.settings = createSettings();
      this.backgroundContext = createBackgroundContext();
      this.height = 1;
      this.width = 1;
  }

  /**
   * @return the current height.
   */
  public int getHeight() {
      return height;
  }

  /**
   * @param height the current height.
   */
  public void setHeight(final int height) {
      this.height = height;
  }

  /**
   * @return the current width.
   */
  public int getWidth() {
      return width;
  }

  /**
   * @param width the current width.
   */
  public void setWidth(final int width) {
      this.width = width;
  }

  /**
   * @return new settings.
   */
  protected AppSettings createSettings() {
      final AppSettings settings = new AppSettings(true);
      
      String renderer = System.getProperty("jme3.system.renderer");
      
      if (renderer != null) {
    	  underlyingRenderer = renderer;
    	  settings.setRenderer(underlyingRenderer);
    	  logger.log(Level.INFO, "Using underlying renderer "+settings.getRenderer()+".");
      } else {
    	  underlyingRenderer = settings.getRenderer();
    	  logger.log(Level.INFO, "Using default underlying renderer "+underlyingRenderer);
    	  logger.log(Level.INFO, getClass().getSimpleName()+" underlying renderer can be set using jme3.awt.renderer property.");
      }
      
      return settings;
  }

  @Override
  public void setSettings(AppSettings settings) {
      this.settings.copyFrom(settings);
      
      String renderer = System.getProperty("jme3.system.renderer");
      
      if (renderer != null) {
    	  underlyingRenderer = renderer;
    	  this.settings.setRenderer(underlyingRenderer);
    	  logger.log(Level.INFO, "Using underlying renderer "+this.settings.getRenderer()+".");
      } else {
    	  this.settings.setRenderer(underlyingRenderer);
    	  logger.log(Level.INFO, "Using default underlying renderer "+this.settings.getRenderer());
    	  logger.log(Level.INFO, getClass().getSimpleName()+" underlying renderer can be set using jme3.awt.renderer property.");
      }
      
      this.backgroundContext.setSettings(this.settings);
  }
  
  /**
   * @return new context/
   */
  protected JmeContext createBackgroundContext() {
      return JmeSystem.newContext(settings, Type.OffscreenSurface);
  }

  @Override
  public Type getType() {
      return Type.OffscreenSurface;
  }

  @Override
  public void setSystemListener(final SystemListener listener) {
      backgroundContext.setSystemListener(listener);
  }

  @Override
  public AppSettings getSettings() {
      return settings;
  }

  @Override
  public Renderer getRenderer() {
      return backgroundContext.getRenderer();
  }

  @Override
  public Context getOpenCLContext() {
      return null;
  }

  @Override
  public AWTMouseInput getMouseInput() {
      return mouseInput;
  }

  @Override
  public AWTKeyInput getKeyInput() {
      return keyInput;
  }

  @Override
  public JoyInput getJoyInput() {
      return null;
  }

  @Override
  public TouchInput getTouchInput() {
      return null;
  }

  @Override
  public Timer getTimer() {
      return backgroundContext.getTimer();
  }

  @Override
  public void setTitle(final String title) {
  }

  @Override
  public boolean isCreated() {
      return backgroundContext != null && backgroundContext.isCreated();
  }

  @Override
  public boolean isRenderable() {
      return backgroundContext != null && backgroundContext.isRenderable();
  }

  @Override
  public void setAutoFlushFrames(final boolean enabled) {
      // TODO Auto-generated method stub
  }

  @Override
  public void create(final boolean waitFor) {
      logger.log(Level.INFO, "Creating background renderer using "+backgroundContext.getSettings().getRenderer()+" renderer");
      backgroundContext.create(waitFor);
  }

  @Override
  public void restart() {
  }

  @Override
  public void destroy(final boolean waitFor) {
      if (backgroundContext == null) throw new IllegalStateException("Not created");
      // destroy wrapped context
      backgroundContext.destroy(waitFor);
}

}
