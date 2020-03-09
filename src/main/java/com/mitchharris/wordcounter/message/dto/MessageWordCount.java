package com.mitchharris.wordcounter.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class MessageWordCount {

    @ApiModelProperty(value = "count of words received", required = true, example = "3")
    private final Integer count;

    public MessageWordCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageWordCount that = (MessageWordCount) o;
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


