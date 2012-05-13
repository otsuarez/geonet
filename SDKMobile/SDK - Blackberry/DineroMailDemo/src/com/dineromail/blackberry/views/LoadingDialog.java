package com.dineromail.blackberry.views;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.GIFEncodedImage;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BorderFactory;

public class LoadingDialog extends Screen implements FieldChangeListener {

	private GIFEncodedImage _loader = (GIFEncodedImage) GIFEncodedImage
			.getEncodedImageResource("loader.bin");
	private ButtonField okButton;

	public LoadingDialog() {
		super(new VerticalFieldManager());
	}

	public LoadingDialog(String message) {
		super(new VerticalFieldManager(), Screen.DEFAULT_CLOSE);
		HorizontalFieldManager hfm = new HorizontalFieldManager();
		hfm.add(new AnimatedGIFField(_loader));
		LabelField label = new LabelField(message) {

			protected void paint(Graphics g) {
				g.setColor(Color.GRAY);
				super.paint(g);
			}

		};
		label.setPadding(0, 0, 0, 20);
		hfm.add(label);
		add(hfm);
		// okButton = new ButtonField("OK", Field.FIELD_HCENTER);
		// okButton.setChangeListener(this);
		// add(okButton);

		setBorder(BorderFactory.createBitmapBorder(new XYEdges(15, 15, 15, 15),
				Bitmap.getBitmapResource("rounded-border.png")));

	}

	protected void sublayout(int width, int height) {
		layoutDelegate(width - 80, height - 80);
		setPositionDelegate(10, 10);
		setExtent(190, Math.min(height - 60, getDelegate().getHeight() + 20));
		setPosition((width - 190) / 2, (height - getHeight()) / 2);
	}

	public void fieldChanged(Field field, int context) {
		if (field == okButton) {
			close();
		}
	}

	/*
	 * protected void paintBackground(Graphics graphics) {
	 * graphics.setColor(Color.DODGERBLUE); graphics.fillRoundRect(0, 0,
	 * getWidth(), getHeight(), 12, 12); graphics.setColor(Color.BLACK);
	 * graphics.drawRoundRect(0, 0, getWidth(), getHeight(), 12, 12); }
	 */

	public int getPreferredWidth() {
		return 190;
	}

	public int getPreferredHeight() {
		return this.getFont().getHeight() + 10;
	}

	public void close() {
		UiApplication.getUiApplication().popScreen(this);
	}

	public void show() {
		UiApplication.getUiApplication().pushModalScreen(this);
	}

}