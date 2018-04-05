package com.hazelcast.session.nonsticky.txsupport;

import com.hazelcast.session.nonsticky.Tomcat6P2PNonStickySessionsTest;
import com.hazelcast.test.HazelcastSerialClassRunner;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(HazelcastSerialClassRunner.class)
@Category(QuickTest.class)
public class Tomcat6OnePhaseCommitP2PNonStickySessionsTest extends Tomcat6P2PNonStickySessionsTest {

    public String getWriteStrategy() {
        return "onePhaseCommit";
    }
}
