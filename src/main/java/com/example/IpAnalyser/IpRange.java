package com.example.IpAnalyser;

public class IpRange {
    long start;
    long end;
    String countryCode;

    public IpRange(
            long start,
            long end,
            String countryCode
    ) {
        this.start = start;
        this.end = end;
        this.countryCode =
                countryCode;
    }
}
