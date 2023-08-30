package com.wanted.preonboarding.cafe.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItem implements OrderComponent {

    private String name;
    private Integer amount;

    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
    }

    /* HashMap에서 Key로 사용되기 위해 equals() override */
    @Override
    public boolean equals(Object obj) {
        return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, obj);
    }

    /* HashMap에서 Key로 사용되기 위해 hashCode() override */
    @Override
    public int hashCode() {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
    }
}