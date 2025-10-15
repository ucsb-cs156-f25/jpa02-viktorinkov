package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_same_object() {
        Team dif_team = new Team("Other");
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals(dif_team));
    }

    @Test
    public void equals_returns_different_class() {
        String wrongClass = "Text";
        Team correctClass = new Team("John");
        assertEquals(false, team.equals(wrongClass));
        assertEquals(false, team.equals(correctClass));
    }
    
    @Test void equals_returns_names_members(){
        Team teamOne = new Team("One");
        Team teamOneCopy = new Team("One");
        teamOne.addMember("Viktor");
        teamOneCopy.addMember("Viktor");
        Team teamOneFaulty = new Team("One");
        teamOneFaulty.addMember("John");
        Team teamTwo = new Team("Two");
        teamTwo.addMember("John");
        assertEquals(true, teamOne.equals(teamOneCopy));
        assertEquals(false, teamOne.equals(teamTwo));
        assertEquals(false, teamOne.equals(teamOneFaulty));
    }

    @Test void hashCode_returns_same_hash(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    
    @Test void hashCode_cheating_test(){
        Team t = new Team();
        // instantiate t as a Team object
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
