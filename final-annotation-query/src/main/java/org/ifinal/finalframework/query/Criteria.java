package org.ifinal.finalframework.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Criteria.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
public class Criteria extends ArrayList<Criterion> implements Criterion {

    @Getter
    private final AndOr andOr;

    public Criteria() {
        this(AndOr.AND);
    }

    public Criteria(final AndOr andOr) {
        this.andOr = andOr;
    }

    public Criteria(final AndOr andOr, Collection<Criterion> criteria) {
        this.andOr = Objects.requireNonNull(andOr, "Criteria andOr can not be null.");
        this.addAll(criteria);
    }

    public static Criteria where(Criterion... criterion) {
        return and(criterion);
    }

    public static Criteria where(Collection<Criterion> criterion) {
        return and(criterion);
    }

    public static Criteria and(Criterion... criterion) {
        return and(Arrays.asList(criterion));
    }

    public static Criteria and(Collection<Criterion> criterion) {
        return new Criteria(AndOr.AND, criterion);
    }

    public static Criteria or(Criterion... criterion) {
        return or(Arrays.asList(criterion));
    }

    public static Criteria or(Collection<Criterion> criterion) {
        return new Criteria(AndOr.OR, criterion);
    }

    public Criteria and(final Criteria... criteria) {

        return andOr(AndOr.AND, criteria);
    }

    public Criteria or(final Criteria... criteria) {

        return andOr(AndOr.OR, criteria);
    }

    private Criteria andOr(final AndOr andOr, final Criteria... criteria) {
        List<Criterion> list = new ArrayList<>();
        list.add(this);
        list.addAll(Arrays.asList(criteria));
        return new Criteria(andOr, list);
    }

}
