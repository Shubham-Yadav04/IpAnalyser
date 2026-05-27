package com.example.IpAnalyser;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IpAnalysis {
    long start;
    long end;
        String continentCode;
        String continent;
        String countryCode;
        String country;
        Boolean isAnonymousProxy;
        Boolean isSatelliteProvider;
}
