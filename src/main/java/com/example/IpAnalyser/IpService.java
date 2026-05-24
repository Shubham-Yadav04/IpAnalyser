package com.example.IpAnalyser;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class IpService {
    private final List<IpRange>
            ranges =
            new ArrayList<>();

    @PostConstruct
    public void init()
            throws Exception {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(
                                "optimized_country.csv"
                        )
                );

        reader.readLine();

        String line;

        while ((line =
                reader.readLine())
                != null) {

            String[] parts =
                    line.split(",");

            ranges.add(
                    new IpRange(
                            Long.parseLong(
                                    parts[0]
                            ),
                            Long.parseLong(
                                    parts[1]
                            ),
                            parts[2]
                    )
            );
        }

        reader.close();
    }
}
