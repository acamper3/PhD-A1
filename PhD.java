package a1;
/** NetId: adc246, Alex Campero. Time spent: hh hours, mm minutes. <br>
 * What I thought about this assignment:  <br>
 * Replace this with your comment, using as many lines as you want. */

/** An instance maintains info about the PhD of a person. */
public class PhD {
    /** Name of the person with a PhD, a String of length > 1 */
    private String name;

    /** Year the PhD was awarded. Can be any integer. */
    private int year;

    /** month PhD was awarded. In 1..12, with 1 meaning January, 2 February, etc. */
    private int month;

    /** The first PhD advisor of this person —null if unknown. */
    private PhD advisor1;

    /** The second advisor of this person —null if unknown or if the person has less than two
     * advisors */
    private PhD advisor2;

    /** The number of PhD advisees of this person. User never gives a value for this field. */
    private int advisees;

    /** Constructor: an instance with name n, PhD year y, and PhD month m.<br>
     * The advisors are unknown, and there are 0 advisees.<br>
     * Precondition: n has at least 2 chars, and m is in 1..12. */
    public PhD(String n, int y, int m) {
        assert n.length() > 1;
        assert m > 0 && m < 13;
        name= n;
        year= y;
        month= m;
        advisees= 0;
        // remember to do something about the unknown advisors
    }

    /** Return the name of this person. */
    public String name() {
        return name;
    }

    /** Return the date this person got their PhD in the form "month/<year>" <br>
     * E.g. For February 2022, return "2/2022". */
    public String date() {
        return month + "/" + year;
    }

    /** Return the first advisor of this PhD (null if unknown). */
    public PhD advisor1() {
        return advisor1;
    }

    /** Return the second advisor of this PhD (null if unknown or non-existent) */
    public PhD advisor2() {
        return advisor2;
    }

    /** Return the number of PhD advisees of this person. */
    public int advisees() {
        return advisees;
    }

// Group B
    /** Add p as the first advisor of this person. <br>
     * Precondition: the first advisor is unknown and p is not null. */
    public void addAdvisor1(PhD p) {
        advisor1= p;
        p.advisees++ ;
    }

    /** Add p as the second advisor of this PhD. <br>
     * Precondition: The first advisor is known, the second advisor is unknown, p is not null, and p
     * is different from the first advisor. */
    public void addAdvisor2(PhD p) {
        advisor2= p;
        p.advisees++ ;
    }

// Group C

    /** Constructor: a PhD with name n, PhD year y, PhD month m, first advisor p1, and second
     * advisor p2.<br>
     * Precondition: n has at least 2 chars, m is in 1..12, p1 and p2 are not null, and p1 and p2
     * are different. */
    public PhD(String n, int y, int m, PhD p1, PhD p2) {
        this(n, y, m);

        assert p1 != null;
        assert p2 != null;
        assert p1 != p2;

        addAdvisor1(p1);
        addAdvisor2(p2);
    }

// Group D
    /** Return value of: "p is not null and this PhD got the PhD before p" */
    public boolean gotBefore(PhD p) {
        return p != null && (p.year > year || p.year == year && p.month > month);
    }

    /** Return value of: "this PhD is an intellectual sibling of p".<br>
     * Precondition: p is not null */
    public boolean isSiblingOf(PhD p) {
        assert p != null;
        return this != p && p.advisor1 != null && advisor1 != null &&
            (advisor1 == p.advisor1 || advisor2 == p.advisor2 &&
                p.advisor2 != null && advisor2 != null || advisor1 == p.advisor2 ||
                advisor2 == p.advisor1);

    }

}
