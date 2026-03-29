class ExchangeStudent extends Student {

    @Override
    public double calculateFee() {
        return getBaseFee() + 7000;
    }
}