class RegularStudent extends Student {

    @Override
    public double calculateFee() {
        return getBaseFee();
    }
}