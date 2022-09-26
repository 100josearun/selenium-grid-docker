package com.amazon.utils;

import com.amazon.testdata.JsonData;
import com.github.javafaker.Faker;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import io.github.sskorol.data.TestDataReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataSupplier(runInParallel = true)
    public StreamEx<JsonData> getTVData(){
        return TestDataReader.use(JsonReader.class)
                .withTarget(JsonData.class)
                .withSource("testdata.json")
                .read()
                .filter(e->e.getMenu().contains("TV"));
    }

    @DataSupplier(runInParallel = true)
    public StreamEx<JsonData> getMobilesData(){
        return TestDataReader.use(JsonReader.class)
                .withTarget(JsonData.class)
                .withSource("testdata.json")
                .read()
                .filter(e->e.getMenu().contains("Mobiles"));
    }

}
