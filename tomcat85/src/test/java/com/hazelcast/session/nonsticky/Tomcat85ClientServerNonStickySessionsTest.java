package com.hazelcast.session.nonsticky;

import com.hazelcast.session.HazelcastSession;
import com.hazelcast.session.Java6ExcludeRule;
import com.hazelcast.session.Tomcat85Configurator;
import com.hazelcast.session.WebContainerConfigurator;
import com.hazelcast.session.nonsticky.AbstractClientServerNonStickySessionsTest;
import com.hazelcast.test.HazelcastSerialClassRunner;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HazelcastSerialClassRunner.class)
@Category(QuickTest.class)
public class Tomcat85ClientServerNonStickySessionsTest extends AbstractClientServerNonStickySessionsTest {

    @Rule
    public Java6ExcludeRule java6ExcludeRule = new Java6ExcludeRule();

    @Override
    protected WebContainerConfigurator<?> getWebContainerConfigurator() {
        return new Tomcat85Configurator();
    }

    @Override
    public void validateSessionAccessTime(HazelcastSession session1, HazelcastSession session2) {
        assertEquals("Session thisAccessedTime should be equal", session1.getThisAccessedTime(), session2.getThisAccessedTime());
        assertEquals("Session lastAccessTime should be equal", session1.getLastAccessedTime(), session2.getLastAccessedTime());
    }
}
