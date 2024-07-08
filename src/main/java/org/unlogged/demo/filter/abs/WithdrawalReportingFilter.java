package org.unlogged.demo.filter.abs;

public class WithdrawalReportingFilter extends GenericReportingFilter {

    public WithdrawalReportingFilter(GenericReportingFilter reportingFilter) {
    }

    @Override
    public CustomFilter clone() {
        return new WithdrawalReportingFilter(this);
    }

    public void performAFilterPre() {
        CustomFilter customFilter = clone().clone();
        customFilter.clone();
    }
}
