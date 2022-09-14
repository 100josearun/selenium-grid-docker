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

    @DataProvider(name = "accountSignUp")
    public static Object[][] getValidData(Method method){
        Faker dataGenerator = new Faker();
        if(method.getName().equalsIgnoreCase("dynamic")) {
            return new Object[][]{
                    {dataGenerator.name().fullName(), dataGenerator.internet().emailAddress(), dataGenerator.internet().password(8, 15, true, true, true)}
            };
        }else{
            return new Object[][]{
                    {dataGenerator.name().fullName(), "jerry@google.com", dataGenerator.internet().password(8, 15, true, true, true)},
                    {dataGenerator.name().fullName(), dataGenerator.internet().emailAddress(), dataGenerator.internet().password(3, 6)},
            };
        }
    }
}
