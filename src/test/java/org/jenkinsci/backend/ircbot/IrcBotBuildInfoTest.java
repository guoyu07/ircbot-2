package org.jenkinsci.backend.ircbot;

import java.io.IOException;
import junit.framework.TestCase;
import org.jvnet.hudson.test.Issue;


/**
 *
 * @author Oleg Nenashev <o.v.nenashev@gmail.com>
 */
public class IrcBotBuildInfoTest extends TestCase {
    
    @Issue("INFRA-135")
    public void testVersionInfoStub() throws IOException {
        IrcBotBuildInfo info = IrcBotBuildInfo.readResourceFile("/versionInfo_test.properties");
        assertEquals("a", info.getBuildNumber());
        assertEquals("b", info.getBuildDate());
        assertEquals("c", info.getBuildID());
        assertEquals("d", info.getBuildURL());
        assertEquals("e", info.getGitCommit());
        System.out.println(info);
    }
    
    /**
     * Reads the real version info.
     * This test is expected to work in https://ci.jenkins-ci.org/job/infra_ircbot/ job only.
     * @throws IOException 
     */
    @Issue("INFRA-135")
    public void testVersionInfoReal() throws IOException {
        IrcBotBuildInfo info = IrcBotBuildInfo.readResourceFile("/versionInfo.properties");
        System.out.println(info);
    }
}
