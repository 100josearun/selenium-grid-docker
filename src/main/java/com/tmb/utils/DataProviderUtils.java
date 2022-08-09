package com.tmb.utils;

import com.github.javafaker.Faker;
import com.tmb.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataSupplier
    public StreamEx<TestData> getData(){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }

    @DataProvider(name = "signupTestDataProvider")
    public static Object[][] getValidData(Method method){
        Faker dataGenerator = new Faker();
        if(method.getName().equalsIgnoreCase("signUpTestWithValidCredentials")) {
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
