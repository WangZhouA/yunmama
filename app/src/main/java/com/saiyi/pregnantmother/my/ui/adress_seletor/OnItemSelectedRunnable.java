package com.saiyi.pregnantmother.my.ui.adress_seletor;

final class OnItemSelectedRunnable implements Runnable {
	final WheelView loopView;

	OnItemSelectedRunnable(WheelView loopview) {
		loopView = loopview;
	}

	@Override
	public final void run() {
		loopView.onItemSelectedListener.onItemSelected(loopView
				.getCurrentItem());
	}
}
