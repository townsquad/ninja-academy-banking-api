package io.townsq.bank.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;


public class AccountServiceTest {

    @Test
    public void test() {
        int n = 3;
        int result = sum(n);
        assertThat(result, is(6));
    }

    int sum(int n) {
        return n <= 0 ? 0 : n + sum(n - 1);
    }

}