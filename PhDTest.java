package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PhDTest {

    @Test
    void testConstructor1() {
        PhD ph1= new PhD("Alex", 2002, 3);
        assertEquals("Alex", ph1.name());
        assertEquals("3/2002", ph1.date());
        assertEquals(0, ph1.advisees());
        assertEquals(null, ph1.advisor1());
        assertEquals(null, ph1.advisor2());
    }

    @Test
    void testMutators() {
        PhD ph1= new PhD("Alex", 2000, 10);
        PhD ph2= new PhD("Dre", 4500, 8);
        PhD ph3= new PhD("Maya", 1999, 2);

        ph1.addAdvisor1(ph2);
        assertEquals(ph2, ph1.advisor1());
        assertEquals(1, ph2.advisees());

        ph1.addAdvisor2(ph3);

        assertEquals(ph3, ph1.advisor2());
        assertEquals(1, ph3.advisees());

    }

    @Test
    void testConstructor2() {
        PhD ph1= new PhD("Cid", 1992, 4);
        PhD ph2= new PhD("Syd", 1934, 5);
        PhD ph3= new PhD("Guy", 1833, 2, ph1, ph2);

        assertEquals("Guy", ph3.name());
        assertEquals("2/1833", ph3.date());
        assertEquals(0, ph3.advisees());
        assertEquals(ph1, ph3.advisor1());
        assertEquals(ph2, ph3.advisor2());

        assertEquals(1, ph1.advisees());
        assertEquals(1, ph2.advisees());
    }

    @Test
    void testFunction() {
        PhD Jan2022= new PhD("Kid", 2022, 1);
        PhD May2022= new PhD("Kid", 2022, 5);

        PhD Jun3011= new PhD("Kid", 3011, 6);

        assertEquals(true, Jan2022.gotBefore(Jun3011));
        assertEquals(false, Jun3011.gotBefore(May2022));

        assertEquals(true, Jan2022.gotBefore(May2022));
        assertEquals(false, May2022.gotBefore(Jan2022));

        assertEquals(false, Jan2022.gotBefore(null));

        PhD p1= new PhD("Bud", 2022, 1);
        PhD p2= new PhD("Bud", 2022, 1);
        PhD p5= new PhD("Bud", 2022, 1);
        PhD p3= new PhD("Bud", 2022, 1, p1, p2);
        PhD p4= new PhD("Bud", 2022, 1, p1, p5);
        PhD p7= new PhD("Bud", 2022, 1, p3, p1);
        PhD p8= new PhD("Bud", 2022, 1, p2, p5);
        PhD p9= new PhD("Bud", 2022, 1, p3, p2);

        assertEquals(false, p1.isSiblingOf(p1));
        assertEquals(false, p1.isSiblingOf(p3));
        assertEquals(false, p3.isSiblingOf(p2));
        assertEquals(true, p3.isSiblingOf(p4));
        assertEquals(true, p3.isSiblingOf(p7));
        assertEquals(true, p3.isSiblingOf(p8));
        assertEquals(true, p3.isSiblingOf(p9));
    }

}
