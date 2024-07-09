package org.unlogged.demo.filter.abs;

import org.unlogged.demo.filter.abs.model.FieldC;

import java.util.List;

public class WithdrawalReportingFilterC extends GenericReportingFilterC {

    public WithdrawalReportingFilterC(GenericReportingFilterC reportingFilter) {
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
        return new WithdrawalReportingFilterC(this);
    }

    public void performAFilterPre() {
        BaseFilterC customFilter = clone().clone();
        customFilter.clone();
    }
}
