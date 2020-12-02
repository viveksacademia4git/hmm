package prototype;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.github.adrianulbona.hmm.Emission;
import io.github.adrianulbona.hmm.Model;
import io.github.adrianulbona.hmm.Observation;
import io.github.adrianulbona.hmm.ReachableStateFinder;
import io.github.adrianulbona.hmm.State;
import io.github.adrianulbona.hmm.Transition;
import io.github.adrianulbona.hmm.probability.ProbabilityCalculator;

public enum HmmDemoC2C {

	INSTANCE;

	// Model for Emission Probability ===>>> Model <State, Observation>
	public final Model<Outcome, Quadrant> model;

	HmmDemoC2C() {
		final ProbabilityCalculator<Outcome, Quadrant> pc = probabilityCalculator();
		final ReachableStateFinder<Outcome, Quadrant> rsf = reachableStatesFinder();
		model = new Model<>(pc, rsf);
	}

	public enum Outcome implements State {
		SUCCESS, FAILURE;
	}

	public enum Quadrant implements Observation {
		HD2Q, HD8Q, HD4Q;
	}

	private ProbabilityCalculator<Outcome, Quadrant> probabilityCalculator() {
		return new ProbabilityCalculator<>(StartProbabilities.INSTANCE.data::get,
				EmissionProbabilities.INSTANCE.data::get, TransitionProbabilities.INSTANCE.data::get);
	}

	private ReachableStateFinder<Outcome, Quadrant> reachableStatesFinder() {
		return observation -> Arrays.asList(Outcome.values());
	}

	private enum StartProbabilities {
		INSTANCE;

		public final Map<Outcome, Double> data;

		StartProbabilities() {
			data = new HashMap<>();
			data.put(Outcome.SUCCESS, 0.6);
			data.put(Outcome.FAILURE, 0.4);
		}
	}

	private enum TransitionProbabilities {
		INSTANCE;

		public final Map<Transition<Outcome>, Double> data;

		TransitionProbabilities() {
			data = new HashMap<>();
			data.put(new Transition<>(Outcome.SUCCESS, Outcome.SUCCESS), 0.7);
			data.put(new Transition<>(Outcome.SUCCESS, Outcome.FAILURE), 0.3);
			data.put(new Transition<>(Outcome.FAILURE, Outcome.SUCCESS), 0.4);
			data.put(new Transition<>(Outcome.FAILURE, Outcome.FAILURE), 0.6);
		}
	}

	private enum EmissionProbabilities {
		INSTANCE;

		public final Map<Emission<Outcome, Quadrant>, Double> data;

		EmissionProbabilities() {
			data = new HashMap<>();
			data.put(new Emission<>(Outcome.SUCCESS, Quadrant.HD2Q), 0.5);
			data.put(new Emission<>(Outcome.SUCCESS, Quadrant.HD8Q), 0.4);
			data.put(new Emission<>(Outcome.SUCCESS, Quadrant.HD4Q), 0.1);
			data.put(new Emission<>(Outcome.FAILURE, Quadrant.HD2Q), 0.1);
			data.put(new Emission<>(Outcome.FAILURE, Quadrant.HD8Q), 0.3);
			data.put(new Emission<>(Outcome.FAILURE, Quadrant.HD4Q), 0.6);
		}
	}
}
