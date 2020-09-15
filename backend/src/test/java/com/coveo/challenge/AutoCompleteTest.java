package com.coveo.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

public class AutoCompleteTest {

    @Test
    public void getWordForPrefixShouldFetchFromExistingPrefix()
    {
        String[] dict = { "Hannover", "Hamburg", "Hanoi", "Hamilton", "Montreal" };
        AutoComplete completeService = new AutoComplete(dict);
        List<String> result = completeService.getWordsForPrefix("Ha");

        result.stream().forEach(System.out::println);

        Assertions.assertTrue(result.contains("Hamburg"));
        Assertions.assertFalse(result.contains("Montreal"), "Should not contain Montreal for this query.");
    }
}
