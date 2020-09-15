package com.coveo.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

public class AutoCompleteTest {

    @Test
    public void firstTest()
    {
        String[] dict = { "def", "a", "aba", "denim", "dear" };
        AutoComplete completeService = new AutoComplete(dict);
        List<String> result = completeService.getWordsForPrefix("de");

        result.stream().forEach(System.out::println);
    }
}
