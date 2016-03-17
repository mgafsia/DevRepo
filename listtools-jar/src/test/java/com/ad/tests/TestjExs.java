package com.ad.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;


/**
 * Created by MGA on 27/02/2016.
 * test for some exercices to
 */
public class TestjExs {

    @Test
    public void ex2()  {

        byte    by  = 10;
        long    lg   = 100;
        float   fo   = 2.5f;

        fo = by*lg*2.f/fo;
        System.out.print(fo);  // ==> ok float

        //x = b1*q*2./x; // ==> not ok - return double
        assertTrue("true", true);
    }

}
