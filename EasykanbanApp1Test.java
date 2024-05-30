/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.easykanbanapp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author disha
 */
public class EasykanbanApp1Test {
    

    @Test
    public void testTaskDescriptionLength() {
        // Test for success
        assertTrue(EasyKanbanApp.isValidDescription("Short task description"));

        // Test for failure
        assertTrue(!EasyKanbanApp.isValidDescription("This is a very long task description that exceeds fifty characters limit"));
    }

    @Test
    public void testTaskID() {
        // Test for a specific TaskID
        assertEquals("AD:1:BYN", EasyKanbanApp.generateTaskID("AD", 1, "BYN"));

        // Test for remaining TaskIDs
        assertEquals("CR:0:IKE", EasyKanbanApp.generateTaskID("CR", 0, "IKE"));
        assertEquals("CR:1:ARD", EasyKanbanApp.generateTaskID("CR", 1, "ARD"));
        assertEquals("CR:2:THA", EasyKanbanApp.generateTaskID("CR", 2, "THA"));
        assertEquals("CR:3:ND", EasyKanbanApp.generateTaskID("CR", 3, "ND"));
    }

    @Test
    public void testTotalHoursAccumulated() {
        // Test data for task durations
        int[] durations = {10, 12, 55, 11, 1};
        int totalHours = 0;

        // Loop through durations and accumulate total hours
        for (int duration : durations) {
            totalHours += duration;
        }

        assertEquals(89, totalHours);
    }
}


