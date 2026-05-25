package com.example.IpAnalyser;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class IpService {
    private final List<IpAnalysis> ranges = new ArrayList<>();

    @PostConstruct
    public void init()
            throws Exception {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(
                                "src/main/resources/static/optimized_country.csv"
                        )
                );

        reader.readLine();

        String line;

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");
            ranges.add(new IpAnalysis(
                    Long.parseLong(parts[1]), // start_ip
                    Long.parseLong(parts[2]), // end_ip
                    parts[4], // continent_Code
                    parts[5],                 // continent_name
                    parts[6],                 // country_iso_code
                    parts[7],                 // country_name
                    !parts[8].equals("0"),                 // is_anonymous_proxy
                    !parts[9].equals("0")                  // is_satellite_provider
            ));
        }

        reader.close();
    }


    public Long ipToLong(String ip){
        String []parts= ip.split("\\.");
        long result=0L;
        for(String part:parts){
            result= result*256 +Integer.parseInt(part);
        }
        return result;

    }

    public IpAnalysis getCountry(
            String ip) {

        long ipLong =
                ipToLong(ip);

        int left = 0;
        int right =
                ranges.size() - 1;

        while (left <= right) {

            int mid =
                    left
                            + (right - left)
                            / 2;

            IpAnalysis current =
                    ranges.get(mid);

            if (ipLong
                    < current.start) {

                right =
                        mid - 1;
            }

            else if (ipLong
                    > current.end) {

                left =
                        mid + 1;
            }

            else {
                return
                        current;
            }
        }

        return IpAnalysis.builder().build();
    }
}
