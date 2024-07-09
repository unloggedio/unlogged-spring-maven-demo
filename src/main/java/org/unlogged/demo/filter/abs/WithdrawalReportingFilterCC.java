package org.unlogged.demo.filter.abs;

import org.unlogged.demo.filter.abs.model.FieldC;

import java.util.List;

public class WithdrawalReportingFilterCC extends GenericReportingFilterC implements PerformFilterC {

    public WithdrawalReportingFilterCC(GenericReportingFilterC reportingFilter) {
    }

    @Override
    public List<List<FieldC>> getMandatoryFields() {
        return null;
    }

    @Override
    public List<FieldC> getSelectFields() {
        return null;
    }

    @Override
    public List<FieldC> getGroupByFields() {
        return null;
    }

    @Override
    public List<FieldC> getAggregatableFields() {
        return null;
    }

    @Override
    public BaseFilterC clone() {
        return new WithdrawalReportingFilterCC(this);
    }

    @Override
    public void clone(String e) {
        System.out.println("E : "+e);
    }

    public void performAFilterPre() {
        BaseFilterC customFilter = clone().clone();
        customFilter.clone();
    }
}
