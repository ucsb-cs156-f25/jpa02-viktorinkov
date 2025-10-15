package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("VIKTOR STANISLAVOV", Developer.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f25-09", t.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        String id = Developer.getGithubId();
        assertEquals("viktorinkov", id);
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("LAUREN GRACE"),"Team should contain LAUREN GRACE");
        assertTrue(t.getMembers().contains("SAMPRITA"),"Team should contain SAMPRITA");
        assertTrue(t.getMembers().contains("DAVID MARIO"),"Team should contain DAVID MARIO");
        assertTrue(t.getMembers().contains("DENNIS"),"Team should contain DENNIS");
        assertTrue(t.getMembers().contains("VIKTOR STANISLAVOV"),"Team should contain VIKTOR STANISLAVOV");
        assertTrue(t.getMembers().contains("ONUR"),"Team should contain ONUR");
    }

}
