package de.slikey.effectlib.effect;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;

public class MusicLocationEffect extends LocationEffect {

	/**
	 * Radials to spawn next note.
	 */
	public double radialsPerStep = Math.PI / 8;

	/**
	 * Radius of circle above head
	 */
	public float radius = .4f;

	/**
	 * Current step. Works as a counter
	 */
	protected float step = 0;

	public MusicLocationEffect(EffectManager effectManager, Location location) {
		super(effectManager, location);
		type = EffectType.REPEATING;
		iterations = 500;
		period = 4;
	}

	@Override
	public void onRun() {
		Vector v = new Vector(Math.cos(radialsPerStep * step) * radius, .2f, Math.sin(radialsPerStep * step) * radius);
		location.add(v);
		ParticleEffect.NOTE.display(location, visibleRange);
		location.subtract(v);
		step++;
	}

}
