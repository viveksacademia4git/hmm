package prototype;

import static org.junit.Assert.assertEquals;
import static prototype.HmmDemoC2C.Outcome.FAILURE;
import static prototype.HmmDemoC2C.Outcome.SUCCESS;
import static prototype.HmmDemoC2C.Quadrant.HD2Q;
import static prototype.HmmDemoC2C.Quadrant.HD4Q;
import static prototype.HmmDemoC2C.Quadrant.HD8Q;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.github.adrianulbona.hmm.Model;
import io.github.adrianulbona.hmm.solver.MostProbableStateSequenceFinder;
import prototype.HmmDemoC2C.Outcome;
import prototype.HmmDemoC2C.Quadrant;

public class HmmDemoC2CTest {

	@Test
	public final void testMostProbableStateSequenceFinder() {
		Model<Outcome, Quadrant> model = HmmDemoC2C.INSTANCE.model;
		List<Quadrant> symptoms1 = Arrays.asList(HD2Q, HD4Q, HD8Q, HD4Q);
		List<Outcome> medicalStateSequenceList = new MostProbableStateSequenceFinder<>(model).basedOn(symptoms1);
		assertEquals(Arrays.asList(SUCCESS, FAILURE, FAILURE, FAILURE), medicalStateSequenceList);
		System.out.println(model.transitionProbabilitiesFor(HD2Q, HD4Q));
	}

	@Test
	public final void testMostProbableStateSequenceFinder2() {
		Model<Outcome, Quadrant> model = HmmDemoC2C.INSTANCE.model;
		List<Quadrant> symptoms = Arrays.asList(HD4Q, HD2Q, HD8Q, HD2Q);
		List<Outcome> medicalStateSequenceList = new MostProbableStateSequenceFinder<>(model).basedOn(symptoms);
		assertEquals(Arrays.asList(FAILURE, SUCCESS, SUCCESS, SUCCESS), medicalStateSequenceList);
	}

}
