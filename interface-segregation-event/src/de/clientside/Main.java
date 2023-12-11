package de.clientside;


import de.tiere.PigTooFatListener;
import de.tiere.Schwein;

import java.io.Serializable;

public class Main {


	private Butcher butcher = new Butcher();
	private Forwarder forwarder = new Forwarder();


	public static void main(String[] args) {
		new Main().run();

	}

	private void run() {
		Schwein piggy = new Schwein("Miss Piggy");
		piggy.addPigTooFatListener(new PigButcherAdapter());
		piggy.addPigTooFatListener(e->forwarder.drive(e));
		piggy.addPigTooFatListener(forwarder::drive);
		for (int i = 0; i < 11; i++) {
			piggy.fuettern();

		}
	}

	class PigButcherAdapter implements PigTooFatListener {

		@Override
		public void pigTooFat(final Schwein dickesSchwein) {
			butcher.slaughter(dickesSchwein);
		}
	}


}

class Butcher  {


	public void slaughter(final Schwein dickesSchwein) {
		System.out.println("Coming....");
	}
}

class Forwarder  {


	public void drive(final Object things) {
		System.out.println("we drive on german Autobahn...");
	}
}