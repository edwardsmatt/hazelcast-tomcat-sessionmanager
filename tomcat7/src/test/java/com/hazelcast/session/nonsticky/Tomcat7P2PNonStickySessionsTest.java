package com.hazelcast.session.nonsticky;

import com.hazelcast.session.HazelcastSession;
import com.hazelcast.session.Tomcat7Configurator;
import com.hazelcast.session.WebContainerConfigurator;
import com.hazelcast.test.HazelcastSerialClassRunner;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HazelcastSerialClassRunner.class)
@Category(QuickTest.class)
public class Tomcat7P2PNonStickySessionsTest extends AbstractP2PNonStickySessionsTest {

    @Override
    protected WebContainerConfigurator<?> getWebContainerConfigurator() {
        return new Tomcat7Configurator();
    }

    @Override
    public void validateSessionAccessTime(HazelcastSession session1, HazelcastSession session2) {
        assertEquals("Session thisAccessedTime should be equal", session1.getThisAccessedTime(), session2.getThisAccessedTime());
        assertEquals("Session lastAccessTime should be equal", session1.getLastAccessedTime(), session2.getLastAccessedTime());
    }
}
