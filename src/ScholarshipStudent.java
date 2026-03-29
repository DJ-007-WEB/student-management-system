class ScholarshipStudent extends Student {

    @Override
    public double calculateFee() {
        return getBaseFee() * 0.8;
    }
}