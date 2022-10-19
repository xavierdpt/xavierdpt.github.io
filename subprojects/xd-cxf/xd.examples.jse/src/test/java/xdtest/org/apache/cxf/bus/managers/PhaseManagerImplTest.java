package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.phase.Phase;
import org.junit.Test;

import java.util.SortedSet;

public class PhaseManagerImplTest {
    @Test
    public void test() {
        PhaseManagerImpl instance = new PhaseManagerImpl();

        SortedSet<Phase> in = null;
        SortedSet<Phase> out = null;
        PhaseManagerImpl phaseManager = new PhaseManagerImpl(in, out);

        Class<?> registrationType = instance.getRegistrationType();

        SortedSet<Phase> inPhases = instance.getInPhases();

        SortedSet<Phase> outPhases = instance.getOutPhases();




    }

}
