package br.ce.wcaquino.taskbackend.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskTest extends TestCase {

    Task t = new Task();

    @Test
    public void testGetId() {
        Assert.assertNull(t.getId());
    }

    @Test
    public void testSetId() {
    }

    @Test
    public void testGetTask() {
        Assert.assertNull(t.getTask());
    }

    @Test
    public void testSetTask() {
    }

    @Test
    public void testGetDueDate() {
        Assert.assertNull(t.getDueDate());
    }

    @Test
    public void testSetDueDate() {
    }
}