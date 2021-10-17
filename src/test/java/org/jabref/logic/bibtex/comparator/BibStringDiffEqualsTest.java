package org.jabref.logic.bibtex.comparator;

import org.junit.jupiter.api.Test;

import org.jabref.model.entry.BibtexString;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BibStringDiffEqualsTest {

    private BibStringDiff b1;
    private BibStringDiff b2;

    @BeforeEach
    void beforeEach() {
        b1 = null;
        b2 = null;
    }

    @Test
    void sameObjects() {
        b1 = new BibStringDiff(new BibtexString("name", "content"), new BibtexString("name", "content"));
        b2 = b1;
        assertTrue(b1.equals(b2));
    }

    @Test
    void toCompareIsNull() {
        b1 = new BibStringDiff(new BibtexString("name", "content"), new BibtexString("name", "content"));
        assertFalse(b1.equals(b2));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void toCompareHasDifferentClass() {
        Integer i = 1;
        b1 = new BibStringDiff(new BibtexString("name", "content"), new BibtexString("name", "content"));
        assertFalse(b1.equals(i));
    }

    @Test
    void originalAndNewStringsDifferent() {
        b1 = new BibStringDiff(new BibtexString("oname", "ocontent"), new BibtexString("nname", "ncontent"));
        b2 = new BibStringDiff(new BibtexString("oname1", "ocontent1"), new BibtexString("nname1", "ncontent1"));
        assertFalse(b1.equals(b2));
    }

    @Test
    void originalEqualNewNotEqual() {
        b1 = new BibStringDiff(new BibtexString("oname", "ocontent"), new BibtexString("nname", "ncontent"));
        b2 = new BibStringDiff(new BibtexString("oname", "ocontent"), new BibtexString("nname1", "ncontent1"));
        assertFalse(b1.equals(b2));
    }

    @Test
    void originalNotEqualNewEqual() {
        b1 = new BibStringDiff(new BibtexString("oname", "ocontent"), new BibtexString("nname", "ncontent"));
        b2 = new BibStringDiff(new BibtexString("oname1", "ocontent1"), new BibtexString("nname", "ncontent"));
        assertFalse(b1.equals(b2));
    }

    @Test
    void originalNewEqual() {
        b1 = new BibStringDiff(new BibtexString("oname", "ocontent"), new BibtexString("nname", "ncontent"));
        b2 = new BibStringDiff(new BibtexString("oname", "ocontent"), new BibtexString("nname", "ncontent"));
        assertTrue(b1.equals(b2));
    }
}
