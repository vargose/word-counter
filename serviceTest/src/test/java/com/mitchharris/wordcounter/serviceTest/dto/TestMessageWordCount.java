package com.mitchharris.wordcounter.serviceTest.dto;

import java.util.Objects;

public class TestMessageWordCount {

    private Integer count;

    public TestMessageWordCount() {
    }

    public TestMessageWordCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestMessageWordCount that = (TestMessageWordCount) o;
        return Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "MessageWordCount{" +
                "count='" + count + '\'' +
                '}';
    }
}


